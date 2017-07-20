package com.pbs.ams.web.controller.manage;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.pbs.ams.common.constant.ResultSet;
import com.pbs.ams.common.constant.StatusCode;
import com.pbs.ams.common.util.IdGeneratorUtil;
import com.pbs.ams.common.util.MD5Util;
import com.pbs.ams.common.validator.LengthValidator;
import com.pbs.ams.common.validator.NotNullValidator;
import com.pbs.ams.web.controller.BaseController;
import com.pbs.ams.web.model.*;
import com.pbs.ams.web.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 用户controller
 * Created by ams on 2017/2/6.
 */
@Controller
@Api(value = "用户管理", description = "用户管理")
@RequestMapping("/manage/user")
public class UpmsUserController extends BaseController {

    @Autowired
    private UpmsUserService upmsUserService;

    @Autowired
    private UpmsRoleService upmsRoleService;

    @Autowired
    private UpmsOrganizationService upmsOrganizationService;

    @Autowired
    private UpmsUserOrganizationService upmsUserOrganizationService;

    @Autowired
    private UpmsUserRoleService upmsUserRoleService;

    @Autowired
    private UpmsUserPermissionService upmsUserPermissionService;

    @Autowired
    private UpmsCompanyService UpmsCompanyService;

    @Autowired
    private AmsProductService amsProductService;

    @Autowired
    private AmsProductUserService amsProductUserService;

    @Autowired
    private UpmsCompanyUserService upmsCompanyUserService;

    @ApiOperation(value = "用户首页")
    @RequiresPermissions("upms:user:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/manage/user/index.jsp";
    }

    @ApiOperation(value = "用户组织")
    @RequiresPermissions("upms:user:organization")
    @RequestMapping(value = "/organization/{id}", method = RequestMethod.GET)
    public String organization(@PathVariable("id") long id, ModelMap modelMap) {
        // 所有组织
        List<UpmsOrganization> upmsOrganizations = upmsOrganizationService.selectByExample(new UpmsOrganizationExample());
        // 用户拥有组织
        UpmsUserOrganizationExample upmsUserOrganizationExample = new UpmsUserOrganizationExample();
        upmsUserOrganizationExample.createCriteria()
                .andUserIdEqualTo(id);
        List<UpmsUserOrganization> upmsUserOrganizations = upmsUserOrganizationService.selectByExample(upmsUserOrganizationExample);
        modelMap.put("upmsOrganizations", upmsOrganizations);
        modelMap.put("upmsUserOrganizations", upmsUserOrganizations);
        return "/manage/user/organization.jsp";
    }

    @ApiOperation(value = "用户组织")
    @RequiresPermissions("upms:user:organization")
    @RequestMapping(value = "/organization/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object organization(@PathVariable("id") long id, HttpServletRequest request) {
        String[] organizationIds = request.getParameterValues("organizationId");
        // 删除旧记录
        UpmsUserOrganizationExample upmsUserOrganizationExample = new UpmsUserOrganizationExample();
        upmsUserOrganizationExample.createCriteria()
                .andUserIdEqualTo(id);
        upmsUserOrganizationService.deleteByExample(upmsUserOrganizationExample);
        // 增加新记录
        if (null != organizationIds) {
            for (String organizationId : organizationIds) {
                if (StringUtils.isBlank(organizationId)) {
                    continue;
                }
                UpmsUserOrganization upmsUserOrganization = new UpmsUserOrganization();
                upmsUserOrganization.setUserId(id);
                upmsUserOrganization.setOrganizationId(NumberUtils.toLong(organizationId));
                upmsUserOrganizationService.insertSelective(upmsUserOrganization);
            }
        }
        return new ResultSet(StatusCode.ERROR_NONE);
    }

    @ApiOperation(value = "用户角色")
    @RequiresPermissions("upms:user:role")
    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    public String role(@PathVariable("id") long id, ModelMap modelMap) {
        // 所有角色
        List<UpmsRole> upmsRoles = upmsRoleService.selectByExample(new UpmsRoleExample());
        // 用户拥有角色
        UpmsUserRoleExample upmsUserRoleExample = new UpmsUserRoleExample();
        upmsUserRoleExample.createCriteria()
                .andUserIdEqualTo(id);
        List<UpmsUserRole> upmsUserRoles = upmsUserRoleService.selectByExample(upmsUserRoleExample);
        modelMap.put("upmsRoles", upmsRoles);
        modelMap.put("upmsUserRoles", upmsUserRoles);
        return "/manage/user/role.jsp";
    }

