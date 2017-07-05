package com.pbs.ams.web.controller.broker;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.google.common.collect.Maps;
import com.pbs.ams.common.constant.StatusCode;
import com.pbs.ams.web.controller.BaseController;
import com.pbs.ams.common.constant.UpmsResult;
import com.pbs.ams.common.util.IdGeneratorUtil;
import com.pbs.ams.common.validator.LengthValidator;
import com.pbs.ams.web.model.AmsBroker;
import com.pbs.ams.web.model.AmsPlatform;
import com.pbs.ams.web.service.AmsBrokerService;
import com.pbs.ams.web.service.AmsPlatformService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;



@Controller
@Api(value = "经纪公司", description = "经纪公司")
@RequestMapping("/ams/broker")
public class AmsBrokerController extends BaseController {
    @Autowired
    private AmsBrokerService amsBrokerService;
    @Autowired
    private AmsPlatformService amsPlatformService;

    @ApiOperation(value = "经纪公司")
    @RequiresPermissions("ams:broker:read")
    @RequestMapping(value= "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        AmsPlatform amsPlatform = new AmsPlatform();
        Map<String, Object> params = Maps.newHashMap();
        List<Map> amsPlatforms =amsPlatformService.selectPlatformWithDetail(params);
        request.setAttribute("amsPlatforms",amsPlatforms);
        return "/broker/index.jsp";
    }

    @ApiOperation(value = "公司列表")
    @RequiresPermissions("ams:broker:read")
    @RequestMapping(value = "/queryAmsBroker", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            HttpServletRequest request){
            String platformId=request.getParameter("platformId");
            Map<String, Object> params = Maps.newHashMap();
            params.put("offset", offset);
            params.put("limit", limit);
            params.put("search",search);
            params.put("platformId",platformId);
            List<Map> rows = amsBrokerService.selectBrokerWithDetail(params);
            long total = amsBrokerService.selectBrokerWithDetailCount(params);
            Map<String, Object> result = Maps.newHashMap();
            result.put("rows", rows);
            result.put("total", total);
            return result;
    }
    @ApiOperation(value = "新增券商")
    @RequiresPermissions("ams:broker:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(HttpServletRequest request) {
        AmsPlatform amsPlatform = new AmsPlatform();
        Map<String, Object> params = Maps.newHashMap();
        List<Map> amsPlatforms =amsPlatformService.selectPlatformWithDetail(params);
        request.setAttribute("amsPlatforms",amsPlatforms);
        return "/broker/create_broker.jsp";
    }

    @ApiOperation(value = "新增券商")
    @RequiresPermissions("ams:broker:create")
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public Object create(AmsBroker amsBroker) {
        ComplexResult result = FluentValidator.checkAll()
                .on(amsBroker.getBrokerName(), new LengthValidator(1,20,"名称"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess()) {
            return new UpmsResult(StatusCode.INVALID_LENGTH, result.getErrors());
        }
        long id = IdGeneratorUtil.getKey("ams_broker", 100);
        amsBroker.setBrokerId(id);
        long time = System.currentTimeMillis();
        amsBroker.setCreateTime(time);
        int count = amsBrokerService.insertSelective(amsBroker);
        return new UpmsResult(StatusCode.SUCCESS, count);
    }


    @ApiOperation(value = "删除券商")
    @RequiresPermissions("ams:broker:delete")
    @RequestMapping(value = "/delete/{ids}",method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        int count=amsBrokerService.deleteByPrimaryKeys(ids);
        return new UpmsResult(StatusCode.SUCCESS, count);
    }


    @ApiOperation(value = "编辑券商")
    @RequiresPermissions("ams:broker:edit")
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String update(@PathVariable("id") String id, ModelMap modelMap, HttpServletRequest request) {
        AmsBroker amsBroker=amsBrokerService.selectByPrimaryKey(Long.parseLong(id));
        modelMap.put("amsBrokers",amsBroker);
        Map<String, Object> params = Maps.newHashMap();
        List<Map> amsPlatforms =amsPlatformService.selectPlatformWithDetail(params);
        request.setAttribute("amsPlatforms",amsPlatforms);
        modelMap.put("amsPlatforms",amsPlatforms);
        return "/broker/update_broker.jsp";
    }



    @ApiOperation(value = "编辑券商")
    @RequiresPermissions("ams:broker:edit")
    @ResponseBody
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public Object update(@PathVariable("id") long id, AmsBroker amsBroker) {
        ComplexResult result = FluentValidator.checkAll()
                .on(amsBroker.getBrokerName(), new LengthValidator(1,20,"名称"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess()) {
            return new UpmsResult(StatusCode.SUCCESS, result.getErrors());
        }
        amsBroker.setBrokerId(id);
        long time = System.currentTimeMillis();
        amsBroker.setCreateTime(time);
        int count = amsBrokerService.updateByPrimaryKeySelective(amsBroker);
        return new UpmsResult(StatusCode.SUCCESS, count);
    }
}
