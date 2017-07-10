package com.pbs.ams.web.controller.product;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.pbs.ams.common.constant.StatusCode;
import com.pbs.ams.common.constant.UpmsResult;
import com.pbs.ams.common.util.ExcelUtil;
import com.pbs.ams.common.util.IdGeneratorUtil;
import com.pbs.ams.common.validator.LengthValidator;
import com.pbs.ams.web.controller.BaseController;
import com.pbs.ams.web.model.AmsProduct;
import com.pbs.ams.web.model.UpmsCompany;
import com.pbs.ams.web.model.UpmsUser;
import com.pbs.ams.web.service.AmsProductService;
import com.pbs.ams.web.service.UpmsCompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by TiAmo on 17/6/23.
 */
@Controller
@Api(value = "产品管理", description = "产品管理")
@RequestMapping(value = "/product")
public class AmsProductController extends BaseController {

    @Autowired
    private AmsProductService amsProductService;
    @Autowired
    private UpmsCompanyService upmsCompanyService;

    @ApiOperation(value = "产品管理首页")
    @RequiresPermissions("ams:product:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/product/index.jsp";
    }

    @ApiOperation(value = "产品列表")
    @RequiresPermissions("ams:product:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search) {

        UpmsUser user = getCurrentUser();
        Map<String,Object> map = Maps.newHashMap();
        map.put("offset",offset);
        map.put("limit",limit);
        if (!StringUtils.isBlank(search)) {
            map.put("search",search);
        }
        if (user != null) {
            if (!user.isSuperUser()) {//如果是超级管理员的话查询全部，否则带上公司进行查询
                map.put("companyId", user.getCompanyId());
            }
        }
        List<Map> rows = amsProductService.selectProductWithDetail(map);

        long total = amsProductService.selectProductWithDetailCount(map);

        Map<String, Object> result = new HashMap<>();
        result.put("rows", rows);
        result.put("total", total);
        return result;
    }


    @ApiOperation(value = "新增产品页")
    @RequiresPermissions("ams:product:read")
    @RequestMapping(value = "/createProduct", method = RequestMethod.GET )
    public String createProduct(HttpServletRequest request) {
        UpmsUser user = getCurrentUser();
        List<UpmsCompany> upmsCompanies =upmsCompanyService.selectCompanyByUserId(user.getUserId());
        List<Map> listMap = Lists.newArrayList();
        for(UpmsCompany upmsCompany : upmsCompanies){
            listMap.add(objectToMap(upmsCompany));
        }
        request.setAttribute("upmsCompanies",listMap);
        return "/product/create/create_product.jsp";
    }


    @ApiOperation(value = "新增产品")
    @RequiresPermissions("ams:product:read")
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST )
    public Object create(HttpServletRequest request,AmsProduct amsProduct) {
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
        if (!result.isSuccess()) {
            return new UpmsResult(StatusCode.INVALID_LENGTH, result.getErrors());
        }
        long id = IdGeneratorUtil.getKey("ams_product", 1000);
        amsProduct.setProductId(id);
        int count = amsProductService.insertSelective(amsProduct);
        return new UpmsResult(StatusCode.SUCCESS, count);
    }

    @ApiOperation(value = "账号详情")
    @RequiresPermissions("upms:account:read")
    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String details(@PathVariable("id") long id, HttpServletRequest request) {
        return "/product/create/tab.jsp";
    }
    @ApiOperation(value = "返回不同的tab页")
    @RequiresPermissions("upms:account:read")
    @RequestMapping(value = "/details/tab/{iframeName}", method = RequestMethod.GET)
    public String details(HttpServletRequest request, @PathVariable("iframeName") String iframeName) {
        if (null != iframeName) {
            return "/product/" + iframeName + ".jsp";
        }
        return null;
    }