    @ApiOperation(value = "用户角色")
    @RequiresPermissions("upms:user:role")
    @RequestMapping(value = "/role/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object role(@PathVariable("id") long id, HttpServletRequest request) {
        String[] roleIds = request.getParameterValues("roleId");
        // 删除旧记录
        UpmsUserRoleExample upmsUserRoleExample = new UpmsUserRoleExample();
        upmsUserRoleExample.createCriteria()
                .andUserIdEqualTo(id);
        upmsUserRoleService.deleteByExample(upmsUserRoleExample);
        // 增加新记录
        if (null != roleIds) {
            for (String roleId : roleIds) {
                if (StringUtils.isBlank(roleId)) {
                    continue;
                }
                UpmsUserRole upmsUserRole = new UpmsUserRole();
                upmsUserRole.setUserId(id);
                upmsUserRole.setRoleId(NumberUtils.toLong(roleId));
                upmsUserRoleService.insertSelective(upmsUserRole);
            }
        }
        return new ResultSet(StatusCode.ERROR_NONE);
    }

    @ApiOperation(value = "用户权限")
    @RequiresPermissions("upms:user:permission")
    @RequestMapping(value = "/permission/{id}", method = RequestMethod.GET)
    public String permission(@PathVariable("id") long id, ModelMap modelMap) {
        UpmsUser user = upmsUserService.selectByPrimaryKey(id);
        modelMap.put("user", user);
        return "/manage/user/permission.jsp";
    }

    @ApiOperation(value = "用户权限")
    @RequiresPermissions("upms:user:permission")
    @RequestMapping(value = "/permission/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object permission(@PathVariable("id") long id, HttpServletRequest request) {
        JSONArray datas = JSONArray.parseArray(request.getParameter("datas"));
        for (int i = 0; i < datas.size(); i ++) {
            JSONObject json = datas.getJSONObject(i);
            if (json.getBoolean("checked")) {
                // 新增权限
                UpmsUserPermission upmsUserPermission = new UpmsUserPermission();
                upmsUserPermission.setUserId(id);
                upmsUserPermission.setPermissionId(json.getLongValue("id"));
                upmsUserPermission.setType(json.getByte("type"));
                upmsUserPermissionService.insertSelective(upmsUserPermission);
            } else {
                // 删除权限
                UpmsUserPermissionExample upmsUserPermissionExample = new UpmsUserPermissionExample();
                upmsUserPermissionExample.createCriteria()
                        .andPermissionIdEqualTo(json.getLongValue("id"))
                        .andTypeEqualTo(json.getByte("type"));
                upmsUserPermissionService.deleteByExample(upmsUserPermissionExample);
            }
        }
        return new ResultSet(StatusCode.ERROR_NONE, datas.size());
    }

    @ApiOperation(value = "用户列表")
    @RequiresPermissions("upms:user:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order) {
        UpmsUserExample upmsUserExample = new UpmsUserExample();
        upmsUserExample.setOffset(offset);
        upmsUserExample.setLimit(limit);
        if (!StringUtils.isBlank(sort) && !StringUtils.isBlank(order)) {
            upmsUserExample.setOrderByClause(sort + " " + order);
        }
        if (StringUtils.isNotBlank(search)) {
            upmsUserExample.or()
                    .andRealnameLike("%" + search + "%");
            upmsUserExample.or()
                    .andUsernameLike("%" + search + "%");
        }
        List<UpmsUser> rows = upmsUserService.selectByExample(upmsUserExample);
        long total = upmsUserService.countByExample(upmsUserExample);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", rows);
        result.put("total", total);
        return result;
    }

    @ApiOperation(value = "新增用户")
    @RequiresPermissions("upms:user:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        UpmsUser user = getCurrentUser();
        if (user != null) {
            Map<String, Object> params = new HashMap<String, Object>();
            List<UpmsCompanyUser> upmsCompanyUserList = getCompanyByUserId();//查询当前用户的关联公司
            List<Long> companyIds = new ArrayList<Long>();//存放公司id
            for (UpmsCompanyUser companyUser : upmsCompanyUserList) {
                companyIds.add(companyUser.getCompanyId());
            }
            params.put("companyIds", companyIds);
            //先从公司用户中间表查询公司，再根据公司得到产品列表。
            List<Map> products = amsProductService.selectProductWithDetail(params);
            params.put("companyIds", companyIds);
            List<UpmsCompany> upmsCompanies = UpmsCompanyService.listCompanies(params);
            modelMap.addAttribute("products", products);//产品
            modelMap.addAttribute("upmsCompanies", upmsCompanies);//公司
        }
        return "/manage/user/create.jsp";
    }

