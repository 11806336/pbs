package com.pbs.ams.web.controller.account;


import com.google.common.collect.Maps;
import com.pbs.ams.web.controller.BaseController;
import com.pbs.ams.common.constant.UpmsResult;
import com.pbs.ams.common.constant.StatusCode;
import com.pbs.ams.common.util.IdGeneratorUtil;
import com.pbs.ams.web.model.AmsTradeAccount;
import com.pbs.ams.web.model.UpmsUser;
import com.pbs.ams.web.service.AmsBrokerService;
import com.pbs.ams.web.service.AmsProductService;
import com.pbs.ams.web.service.AmsTradeAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    private AmsBrokerService amsBrokerService;

    @Autowired
    private AmsProductService amsProductService;

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

    @ApiOperation(value = "删除账号")
    @RequiresPermissions("upms:account:delete")
    @RequestMapping(value = "/delete/{ids}", method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        if (StringUtils.isNotEmpty(ids)) {
                String[] tradeAccountId = ids.split("-");
                List<Long> idList = new ArrayList<Long>();
                for (String id : tradeAccountId) {
                    idList.add(Long.parseLong(id));
                }
            int count = amsTradeAccountService.deleteByPrimaryKeys(idList);
            return new UpmsResult(StatusCode.SUCCESS, count);
        }
        return 0;
    }


    @ApiOperation(value = "新增账号")
    @RequiresPermissions("upms:account:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(HttpServletRequest request) {
        Map<String, Object> params = Maps.newHashMap();
        List<Map> amsProducts = amsProductService.selectProductWithDetail(params);
        List<Map> amsBrokers =amsBrokerService.selectBrokerWithDetail(params);
        request.setAttribute("amsProducts",amsProducts);
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
        amsTradeAccount.setTradeAccountId(tradeAccountId);
        Long companyId=getCurrentUser().getCompanyId();
        if (companyId==null){
            amsTradeAccount.setCompanyId((long)0);
        }
        amsTradeAccount.setTradeAccountType(true);
        amsTradeAccount.setOperatorId(getCurrentUser().getUserId());
        int count = amsTradeAccountService.insertSelective(amsTradeAccount);
        return new UpmsResult(StatusCode.SUCCESS, count);
    }


    @ApiOperation(value = "修改账号")
    @RequiresPermissions("upms:account:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") long id, HttpServletRequest request) {
        AmsTradeAccount amsTradeAccount = amsTradeAccountService.selectByPrimaryKey(id);
        Map<String, Object> params = Maps.newHashMap();
        request.setAttribute("amsStockAccount", amsTradeAccount);
        return "/account/update_account_base.jsp";
    }

    @ApiOperation(value = "修改账号")
    @RequiresPermissions("upms:account:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable("id") long id, AmsTradeAccount amsTradeAccount) {
//        ComplexResult result = FluentValidator.checkAll()
//                .on(amsTradeAccount.getTradeAccountName(),new LengthValidator(1, 20, "名称"))
//                .on(upmsCompany.getTitle(),  new NotNullValidator("姓名"))
//                .doValidate()
//                .result(ResultCollectors.toComplex());
//        if (!result.isSuccess()) {
//            return new UpmsResult(UpmsResultConstant.INVALID_LENGTH, result.getErrors());
//        }
        amsTradeAccount.setTradeAccountId(id);
        int count = amsTradeAccountService.updateByPrimaryKeySelective(amsTradeAccount);
        return new UpmsResult(StatusCode.SUCCESS, count);
    }

    @ApiOperation(value = "修改账号")
    @RequiresPermissions("upms:account:read")
    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String details(@PathVariable("id") long id, HttpServletRequest request) {
        AmsTradeAccount amsTradeAccount = amsTradeAccountService.selectByPrimaryKey(id);
        request.setAttribute("amsStockAccount", amsTradeAccount);
        return "/account/tab.jsp";
    }
    @ApiOperation(value = "返回不同的tab页")
    @RequiresPermissions("upms:account:read")
    @RequestMapping(value = "/details/tab/{iframeName}", method = RequestMethod.GET)
    public String details(HttpServletRequest request, @PathVariable("iframeName") String iframeName) {
        if (null != iframeName) {
            return "/account/" + iframeName + ".jsp";
        }
        return null;
    }
}
