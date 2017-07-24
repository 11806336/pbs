package com.pbs.ams.web.controller.product;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.pbs.ams.common.annotation.Log;
import com.pbs.ams.common.constant.ResultSet;
import com.pbs.ams.common.constant.StatusCode;
import com.pbs.ams.common.constant.UpmsConstant;
import com.pbs.ams.common.util.CheckIsDeleteUtil;
import com.pbs.ams.common.util.DateUtil;
import com.pbs.ams.common.util.ExcelUtil;
import com.pbs.ams.common.util.IdGeneratorUtil;
import com.pbs.ams.common.validator.LengthValidator;
import com.pbs.ams.web.controller.BaseController;
import com.pbs.ams.web.model.*;
import com.pbs.ams.web.service.*;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.ParseException;
import java.util.*;

/**
 * Created by TiAmo on 17/6/23.
 */
@Controller
@Api(value = "产品基本信息", description = "产品基本信息")
@RequestMapping(value = "/product")
public class AmsProductBasicController extends BaseController {

    @Autowired
    private AmsProductService amsProductService;

    @Autowired
    private UpmsCompanyService upmsCompanyService;

    @Autowired
    private AmsTradeAccountService amsTradeAccountService;

    @Autowired
    private UpmsCompanyUserService upmsCompanyUserService;

    @Autowired
    private UpmsUserService upmsUserService;

    @Autowired
    private AmsProductUserService amsProductUserService;

    @Autowired
    private AmsTradeAccountExtService amsTradeAccountExtService;

    @Autowired
    private AmsStockHoldingService amsStockHoldingService;

    @Autowired
    private AmsBrokerService amsBrokerService;
    @Log(value = "产品管理首页")
    @RequiresPermissions("ams:product:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/product/index.jsp";
    }

    @Log(value = "产品列表")
    @RequiresPermissions("ams:product:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search) {

        UpmsUser user = getCurrentUser();
        Map<String, Object> result = new HashMap<String, Object>();
        if (user != null) {
            Map<String,Object> map = Maps.newHashMap();
            map.put("offset",offset);
            map.put("limit",limit);
            if (!StringUtils.isBlank(search)) {
                map.put("search",search);
            }
            List<UpmsCompanyUser> upmsCompanies = getCompanyByUserId();//查询当前用户的关联公司
            List<Long> companyIds = new ArrayList<Long>();//存放公司id
            for (UpmsCompanyUser companyUser : upmsCompanies) {
                companyIds.add(companyUser.getCompanyId());
            }
            map.put("companyIds", companyIds);
            List<Map> rows = amsProductService.selectProduct(map);
            long total = amsProductService.selectProductCount(map);
            result.put("rows", rows);
            result.put("total", total);
        }
        return result;
    }
    @Log(value = "更改账号状态")
    @RequiresPermissions("ams:product:read")
    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object updateProductStatus(@PathVariable("id") Long id, String status) {
        if (null != id && null != status) {
            if (status.equals("false")) {
                status = "1";
            } else {
                status = "0";
            }
        }
        AmsProduct amsProduct = new AmsProduct();
        amsProduct.setProductId(id);
        int count = amsProductService.updateProductStatusById(id, Integer.parseInt(status));
        return new ResultSet(StatusCode.ERROR_NONE, count);
    }

    @Log(value = "新增产品页")
    @RequiresPermissions("ams:product:read")
    @RequestMapping(value = "/createProduct", method = RequestMethod.GET )
    public String createProduct(HttpServletRequest request) {
        UpmsUser user = getCurrentUser();
        Long userId = user.getUserId();
        List<UpmsCompany> upmsCompanies =upmsCompanyService.selectCompanyByUserId(userId);//获取当前的所属公司
        List<Map> listMap = Lists.newArrayList();
        List<Long> companyIds = new ArrayList<Long>();
        for(UpmsCompany upmsCompany : upmsCompanies){
            listMap.add(objectToMap(upmsCompany));
            companyIds.add(upmsCompany.getCompanyId());//将id存放
        }
        List<UpmsCompanyUser> upmsCompanyUsers = upmsCompanyUserService.getUsersByCompanyId(companyIds);//获取公司下的全部用户
        List<Long> userIds = new ArrayList<Long>();
        for (UpmsCompanyUser uc : upmsCompanyUsers) {
            userIds.add(uc.getUserId());
        }
        List<UpmsUser> users = upmsUserService.selectUsersById(userIds);
        request.setAttribute("upmsCompanies",listMap);
        request.setAttribute("users",users);
        return "/product/create/create_product.jsp";
    }


