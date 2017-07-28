package com.pbs.ams.web.controller.broker;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.google.common.collect.Maps;
import com.pbs.ams.common.annotation.Log;
import com.pbs.ams.common.constant.Constants;
import com.pbs.ams.common.constant.ResultSet;
import com.pbs.ams.common.constant.StatusCode;
import com.pbs.ams.common.constant.UpmsConstant;
import com.pbs.ams.common.util.CheckUtil;
import com.pbs.ams.common.util.DateUtil;
import com.pbs.ams.common.util.IdGeneratorUtil;
import com.pbs.ams.common.validator.LengthValidator;
import com.pbs.ams.web.controller.BaseController;
import com.pbs.ams.web.model.AmsBroker;
import com.pbs.ams.web.model.SysGlobalConstData;
import com.pbs.ams.web.service.AmsBrokerService;
import com.pbs.ams.web.service.AmsPlatformService;
import com.pbs.ams.web.service.SysGlobalConstDataService;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(value = "经纪公司", description = "经纪公司")
@RequestMapping("/broker")
public class AmsBrokerController extends BaseController {
    @Autowired
    private AmsBrokerService amsBrokerService;
    @Autowired
    private SysGlobalConstDataService sysGlobalConstDataService;

    @Log(value = "经纪公司")
    @RequiresPermissions("ams:broker:read")
    @RequestMapping(value= "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        Map<String, Object> params = Maps.newHashMap();
        //查询金融工具类型（平台）
        params.put("globalConstCode", UpmsConstant.FIN_INSTR_TYPE);
        List<SysGlobalConstData> amsPlatforms = sysGlobalConstDataService.selectDataByCode(params);
        request.setAttribute("amsPlatforms",amsPlatforms);
        return "/broker/index.jsp";
    }

    @Log(value = "公司列表")
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
            params.put("search", search);
            params.put("finInstrType", platformId);
            List<Map> rows = amsBrokerService.selectBrokerWithDetail(params);
            long total = amsBrokerService.selectBrokerWithDetailCount(params);
            Map<String, Object> result = Maps.newHashMap();
            result.put("rows", rows);
            result.put("total", total);
            return result;
    }
    @Log(value = "新增券商")
    @RequiresPermissions("ams:broker:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(HttpServletRequest request) {
        Map<String, Object> params = Maps.newHashMap();
        //查询金融工具类型（平台）
        params.put("globalConstCode", UpmsConstant.FIN_INSTR_TYPE);
        List<SysGlobalConstData> amsPlatforms = sysGlobalConstDataService.selectDataByCode(params);
        request.setAttribute("amsPlatforms", amsPlatforms);
        return "/broker/create_broker.jsp";
    }

    @Log(value = "新增券商")
    @RequiresPermissions("ams:broker:create")
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public Object create(AmsBroker amsBroker,String day_begin,String day_end) {
        long dayBegin = Long.valueOf(DateUtil.removeDateSymbol(day_begin));
        long dayEnd = Long.valueOf(DateUtil.removeDateSymbol(day_end));
        if (dayBegin - dayEnd < 0) { //日盘启动时间大于结束时间
            ComplexResult result = FluentValidator.checkAll()
                    .on(amsBroker.getBrokerName(), new LengthValidator(1,20,"名称"))
                    .doValidate()
                    .result(ResultCollectors.toComplex());
            if (!result.isSuccess()) {
                return new ResultSet(StatusCode.INVALID_LENGTH);
            }
            amsBroker.setDayBegin(dayBegin);
            amsBroker.setDayEnd(dayEnd);
            amsBroker.setOperatorId(getCurrentUser().getUserId());
            long id = IdGeneratorUtil.getKey("ams_broker", 100);
            amsBroker.setBrokerId(id);
            int count = amsBrokerService.insertSelective(amsBroker);
            return new ResultSet(StatusCode.ERROR_NONE, count);
        }
        return new ResultSet(StatusCode.ILLEGAL_DATE);
    }

//    @Log(value = "删除券商")
//    @RequiresPermissions("ams:broker:delete")
//    @RequestMapping(value = "/delete/{ids}",method = RequestMethod.GET)
//    @ResponseBody
//    public Object delete(@PathVariable("ids") String ids) {
//        if (StringUtils.isNotEmpty(ids)) {
//            String[] brokerIds = ids.split("-");
//            List<Long> idList = new ArrayList<Long>();
//            for (String id : brokerIds) {
//                if (CheckUtil.canDelete(Long.parseLong(id))) {//可以删除
//                    idList.add(Long.parseLong(id));
//                } else {
//                    return new ResultSet(StatusCode.INVALID_DELETE, "存在关联关系，不能删除！");
//                }
//            }
//            int count = amsBrokerService.deleteByPrimaryKeys(idList);
//            return new ResultSet(StatusCode.ERROR_NONE, count);
//        }
//        return 0;
//    }


    @Log(value = "编辑券商")
    @RequiresPermissions("ams:broker:edit")
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String update(@PathVariable("id") String id, ModelMap modelMap) {
        AmsBroker amsBroker=amsBrokerService.selectByPrimaryKey(Long.parseLong(id));
        modelMap.put("amsBrokers",amsBroker);
        Map<String, Object> params = Maps.newHashMap();
        //查询金融工具类型（平台）
        params.put("globalConstCode", UpmsConstant.FIN_INSTR_TYPE);
        List<SysGlobalConstData> amsPlatforms = sysGlobalConstDataService.selectDataByCode(params);
        modelMap.put("amsPlatforms", amsPlatforms);
        return "/broker/update_broker.jsp";
    }



    @Log(value = "编辑券商")
    @RequiresPermissions("ams:broker:edit")
    @ResponseBody
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public Object update(@PathVariable("id") long id, AmsBroker amsBroker,String day_begin,String day_end) {
        ComplexResult result = FluentValidator.checkAll()
                .on(amsBroker.getBrokerName(), new LengthValidator(1,20,"名称"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess()) {
            return new ResultSet(StatusCode.INVALID_LENGTH);
        }
        long dayBegin = Long.valueOf(day_begin.replaceAll(":", ""));
        long dayEnd =Long.valueOf(day_end.replaceAll(":", ""));
        amsBroker.setDayBegin(dayBegin);
        amsBroker.setDayEnd(dayEnd);
        long time = System.currentTimeMillis();
        amsBroker.setUpdateTime(time);
        int count = amsBrokerService.updateByPrimaryKeySelective(amsBroker);
        return new ResultSet(StatusCode.ERROR_NONE,count);
    }
}
