package com.pbs.ams.web.controller.account;

import com.google.common.collect.Maps;
import com.pbs.ams.common.annotation.Log;
import com.pbs.ams.web.controller.BaseController;
import com.pbs.ams.web.service.RskBlackwhiteListService;
import io.swagger.annotations.Api;
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
 * Created by Administrator on 2017/7/26.
 */
@Controller
@Api(value = "黑白名单", description = "黑白名单")
@RequestMapping("/blackWhite")
public class amsStockBlackWhiteController extends BaseController{
    @Autowired
    private RskBlackwhiteListService rskBlackwhiteListService;

    @Log(value = "黑名单列表")
    @RequiresPermissions("upms:blackWhite:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("offset", offset);
        params.put("limit", limit);
        List<Map<String, Object>> rows = rskBlackwhiteListService.selectBlackWhite(params);
        long total = rskBlackwhiteListService.selectBlackWhiteCount(params);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("rows", rows);
        result.put("total", total);
        return result;
    }

}
