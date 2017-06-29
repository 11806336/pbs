package com.pbs.ams.web.controller.broker;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.pbs.ams.common.base.BaseController;
import com.pbs.ams.common.constant.UpmsResult;
import com.pbs.ams.common.constant.UpmsResultConstant;
import com.pbs.ams.common.util.IdGeneratorUtil;
import com.pbs.ams.common.validator.LengthValidator;
import com.pbs.ams.web.model.AmsBroker;
import com.pbs.ams.web.model.AmsPlatform;
import com.pbs.ams.web.model.AmsPlatformExample;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色controller
 * Created by ams on 2017/2/6.
 * 规范方法名 记得写注释。
 * service不要乱动，尽量调用现有的方法。
 * 权限配好。
 * 连表改好。
 */
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
        AmsPlatformExample amsPlatformExample = new AmsPlatformExample();
        List<AmsPlatform> amsPlatforms =amsPlatformService.selectByExample(amsPlatformExample);
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
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order
    ) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("offset", offset);
        params.put("limit", limit);
        params.put("search",search);
        params.put("sort",sort);
        params.put("order",order);
        List<AmsBroker> rows = amsBrokerService.selectByExample(params);
        AmsBroker amsBroker=new AmsBroker();
        long total = amsBrokerService.countByExample(amsBroker);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", rows);
        result.put("total", total);
        return result;
    }
    @ApiOperation(value = "新增券商")
    @RequiresPermissions("ams:broker:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(HttpServletRequest request) {
        AmsPlatformExample amsPlatformExample = new AmsPlatformExample();
        List<AmsPlatform> amsPlatforms =amsPlatformService.selectByExample(amsPlatformExample);
        request.setAttribute("amsPlatforms",amsPlatforms);
        return "/broker/create_broker.jsp";
    }

    @ApiOperation(value = "新增券商")
    @RequiresPermissions("ams:broker:create")
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public Object create(AmsBroker amsBroker, String dayBeginTemp, String dayEndTemp) {
        ComplexResult result = FluentValidator.checkAll()
                .on(amsBroker.getBrokerName(), new LengthValidator(1,20,"名称"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess()) {
            return new UpmsResult(UpmsResultConstant.INVALID_LENGTH, result.getErrors());
        }
        long id = IdGeneratorUtil.getKey("ams_broker", 100);
        amsBroker.setBrokerId(id);
        long time = System.currentTimeMillis();
        amsBroker.setCreateTime(time);
        int count = amsBrokerService.insertSelective(amsBroker);
        return new UpmsResult(UpmsResultConstant.SUCCESS, count);
    }


    @ApiOperation(value = "删除券商")
    @RequiresPermissions("ams:broker:delete")
    @RequestMapping(value = "/delete/{ids}",method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        int count=amsBrokerService.deleteByPrimaryKeys(ids);
        return new UpmsResult(UpmsResultConstant.SUCCESS, count);
    }


    @ApiOperation(value = "编辑券商")
    @RequiresPermissions("ams:broker:edit")
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String update(@PathVariable("id") long id, ModelMap modelMap, HttpServletRequest request) {
        AmsBroker amsBroker=amsBrokerService.selectByPrimaryKey(id);
        modelMap.put("amsBrokers",amsBroker);
        AmsPlatformExample amsPlatformExample = new AmsPlatformExample();
        List<AmsPlatform> amsPlatforms =amsPlatformService.selectByExample(amsPlatformExample);
        request.setAttribute("amsPlatforms",amsPlatforms);
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
            return new UpmsResult(UpmsResultConstant.SUCCESS, result.getErrors());
        }
        amsBroker.setBrokerId(id);
        long time = System.currentTimeMillis();
        amsBroker.setCreateTime(time);
        int count = amsBrokerService.updateByPrimaryKeySelective(amsBroker);
        return new UpmsResult(UpmsResultConstant.SUCCESS, count);
    }
}
