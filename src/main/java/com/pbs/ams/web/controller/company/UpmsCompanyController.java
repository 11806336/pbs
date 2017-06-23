package com.pbs.ams.web.controller.company;



import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.pbs.ams.common.base.BaseController;
import com.pbs.ams.common.constant.UpmsResult;
import com.pbs.ams.common.constant.UpmsResultConstant;
import com.pbs.ams.common.util.IdGeneratorUtil;
import com.pbs.ams.common.validator.LengthValidator;
import com.pbs.ams.web.model.UpmsCompany;
import com.pbs.ams.web.model.UpmsCompanyExample;
import com.pbs.ams.web.service.UpmsCompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return "/manage/company/company.jsp";
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
            @RequestParam(required = false, value = "order") String order) {
        UpmsCompanyExample upmsCompanyExample = new UpmsCompanyExample();
        upmsCompanyExample.setOffset(offset);
        upmsCompanyExample.setLimit(limit);
        if (!StringUtils.isBlank(sort) && !StringUtils.isBlank(order)) {
            upmsCompanyExample.setOrderByClause(sort + " " + order);
        }
        if (StringUtils.isNotBlank(search)) {//根据公司名称进行模糊查询
            upmsCompanyExample.or().andCompanyNameLike("%" + search + "%");
        }
        List<UpmsCompany> rows = upmsCompanyService.selectByExample(upmsCompanyExample);
        long total = upmsCompanyService.countByExample(upmsCompanyExample);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("rows", rows);
        result.put("total", total);
        return result;
    }

    @ApiOperation(value = "删除公司")
    @RequiresPermissions("upms:company:read")
    @RequestMapping(value = "/delete/{ids}", method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        int count = upmsCompanyService.deleteByPrimaryKeys(ids);
        return new UpmsResult(UpmsResultConstant.SUCCESS, count);
    }


    @ApiOperation(value = "新增公司")
    @RequiresPermissions("upms:company:read")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "/manage/company/create_company.jsp";
    }

    @ApiOperation(value = "新增公司")
    @RequiresPermissions("upms:company:read")
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Object create(UpmsCompany upmsCompany) {
        ComplexResult result = FluentValidator.checkAll()
                .on(upmsCompany.getCompanyName(), new LengthValidator(1, 20, "名称"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess()) {
            return new UpmsResult(UpmsResultConstant.INVALID_LENGTH, result.getErrors());
        }
        long time = System.currentTimeMillis();
        upmsCompany.setCreateTime(time);
        Long id = IdGeneratorUtil.getKey("upms_company");
        upmsCompany.setCompanyId(id.intValue());//获取公司id
        int count = upmsCompanyService.insertSelective(upmsCompany);
        return new UpmsResult(UpmsResultConstant.SUCCESS, count);
    }


    @ApiOperation(value = "修改公司")
    @RequiresPermissions("upms:company:read")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") int id, ModelMap modelMap) {
        UpmsCompany company = upmsCompanyService.selectByPrimaryKey(id);
        modelMap.put("company", company);
        return "/manage/company/update_company.jsp";
    }

    @ApiOperation(value = "修改公司")
    @RequiresPermissions("upms:company:read")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable("id") int id, UpmsCompany upmsCompany) {
        ComplexResult result = FluentValidator.checkAll()
                .on(upmsCompany.getCompanyName(), new LengthValidator(1, 20, "名称"))
//                .on(upmsCompany.getTitle(),  new NotNullValidator("姓名"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess()) {
            return new UpmsResult(UpmsResultConstant.INVALID_LENGTH, result.getErrors());
        }
        upmsCompany.setCompanyId(id);
        int count = upmsCompanyService.updateByPrimaryKeySelective(upmsCompany);
        return new UpmsResult(UpmsResultConstant.SUCCESS, count);
    }
}