//    @ApiOperation(value = "新增产品导航")
//    @RequiresPermissions("ams:product:create")
//    @RequestMapping(value = "/create/tab", method = RequestMethod.GET)
//    public String create() {
//        return "/product/create/tab.jsp";
//    }
//
//
//
//    @ApiOperation(value = "设置账号页")
//    @RequiresPermissions("ams:product:create")
//    @RequestMapping(value = "/accountSettings", method = RequestMethod.GET)
//    public String accountSettings() {
//        return "/product/create/product_account_settings.jsp";
//    }
//
//
//
//    @ApiOperation(value = "绑定账号")
//    @RequiresPermissions("ams:product:create")
//    @ResponseBody
//    @RequestMapping(value = "/bindAccount", method = RequestMethod.GET)
//    public int bindAccount(AmsProductAccount amsProductAccount) {
//        Long id = IdGeneratorUtil.getKey("ams_product_account");
//        amsProductAccount.setProductTradeAccountId(id);
//        return amsProductService.insertAmsProductAccount(amsProductAccount);
//    }




    @ApiOperation(value = "修改组织")
    @RequiresPermissions("ams:product:read")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") long id, ModelMap modelMap) {
        AmsProduct amsProduct = amsProductService.selectByPrimaryKey(id);
        modelMap.put("amsProduct", amsProduct);
        return  "/product/edit/update_product.jsp";
    }

    @ApiOperation(value = "修改组织")
    @RequiresPermissions("ams:product:read")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable("id") long id, AmsProduct amsProduct) {
        ComplexResult result = FluentValidator.checkAll()
                .on(amsProduct.getProductName(), new LengthValidator(1, 20, "名称"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess()) {
            return new UpmsResult(StatusCode.INVALID_LENGTH, result.getErrors());
        }
        int count = amsProductService.updateByPrimaryKeySelective(amsProduct);
        return new UpmsResult(StatusCode.SUCCESS, count);
    }

    @ApiOperation(value = "删除组织")
    @RequiresPermissions("ams:product:read")
    @RequestMapping(value = "/delete/{ids}", method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            int count = 0;
            String[] productIds = ids.split(",");
            List<Long> idList = new ArrayList<Long>();
            for (String id : productIds) {
                idList.add(Long.parseLong(id));
                count = amsProductService.deleteByPrimaryKeys(id);
            }
            return new UpmsResult(StatusCode.SUCCESS, count);
        }
        return 0;
    }

    @ApiOperation(value = "导出数据")
    @RequiresPermissions("ams:product:read")
    @RequestMapping(value = "/export", method = RequestMethod.POST)
    public ResponseEntity<byte[]> exportExcel(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> params = Maps.newHashMap();
        List<Map> rows = amsProductService.selectProductWithDetail(params);
        if (rows != null) {//当查询出结果的时候
            int rowSize = rows.size();//行数
            HSSFWorkbook workbook = new HSSFWorkbook();//创建excel文件
            HSSFSheet sheet = ExcelUtil.createSheet(workbook, "证券帐号");
            Map<String, Object> account = rows.get(0);//取出第一行  方便长度的计算
            final int cellSize = account.size();//单元格数   字段
            Object[][] value = new Object[rowSize][cellSize];//初始化一个二维数组
            for (int i = 0; i < rowSize; i ++) {
                Map<String, Object> ac = rows.get(i);
                for (int j = 0; j < cellSize; j ++) {
                    for (Iterator<Map.Entry<String, Object>> it = ac.entrySet().iterator(); it.hasNext();) {
                        Map.Entry<String, Object> entry = it.next();
                        value[i][j] = entry.getValue();
                        it.remove();
                        break;
                    }
                }
            }
            HSSFRow row0 =sheet.createRow(0);
            String[] title = {"No","产品名称","产品类型","产品代码","产品经理","产品状态","产品净值","单位净值","产品份额","证券总资产",
            "证券总市值","股票总市值","空单总市值","创建人","创建时间"};
            ExcelUtil.writeArrayToExcel(title,workbook,sheet, rowSize, cellSize, value);
            ExcelUtil.writeWorkbook(workbook, "D://1.xls");
        }
        return null;
    }
}