    @Log(value = "新增产品")
    @RequiresPermissions("ams:product:read")
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST )
    public Object create(AmsProduct amsProduct, Long userId, Long companyId,
                         String beginDate,String finishDate) {
        //获取session,取当前用户
        Session session = SecurityUtils.getSubject().getSession();
        UpmsUser upmsUser = (UpmsUser) session.getAttribute("user");
        if (upmsUser != null) {
            amsProduct.setOperatorId(upmsUser.getUserId());
            amsProduct.setO32Id(upmsUser.getUserId());
        }
        ComplexResult result = FluentValidator.checkAll()
                .on(amsProduct.getProductName(), new LengthValidator(1, 20, "产品名称"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess() || userId == null) {
            return new ResultSet(StatusCode.ERROR_NONE, result.getErrors());
        }
        long id = IdGeneratorUtil.getKey("ams_product", 1000);
        amsProduct.setProductId(id);
        //向产品用户关系表中存入关系
        AmsProductUser amsProductUser = new AmsProductUser();
        amsProductUser.setProductUserId(IdGeneratorUtil.getKey("ams_product_user"));
        amsProductUser.setUserId(userId);
        amsProductUser.setProductId(id);
        amsProduct.setStartDate(DateUtil.removeDateSymbol(beginDate));
        amsProduct.setEndDate(DateUtil.removeDateSymbol(finishDate));
        int count = amsProductService.insertProductAndUserRelation(amsProduct, amsProductUser);
        if (count > 0) {
            return new ResultSet(StatusCode.ERROR_NONE);
        }
        return new ResultSet(StatusCode.SQL_ERROR);
    }

    @Log(value = "产品详情")
    @RequiresPermissions("ams:product:read")
    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String details(@PathVariable("id") long id, HttpServletRequest request) {
        AmsProduct amsProduct = amsProductService.selectByPrimaryKey(id);
        request.setAttribute("amsProduct", amsProduct);
        return "/product/query/query_product_tabs.jsp";
    }

    @Log(value = "详情tab页")
    @RequiresPermissions("ams:product:read")
    @RequestMapping(value = "/details/tab/{iframeName}/{id}", method = RequestMethod.GET)
    public String details(HttpServletRequest request, @PathVariable("iframeName") String iframeName, @PathVariable("id") Long id) {
        if (null != iframeName) {
            AmsProduct amsProduct = amsProductService.selectByPrimaryKey(id);
            request.setAttribute("amsProduct", amsProduct);
            return "/product/query/" + iframeName + ".jsp";
        }
        return null;
    }

    @Log(value = "总览列表")
    @RequiresPermissions("ams:product:read")
    @RequestMapping(value = "/overview", method = RequestMethod.GET)
    @ResponseBody
    public Object  positionList(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("offset", offset);
        params.put("limit", limit);
        List<Map> rows = amsTradeAccountExtService.selectAmsTradeAccountExtWithDetail(params);
        long total = amsTradeAccountExtService.selectAmsTradeAccountExtWithDetailCount(params);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", rows);
        return result;
    }

    @Log(value = "持仓列表")
    @RequiresPermissions("upms:account:read")
    @RequestMapping(value = "/stockHolding", method = RequestMethod.GET)
    @ResponseBody
    public Object  positionList(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "positionDate") String position_date) {
        Map<String, Object> params = Maps.newHashMap();
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(position_date)) {
            Long date = Long.parseLong(position_date.replaceAll("-",""));
            params.put("positionDate",date);
        }
        params.put("offset", offset);
        params.put("limit", limit);
        List<Map> rows = amsStockHoldingService.selectStockHoldingWithDetail(params);
        long total = amsStockHoldingService.selectStockHoldingWithDetailCount(params);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", rows);
        return result;
    }

//    @Log(value = "指令列表")
//    @RequiresPermissions("ams:product:read")
//    @RequestMapping(value = "/stockHolding", method = RequestMethod.GET)
//    @ResponseBody
//    public Object  positionList(
//            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
//            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit) {
//        Map<String, Object> params = Maps.newHashMap();
//        params.put("offset", offset);
//        params.put("limit", limit);
//        List<Map> rows = amsTradeAccountService.selectTradeAccoutWithDetail(params);
//        long total = amsTradeAccountService.selectTradeAccoutWithDetailCount(params);
//        Map<String, Object> result = new HashMap<String, Object>();
//        result.put("total", total);
//        result.put("rows", rows);
//        return result;
//    }


