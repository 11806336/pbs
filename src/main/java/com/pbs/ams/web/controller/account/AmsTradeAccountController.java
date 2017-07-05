package com.pbs.ams.web.controller.account;


import com.google.common.collect.Maps;
import com.pbs.ams.common.base.BaseController;
import com.pbs.ams.common.constant.UpmsResult;
import com.pbs.ams.common.constant.UpmsResultConstant;
import com.pbs.ams.common.util.IdGeneratorUtil;
import com.pbs.ams.web.model.AmsTradeAccount;
import com.pbs.ams.web.model.UpmsUser;
import com.pbs.ams.web.service.AmsBrokerService;
import com.pbs.ams.web.service.AmsPlatformService;
import com.pbs.ams.web.service.AmsTradeAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private AmsPlatformService amsPlatformService;

    @Autowired
    private AmsBrokerService amsBrokerService;

    @ApiOperation(value = "账号首页")
    @RequiresPermissions("upms:account:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/account/account.jsp";
    }

    @ApiOperation(value = "账号列表")
    @RequiresPermissions("upms:account:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order, HttpServletRequest request) {
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

//    @ApiOperation(value = "删除账号")
//    @RequiresPermissions("upms:account:delete")
//    @RequestMapping(value = "/delete/{ids}", method = RequestMethod.GET)
//    @ResponseBody
//    public Object delete(@PathVariable("ids") String ids) {
//        int count = amsStockAccountService.deleteByPrimaryKeys(ids);
//        return new UpmsResult(UpmsResultConstant.SUCCESS, count);
//    }
//

    @ApiOperation(value = "新增账号")
    @RequiresPermissions("upms:account:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(HttpServletRequest request) {
        Map<String, Object> params = Maps.newHashMap();
        List<Map> amsPlatforms =amsPlatformService.selectPlatformWithDetail(params);
        List<Map> amsBrokers =amsBrokerService.selectBrokerWithDetail(params);
        request.setAttribute("amsPlatforms",amsPlatforms);
        request.setAttribute("amsBrokers",amsBrokers);
        return "/account/create_account_base.jsp";
    }


    /**
     *
     * @param amsTradeAccount
     * @return
     */
    @ApiOperation(value = "新增账号")
    @RequiresPermissions("upms:account:create")
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Object create(AmsTradeAccount amsTradeAccount) {
//        ComplexResult result = FluentValidator.checkAll()
//                .on(amsTradeAccount.getTradeAccountName(), new LengthValidator(1, 20, "名称"))
//                .doValidate()
//                .result(ResultCollectors.toComplex());
//        if (!result.isSuccess()) {
//            return new UpmsResult(UpmsResultConstant.INVALID_LENGTH, result.getErrors());
//        }

        Long tradeAccountId = IdGeneratorUtil.getKey("ams_trade_account");
        Long companyId=getCurrentUser().getCompanyId();
        if (companyId==null){
            amsTradeAccount.setCompanyId((long)0);
        }
        amsTradeAccount.setTradeAccountId(tradeAccountId);
        amsTradeAccount.setTradeAccountType(true);
        long time = System.currentTimeMillis();
        amsTradeAccount.setCreateTime(time);
        amsTradeAccount.setUpdateTime(time);
        amsTradeAccount.setOperatorId((long)0);
        int count = amsTradeAccountService.insertSelective(amsTradeAccount);
        return new UpmsResult(UpmsResultConstant.SUCCESS, count);
    }


//    @ApiOperation(value = "修改账号")
//    @RequiresPermissions("upms:account:update")
//    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
//    public String update(@PathVariable("id") long id, ModelMap modelMap) {
//        AmsStockAccount amsStockAccount = amsStockAccountService.selectByPrimaryKey(id);
//        modelMap.put("amsStockAccount", amsStockAccount);
//        return "/company/update_company.jsp";
//    }
//
//    @ApiOperation(value = "修改账号")
//    @RequiresPermissions("upms:account:update")
//    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
//    @ResponseBody
//    public Object update(@PathVariable("id") long id, AmsStockAccount amsStockAccount) {
//        ComplexResult result = FluentValidator.checkAll()
//                .on(amsStockAccount.getStockAccountName(), new LengthValidator(1, 20, "名称"))
////                .on(upmsCompany.getTitle(),  new NotNullValidator("姓名"))
//                .doValidate()
//                .result(ResultCollectors.toComplex());
//        if (!result.isSuccess()) {
//            return new UpmsResult(UpmsResultConstant.INVALID_LENGTH, result.getErrors());
//        }
//        amsStockAccount.setStockAccountId(id);
//        int count = amsStockAccountService.updateByPrimaryKeySelective(amsStockAccount);
//        return new UpmsResult(UpmsResultConstant.SUCCESS, count);
//    }
}
