//package com.pbs.ams.web.controller.account;
//
//
//import com.baidu.unbiz.fluentvalidator.ComplexResult;
//import com.baidu.unbiz.fluentvalidator.FluentValidator;
//import com.baidu.unbiz.fluentvalidator.ResultCollectors;
//import com.pbs.ams.web.controller.BaseController;
//import com.pbs.ams.common.constant.UpmsResult;
//import com.pbs.ams.common.constant.StatusCode;
//import com.pbs.ams.common.util.IdGeneratorUtil;
//import com.pbs.ams.common.validator.LengthValidator;
//import com.pbs.ams.web.model.AmsStockAccount;
//import com.pbs.ams.web.model.AmsStockAccountExample;
//import com.pbs.ams.web.model.UpmsUser;
//import com.pbs.ams.web.service.AmsStockAccountService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.apache.commons.lang.StringUtils;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.apache.shiro.session.Session;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * 账号controller
// * Created by ams on 2017/3/14.
// */
//@Controller
//@Api(value = "账号管理", description = "账号管理")
//@RequestMapping("/account")
//public class AmsStockAccountController extends BaseController {
//
//    @Autowired
//    private AmsStockAccountService amsStockAccountService;
//
//    @ApiOperation(value = "账号首页")
//    @RequiresPermissions("upms:account:read")
//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    public String index() {
//        return "/account/account.jsp";
//    }
//
//    @ApiOperation(value = "账号列表")
//    @RequiresPermissions("upms:account:read")
//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    @ResponseBody
//    public Object list(
//            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
//            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
//            @RequestParam(required = false, defaultValue = "", value = "search") String search,
//            @RequestParam(required = false, value = "sort") String sort,
//            @RequestParam(required = false, value = "order") String order, HttpServletRequest request) {
//        //获取session,取当前用户
//        Session session = SecurityUtils.getSubject().getSession();
//        Object obj = session.getAttribute("user");
//        UpmsUser upmsUser = null;
//        if (obj != null) {
//            upmsUser = (UpmsUser) session.getAttribute("user");
//        }
//        AmsStockAccountExample accountExample = new AmsStockAccountExample();
//        accountExample.setOffset(offset);
//        accountExample.setLimit(limit);
//        if (!StringUtils.isBlank(sort) && !StringUtils.isBlank(order)) {
//            accountExample.setOrderByClause(sort + " " + order);
//        }
//        if (StringUtils.isNotBlank(search)) {//根据账号名称进行模糊查询
//            accountExample.or().andStockAccountNameEqualTo("%" + search + "%");
//        }
//        if (upmsUser != null) {
//            if (!upmsUser.isSuperUser()) {//如果是超级管理员的话查询全部，否则带上账号进行查询
//                accountExample.or().andCompanyIdEqualTo(upmsUser.getCompanyId());
//            }
//        }
//        List<AmsStockAccount> rows = amsStockAccountService.selectByExample(accountExample);
//        long total = amsStockAccountService.countByExample(accountExample);
//        Map<String, Object> result = new HashMap<String, Object>();
//        result.put("rows", rows);
//        result.put("total", total);
//        return result;
//    }
//
//    @ApiOperation(value = "删除账号")
//    @RequiresPermissions("upms:account:delete")
//    @RequestMapping(value = "/delete/{ids}", method = RequestMethod.GET)
//    @ResponseBody
//    public Object delete(@PathVariable("ids") String ids) {
//        int count = amsStockAccountService.deleteByPrimaryKeys(ids);
//        return new UpmsResult(StatusCode.SUCCESS, count);
//    }
//
//
//    @ApiOperation(value = "新增账号")
//    @RequiresPermissions("upms:account:create")
//    @RequestMapping(value = "/create", method = RequestMethod.GET)
//    public String create() {
//        return "/jsp/account/create_account_base.jsp";
//    }
//
//    @ApiOperation(value = "新增账号")
//    @RequiresPermissions("upms:account:create")
//    @ResponseBody
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public Object create(AmsStockAccount amsStockAccount) {
//        ComplexResult result = FluentValidator.checkAll()
//                .on(amsStockAccount.getStockAccountName(), new LengthValidator(1, 20, "名称"))
//                .doValidate()
//                .result(ResultCollectors.toComplex());
//        if (!result.isSuccess()) {
//            return new UpmsResult(StatusCode.INVALID_LENGTH, result.getErrors());
//        }
//        long time = System.currentTimeMillis();
//        amsStockAccount.setCreateTime(time);
//        Long id = IdGeneratorUtil.getKey("upms_company");
//        amsStockAccount.setCompanyId(id);//获取账号id
//        int count = amsStockAccountService.insertSelective(amsStockAccount);
//        return new UpmsResult(StatusCode.SUCCESS, count);
//    }
//
//
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
//            return new UpmsResult(StatusCode.INVALID_LENGTH, result.getErrors());
//        }
//        amsStockAccount.setStockAccountId(id);
//        int count = amsStockAccountService.updateByPrimaryKeySelective(amsStockAccount);
//        return new UpmsResult(StatusCode.SUCCESS, count);
//    }
//}