//    @Log(value = "编辑tab页")
//    @RequiresPermissions("ams:product:read")
//    @RequestMapping(value = "/update/tab/{iframeName}/{id}", method = RequestMethod.GET)
//    public String updateTab(ModelMap modelMap, @PathVariable("iframeName") String iframeName, @PathVariable("id") Long id) {
//        if (null != iframeName) {
//
//        }
//        return null;
//    }
    @Log(value = "编辑产品")
    @RequiresPermissions("ams:product:read")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") long id,ModelMap modelMap) throws ParseException {
        AmsProduct amsProduct = amsProductService.selectByPrimaryKey(id);
        modelMap.put("amsProduct", amsProduct);
        //从中间表查询关联的用户
        AmsProductUser amsProductUser = new AmsProductUser();
        amsProductUser.setProductId(id);
        List<AmsProductUser> amsProductUsers = amsProductUserService.select(amsProductUser);
        if (amsProductUsers != null && amsProductUsers.size() > 0) {
            modelMap.put("amsProductUsers", amsProductUsers.get(0)); //暂时一对一
        }
        List<UpmsCompany> upmsCompanies =upmsCompanyService.selectCompanyByUserId(getCurrentUser().getUserId());//获取当前的所属公司
        List<Long> companyIds = new ArrayList<Long>();
        for(UpmsCompany upmsCompany : upmsCompanies){
            companyIds.add(upmsCompany.getCompanyId());//将id存放
        }
        List<UpmsCompanyUser> upmsCompanyUsers = upmsCompanyUserService.getUsersByCompanyId(companyIds);//获取公司下的全部用户
        List<Long> userIds = new ArrayList<Long>();
        for (UpmsCompanyUser uc : upmsCompanyUsers) {
            userIds.add(uc.getUserId());
        }
        List<UpmsUser> users = upmsUserService.selectUsersById(userIds);
        modelMap.put("endDate", DateUtil.divideDate(amsProduct.getEndDate()));
        modelMap.put("startDate", DateUtil.divideDate(amsProduct.getStartDate()));
        modelMap.put("users",users);
        modelMap.put("upmsCompanies",upmsCompanies);
        modelMap.put("date", DateUtil.divideDate(amsProduct.getEndDate()));
        return  "/product/edit/update_product.jsp";
    }

    @Log(value = "修改产品")
    @RequiresPermissions("ams:product:read")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable("id") long id,ModelMap modelMap, AmsProduct amsProduct, Long userId,
                         String beginDate,String finishDate) {
        amsProduct.setStartDate(DateUtil.removeDateSymbol(beginDate));
        amsProduct.setEndDate(DateUtil.removeDateSymbol(finishDate));
        ComplexResult result = FluentValidator.checkAll()
                .on(amsProduct.getProductName(), new LengthValidator(1, 20, "名称"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess() || userId == null) {
            return new ResultSet(StatusCode.EMPTY_USERNAME);
        }
        AmsProductUser productUser = new AmsProductUser();
        productUser.setProductId(id);
        List<AmsProductUser> amsProductUsers = amsProductUserService.select(productUser);
        productUser.setProductUserId(amsProductUsers.get(0).getProductUserId());
        productUser.setUserId(userId);//修改后的user
        int count = amsProductService.updateProductAndUserRelation(amsProduct, productUser);
        if (count > 0) {
            return new ResultSet(StatusCode.ERROR_NONE);
        }
        return new ResultSet(StatusCode.SQL_ERROR);
    }

    @Log(value = "删除产品")
    @RequiresPermissions("ams:product:read")
    @RequestMapping(value = "/delete/{ids}", method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            int count = 0;
            String[] productIds = ids.split("-");
            List<Long> idList = new ArrayList<Long>();
            for (String id : productIds) {
                Long pId = Long.parseLong(id);
                if (CheckIsDeleteUtil.isDelete(UpmsConstant.PRODUCT, pId)) {//可以删除
                    idList.add(pId);
                } else {
                    return new ResultSet(StatusCode.FAILD_DELETE);
                }
            }
            count = amsProductService.deleteByPrimaryKeys(idList);
            return new ResultSet(StatusCode.ERROR_NONE,count);
        }
        return 0;
    }

    @Log(value = "导出数据")
    @RequiresPermissions("ams:product:read")
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public ResponseEntity<byte[]> exportExcel(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> params = Maps.newHashMap();
        List<Map> rows = amsProductService.selectProduct(params);
        if (rows != null) {//当查询出结果的时候
            int rowSize = rows.size();//行数
            HSSFWorkbook workbook = new HSSFWorkbook();//创建excel文件
            HSSFSheet sheet = ExcelUtil.createSheet(workbook, "产品信息");
            Map<String, Object> product = rows.get(0);//取出第一行  方便长度的计算
            final int cellSize = product.size();//单元格数   字段
            Object[][] value = new Object[rowSize][cellSize];//初始化一个二维数组
            for (int i = 0; i < rowSize; i++) {
                Map<String, Object> ac = rows.get(i);
                for (int j = 0; j < cellSize; j++) {
                    for (Iterator<Map.Entry<String, Object>> it = ac.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, Object> entry = it.next();
                        value[i][j] = entry.getValue();
                        it.remove();
                        break;
                    }
                }
            }
            try {
                String fileName = new Date().getTime() + ".xls";
                response.reset();
                response.setContentType("application/x-xls;charset=utf-8");
                response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "iso-8859-1"));
                String[] title = {"product_id", "company_id", "product_name", "product_type", "product_code", "product_manager", "product_supervisor",
                        "product_status", "product_share_source", "start_date", "end_date", "product_shares", "product_desc",
                        "create_time", "update_time", "operator_id", "o32_id"};
                ExcelUtil.writeArrayToExcel(title, workbook, sheet, rowSize, cellSize, value);
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                workbook.write(os);
                byte[] content = os.toByteArray();
                InputStream is = new ByteArrayInputStream(content);
                ServletOutputStream out = response.getOutputStream();
                ExcelUtil.writeExceltoOutpurStream(is, out);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