    @ApiOperation(value = "新增用户")
    @RequiresPermissions("upms:user:create")
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Object create(UpmsUser upmsUser, Long productId, Long companyId) {
        ComplexResult result = FluentValidator.checkAll()
                .on(upmsUser.getUsername(), new LengthValidator(1, 20, "帐号"))
                .on(upmsUser.getPassword(), new LengthValidator(5, 32, "密码"))
                .on(upmsUser.getRealname(), new NotNullValidator("姓名"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess() || productId == null) {
            return new ResultSet(StatusCode.ERROR_NONE);
        }
        long time = System.currentTimeMillis();
        String salt = UUID.randomUUID().toString().replaceAll("-", "");
        upmsUser.setSalt(salt);
        upmsUser.setPassword(MD5Util.MD5(upmsUser.getPassword() + upmsUser.getSalt()));
        upmsUser.setCtime(time);
//        upmsUser = upmsUserService.insert2(upmsUser);
        AmsProductUser amsProductUser = new AmsProductUser();//创建关系对象
        amsProductUser.setProductId(productId);
//        amsProductUser.setUserId(upmsUser.getUserId());
        long id = IdGeneratorUtil.getKey("ams_product_user", 100);
        amsProductUser.setProductUserId(id);
        int resultCount = upmsUserService.insertUserAndProductRelation(upmsUser, amsProductUser, companyId);
        if (resultCount > 0) {
            _log.info("新增用户，主键：userId={}", upmsUser.getUserId());
            return new ResultSet(StatusCode.ERROR_NONE,resultCount);
        }
        return new ResultSet(StatusCode.INVALID_LENGTH, "新增用户出错！");
    }
    @ApiOperation(value = "删除用户")
    @RequiresPermissions("upms:user:delete")
    @RequestMapping(value = "/delete/{ids}",method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        int count = upmsUserService.deleteByPrimaryKeys(ids);
        return new ResultSet(StatusCode.ERROR_NONE, count);
    }

    @ApiOperation(value = "修改用户")
    @RequiresPermissions("upms:user:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") long id, ModelMap modelMap) {
        UpmsUser user = upmsUserService.selectByPrimaryKey(id);
        modelMap.put("user", user);
        Map<String, Object> params = new HashMap<String, Object>();

        //先从公司用户中间表查询公司，再根据公司得到产品列表。
        List<UpmsCompanyUser> upmsCompanyUsers = upmsCompanyUserService.getCompaniesByUserId(getCurrentUser().getUserId());
        List<Long> companyIds = new ArrayList<Long>();//存放公司id
        for (UpmsCompanyUser companyUser : upmsCompanyUsers) {
            companyIds.add(companyUser.getCompanyId());
        }
        params.put("companyIds", companyIds);
        List<Map> products = amsProductService.selectProductWithDetail(params);

        Map<String, Object> map = new HashMap<String, Object>();
        List<Long> ids = new ArrayList<Long>();
        for (UpmsCompanyUser companyUser : upmsCompanyUsers) {
            ids.add(companyUser.getCompanyId());
        }
        map.put("companyIds", ids);
        List<UpmsCompany> upmsCompanies = UpmsCompanyService.listCompanies(map);//
        AmsProductUser amsProductUser = new AmsProductUser();
        amsProductUser.setUserId(id);
        List<AmsProductUser> amsProductUsers = amsProductUserService.select(amsProductUser);//从关系表中查出绑定的产品
        modelMap.addAttribute("upmsCompanies", upmsCompanies);
        modelMap.addAttribute("products", products);
        if (amsProductUsers != null && amsProductUsers.size() > 0) {
            modelMap.addAttribute("amsProductUsers", amsProductUsers.get(0));//为了下拉框的默认选中，暂时只取一条，等多对多的时候进行变更。
        }
        return "/manage/user/update.jsp";
    }

    @ApiOperation(value = "修改用户")
    @RequiresPermissions("upms:user:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable("id") long id, UpmsUser upmsUser, Long productId, Long companyId) {
        ComplexResult result = FluentValidator.checkAll()
                .on(upmsUser.getUsername(), new LengthValidator(1, 20, "帐号"))
                .on(upmsUser.getRealname(), new NotNullValidator("姓名"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess() || productId == null) {
            return new ResultSet(StatusCode.INVALID_LENGTH, result.getErrors());
        }
        AmsProductUser amsProductUser = new AmsProductUser();
        amsProductUser.setUserId(id);
        List<AmsProductUser> amsProductUsers = amsProductUserService.select(amsProductUser);
        AmsProductUser productUser = amsProductUsers.get(0);
        productUser.setProductId(productId);
        // 不允许直接改密码
        upmsUser.setPassword(null);
        upmsUser.setUserId(id);
        int count = upmsUserService.updateUserAndProductRelation(upmsUser, productUser, companyId);
        return new ResultSet(StatusCode.ERROR_NONE, count);
    }

}
