package com.pbs.ams.web.controller.product;

import com.google.common.collect.Maps;
import com.pbs.ams.common.annotation.Log;
import com.pbs.ams.web.controller.BaseController;
import com.pbs.ams.web.model.UpmsUser;
import com.pbs.ams.web.service.AmsProductService;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/18.
 */
@Controller
@Api(value = "产品净值信息", description = "产品净值信息")
@RequestMapping(value = "/net")
public class AmsProductNetController extends BaseController {


    @Autowired
    private AmsProductService amsProductService;

    @Log(value = "产品净值信息首页")
    @RequiresPermissions("ams:product:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/product/netIndex.jsp";
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
}
