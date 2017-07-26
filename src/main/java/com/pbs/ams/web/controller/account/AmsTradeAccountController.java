package com.pbs.ams.web.controller.account;


import com.google.common.collect.Maps;
import com.pbs.ams.common.annotation.Log;
import com.pbs.ams.common.constant.ResultSet;
import com.pbs.ams.common.constant.StatusCode;
import com.pbs.ams.common.constant.UpmsConstant;
import com.pbs.ams.common.util.CheckUtil;
import com.pbs.ams.common.util.DateUtil;
import com.pbs.ams.common.util.ExcelUtil;
import com.pbs.ams.common.util.IdGeneratorUtil;
import com.pbs.ams.web.controller.BaseController;
import com.pbs.ams.web.model.AmsProductAccount;
import com.pbs.ams.web.model.AmsTradeAccount;
import com.pbs.ams.web.model.UpmsCompany;
import com.pbs.ams.web.model.UpmsUser;
import com.pbs.ams.web.service.*;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * 账号controller
 * Created by ams on 2017/3/14.
 */
@Controller
@Api(value = "账号管理", description = "账号管理")
@RequestMapping("/account")
public class AmsTradeAccountController extends BaseController {

    @Autowired
    private AmsTradeAccountService amsTradeAccountService;

    @Autowired
    private AmsBrokerService amsBrokerService;

    @Autowired
    private UpmsCompanyService upmsCompanyService;

    @Autowired
    private AmsProductService amsProductService;

    @Autowired
    private AmsProductAccountService amsProductAccountService;

    @Autowired
    private AmsStockBlackWhiteListService amsStockBlackWhiteListService;

    @Autowired
    private AmsStockHoldingService amsStockHoldingService;

    @Autowired
    private AmsEntrustService amsEntrustService;

    @Autowired
    private AmsKnockService amsKnockService;

    @Autowired
    private AmsTradeAccountExtService amsTradeAccountExtService;

    @Log(value = "账号首页")
    @RequiresPermissions("upms:account:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/account/account.jsp";
    }

