package com.pbs.ams.web.controller.broker;

import com.pbs.ams.common.base.BaseController;
import com.pbs.ams.web.model.AmsBroker;
import com.pbs.ams.web.model.AmsBrokerExample;
import com.pbs.ams.web.service.AmsBrokerService;
import com.pbs.ams.web.service.AmsPlatformService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 * 角色controller
 * Created by ams on 2017/2/6.
 */
@Controller
@Api(value = "经纪公司", description = "经纪公司")
@RequestMapping("/manage/broker")
public class AmsBrokerController extends BaseController {

    @Autowired
    private AmsBrokerService amsBrokerService;

    @Autowired
    private AmsPlatformService amsPlatformService;

    @ApiOperation(value = "角色首页")
    @RequiresPermissions("ams:broker:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/manage/broker/broker.jsp";
    }
    @ApiOperation(value = "组织列表")
    @RequiresPermissions("upms:organization:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order) {
        AmsBrokerExample amsBrokerExample = new AmsBrokerExample();
        amsBrokerExample.setOffset(offset);
        amsBrokerExample.setLimit(limit);
        if (!StringUtils.isBlank(sort) && !StringUtils.isBlank(order)) {
            amsBrokerExample.setOrderByClause(sort + " " + order);
        }
        if (StringUtils.isNotBlank(search)) {
            amsBrokerExample.or().andBrokerAbbrNameLike("%" + search + "%");
        }
        List<AmsBroker> rows = amsBrokerService.selectByExample(amsBrokerExample);
        long total = amsBrokerService.countByExample(amsBrokerExample);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", rows);
        result.put("total", total);
        return result;
    }


}
