package com.pbs.ams.web.controller.company;



import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.pbs.ams.common.constant.ResultSet;
import com.pbs.ams.web.controller.BaseController;
import com.pbs.ams.common.constant.StatusCode;
import com.pbs.ams.common.util.IdGeneratorUtil;
import com.pbs.ams.common.validator.LengthValidator;
import com.pbs.ams.web.model.UpmsCompany;
import com.pbs.ams.web.model.UpmsCompanyUser;
import com.pbs.ams.web.model.UpmsUser;
import com.pbs.ams.web.service.UpmsCompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 公司controller
 * Created by ams on 2017/3/14.
 */
@Controller
@Api(value = "公司管理", description = "公司管理")
@RequestMapping("/company")
public class UpmsCompanyController extends BaseController {

    @Autowired
    private UpmsCompanyService upmsCompanyService;

    @ApiOperation(value = "公司首页")
    @RequiresPermissions("upms:company:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/company/index.jsp";
    }

    @ApiOperation(value = "公司列表")
    @RequiresPermissions("upms:company:read")
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
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("offset", offset);
        params.put("limit", limit);
        params.put("companyName", search);//search暂时为公司名
        if (upmsUser != null) {
            if (!upmsUser.isSuperUser()) {//如果是超级管理员的话查询全部，否则带上公司进行查询
                List<UpmsCompanyUser> upmsCompanies = getCompanyByUserId();
                List<Long> companyIds = new ArrayList<Long>();//用来存放公司id
                for (UpmsCompanyUser companyUser : upmsCompanies) {
                    companyIds.add(companyUser.getCompanyId());
                }
                params.put("companyIds", companyIds);
            }
        }
        List<UpmsCompany> rows = upmsCompanyService.listCompanies(params);
        long total = upmsCompanyService.countCompany(params);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("rows", rows);
        result.put("total", total);
        return result;
    }

    @ApiOperation(value = "删除公司")
    @RequiresPermissions("upms:company:delete")
    @RequestMapping(value = "/delete/{ids}", method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            String[] companyIds = ids.split("-");
            List<Long> idList = new ArrayList<Long>();
            for (String id : companyIds) {
                idList.add(Long.parseLong(id));
            }
            int count = upmsCompanyService.deleteCompany(idList);
            return new ResultSet(StatusCode.ERROR_NONE, count);
        }
        return 0;
    }


    @ApiOperation(value = "新增公司")
    @RequiresPermissions("upms:company:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "/company/create_company.jsp";
    }

    @ApiOperation(value = "新增公司")
    @RequiresPermissions("upms:company:create")
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Object create(UpmsCompany upmsCompany) {
        ComplexResult result = FluentValidator.checkAll()
                .on(upmsCompany.getCompanyName(), new LengthValidator(1, 20, "名称"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess()) {
            return new ResultSet(StatusCode.INVALID_LENGTH, result.getErrors());
        }
        Long id = IdGeneratorUtil.getKey("upms_company");
        upmsCompany.setCompanyId(id);//获取公司id
        int count = upmsCompanyService.insertCompany(upmsCompany);
        return new ResultSet(StatusCode.ERROR_NONE, count);
    }


    @ApiOperation(value = "修改公司")
    @RequiresPermissions("upms:company:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") long id, ModelMap modelMap) {
        UpmsCompany company = upmsCompanyService.getCompany(id);
        modelMap.put("company", company);
        return "/company/update_company.jsp";
    }

    @ApiOperation(value = "修改公司")
    @RequiresPermissions("upms:company:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable("id") long id, UpmsCompany upmsCompany) {
        ComplexResult result = FluentValidator.checkAll()
                .on(upmsCompany.getCompanyName(), new LengthValidator(1, 20, "名称"))
//                .on(upmsCompany.getTitle(),  new NotNullValidator("姓名"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess()) {
            return new ResultSet(StatusCode.INVALID_LENGTH, result.getErrors());
        }
        upmsCompany.setCompanyId(id);
        int count = upmsCompanyService.updateCompany(upmsCompany);
        return new ResultSet(StatusCode.ERROR_NONE, count);
    }
}