    @Log(value = "账号列表")
    @RequiresPermissions("upms:account:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search) {
        //获取session,取当前用户
        Session session = SecurityUtils.getSubject().getSession();
        Object obj = session.getAttribute("user");
        UpmsUser upmsUser = null;
        if (obj != null) {
            upmsUser = (UpmsUser) session.getAttribute("user");
        }
        Map<String, Object> params = Maps.newHashMap();
        params.put("offset", offset);
        params.put("limit", limit);
        params.put("search",search);
        List<Map> rows = amsTradeAccountService.selectTradeAccoutWithDetail(params);
        long total = amsTradeAccountService.selectTradeAccoutWithDetailCount(params);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("rows", rows);
        result.put("total", total);
        return result;
    }
    @Log(value = "删除账号")
    @RequiresPermissions("upms:account:delete")
    @RequestMapping(value = "/delete/{ids}", method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            String[] tradeAccountId = ids.split("-");
            List<Long> idList = new ArrayList<Long>();
            for (String id : tradeAccountId) {
                Long accountId = Long.parseLong(id);
                if (CheckUtil.canDelete(UpmsConstant.ACCOUNT, accountId)){
                    idList.add(Long.parseLong(id));
                }else {
                    return new ResultSet(StatusCode.FAILD_DELETE);
                }
            }
            int count = amsTradeAccountService.deleteByPrimaryKeys(idList);
            return new ResultSet(StatusCode.ERROR_NONE, count);
        }
        return 0;
    }

    @Log(value = "新增账号")
    @RequiresPermissions("upms:account:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(HttpServletRequest request) {
        Map<String, Object> params = Maps.newHashMap();
        List<Map> amsProducts = amsProductService.selectProductWithDetail(params);
        List<Map> amsBrokers =amsBrokerService.selectBrokerWithDetail(params);
        List<UpmsCompany> upmsCompany = upmsCompanyService.listCompanies(params);
        request.setAttribute("amsProducts",amsProducts);
        request.setAttribute("amsBrokers",amsBrokers);
        request.setAttribute("upmsCompany",upmsCompany);
        return "/account/create_account_base.jsp";
    }
    /**
     *
     * @param amsTradeAccount
     * @return
     */
    @Log(value = "新增账号")
    @RequiresPermissions("upms:account:create")
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Object create(AmsTradeAccount amsTradeAccount, Long productId) {
        Long tradeAccountId = IdGeneratorUtil.getKey("ams_trade_account");
        amsTradeAccount.setTradeAccountId(tradeAccountId);
//        Long companyId=getCurrentUser().getCompanyId();
//        if (companyId==null){
//            amsTradeAccount.setCompanyId((long)0);
//        }
        //构建账号产品关系实体
        AmsProductAccount amsProductAccount = new AmsProductAccount();
        amsProductAccount.setProductId(productId);
        amsProductAccount.setTradeAccountId(amsTradeAccount.getTradeAccountId());
        amsProductAccount.setProductTradeAccountId(IdGeneratorUtil.getKey("ams_product_account"));
        int result = amsProductAccountService.insertSelective(amsProductAccount);
        int count = 0;
        if (result > 0) {
            amsTradeAccount.setOperatorId(getCurrentUser().getUserId());
            count = amsTradeAccountService.insertSelective(amsTradeAccount);
            return new ResultSet(StatusCode.ERROR_NONE, count);
        }
        return new ResultSet(StatusCode.INVALID_INSERT, count);
    }

    @Log(value = "修改账号")
    @RequiresPermissions("upms:account:update")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") long id, HttpServletRequest request) {
        AmsTradeAccount amsTradeAccount = amsTradeAccountService.selectByPrimaryKey(id);
        request.setAttribute("amsTradeAccount", amsTradeAccount);
        return "/account/tab.jsp";
    }

    @Log(value = "修改账号")
    @RequiresPermissions("upms:account:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable("id") Long id,AmsTradeAccount amsTradeAccount) {
        amsTradeAccount.setTradeAccountId(id);
        int count = amsTradeAccountService.updateByPrimaryKeySelective(amsTradeAccount);
        return new ResultSet(StatusCode.ERROR_NONE, count);
    }

    @Log(value = "更改账号状态")
    @RequiresPermissions("upms:account:update")
    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object updateAccountStatus(@PathVariable("id") Long id, String status) {
        if (null != id && null != status) {
            if (status.equals("false")) {
                status = "1";
            } else {
                status = "0";
            }
        }
        AmsTradeAccount amsTradeAccount = new AmsTradeAccount();
        amsTradeAccount.setTradeAccountId(id);
        int count = amsTradeAccountService.updateAccountStatusById(id, Integer.parseInt(status));
        return new ResultSet(StatusCode.ERROR_NONE, count);
    }
    @Log(value = "账号详情")
    @RequiresPermissions("upms:account:read")
    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String details(@PathVariable("id") long id, HttpServletRequest request) {
        AmsTradeAccount amsTradeAccount = amsTradeAccountService.selectByPrimaryKey(id);
        request.setAttribute("amsTradeAccount", amsTradeAccount);
        return "/account/query_tab.jsp";
    }
    @Log(value = "持仓")
    @RequiresPermissions("upms:account:read")
    @RequestMapping(value = "/details/tab/{iframeName}/{id}", method = RequestMethod.GET)
    public String details(HttpServletRequest request, @PathVariable("iframeName") String iframeName, @PathVariable("id") Long id){
        if (null != iframeName && null != id) {
            AmsTradeAccount amsTradeAccount = amsTradeAccountService.selectByPrimaryKey(id);
            request.setAttribute("amsTradeAccount", amsTradeAccount);
//            List<Map> amsStockBlackWhiteList = amsStockBlackWhiteListService.selectProductWithDetail(params);
//            request.setAttribute("amsStockBlackWhiteList",amsStockBlackWhiteList);
            Map<String, Object> params = Maps.newHashMap();
            List<Map> amsProducts = amsProductService.selectProductWithDetail(params);
            List<Map> amsBrokers =amsBrokerService.selectBrokerWithDetail(params);
            AmsProductAccount amsProductAccount =amsProductAccountService.getProductIdByAccountId(id);
            List<UpmsCompany> upmsCompany = upmsCompanyService.listCompanies(params);
            request.setAttribute("amsProducts",amsProducts);
            request.setAttribute("amsBrokers",amsBrokers);
            request.setAttribute("amsProductAccount", amsProductAccount);
            request.setAttribute("upmsCompany",upmsCompany);
            return "/account/" + iframeName + ".jsp";
        }
        return null;
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
        if (StringUtils.isNotEmpty(position_date)) {
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

    @Log(value = "资产列表")
    @RequiresPermissions("upms:account:read")
    @RequestMapping(value = "/amsTradeAccountExt", method = RequestMethod.GET)
    @ResponseBody
    public Object amsTradeAccountExt(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            String dateBegin,String dateEnd) {
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

    @Log(value = "委托列表")
    @RequiresPermissions("upms:account:read")
    @RequestMapping(value = "/entrust", method = RequestMethod.GET)
    @ResponseBody
    public Object assetsList(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            String dateBegin,String dateEnd) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("offset", offset);
        params.put("limit", limit);
        List<Map> rows = amsEntrustService.selectAmsEntrustWithDetail(params);
        long total = amsEntrustService.selectAmsEntrustWithDetailCount(params);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", rows);
        return result;
    }

    @Log(value = "成交列表")
    @RequiresPermissions("upms:account:read")
    @RequestMapping(value = "/amsKnock", method = RequestMethod.GET)
    @ResponseBody
    public Object AmsKnockList(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            String dateBegin,String dateEnd) {
        Map<String, Object> params = Maps.newHashMap();
        if (StringUtils.isNotEmpty(dateBegin)) {
            Long date_begin = Long.parseLong(dateBegin.replaceAll("-",""));
            params.put("dateBegin",date_begin);
        }
        if (StringUtils.isNotEmpty(dateEnd)) {
            Long date_end = Long.parseLong(dateEnd.replaceAll("-",""));
            params.put("dateEnd",date_end);
        }
        params.put("offset", offset);
        params.put("limit", limit);
        List<Map> rows = amsKnockService.selectAmsKnockWithDetail(params);
        long total = amsKnockService.selectAmsKnockWithDetailCount(params);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", rows);
        return result;
    }

    @Log(value = "导出数据")
    @RequiresPermissions("upms:account:read")
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public ResponseEntity<byte[]> exportExcel(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> params = Maps.newHashMap();
        List<Map> rows = amsTradeAccountService.selectTradeAccoutWithDetail(params);
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
                        if(entry.getKey().equals("create_time") || entry.getKey().equals("update_time")){
                            entry.setValue(DateUtil.divideDate(Long.parseLong(entry.getValue().toString())));
                        }else if(entry.getKey().equals("trade_account_status")){
//
                            for(int k=0;k<entry.getKey().length();k++){
                                if(entry.getValue().equals(true)){
                                    entry.setValue("启用");
                                }else{
                                    entry.setValue("冻结");
                                }
//                                entry.getValue().equals("true") ? entry.setValue("启用") : entry.setValue("停用");
                            }
                        }
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
                String[] title = {"账号ID", "公司ID", "交易账号", "账号名称",
                        "密码", "证券公司ID", "账号状态", "创建时间",
                        "修改时间","操作人ID"};
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
