package com.pbs.ams.web.controller.account;

import com.google.common.collect.Maps;
import com.pbs.ams.common.annotation.Log;
import com.pbs.ams.common.constant.ResultSet;
import com.pbs.ams.common.constant.StatusCode;
import com.pbs.ams.common.util.IdGeneratorUtil;
import com.pbs.ams.web.controller.BaseController;
import com.pbs.ams.web.model.AmsTradeFeeTemplate;
import com.pbs.ams.web.service.AmsStockCategoryService;
import com.pbs.ams.web.service.AmsTradeFeeTemplateService;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/25.
 */
@Controller
@Api(value = "手续费设置", description = "手续费设置")
@RequestMapping("/feeTemplate")
public class AmsTradeFeeTemplateController extends BaseController {
    @Autowired
    private AmsTradeFeeTemplateService amsTradeFeeTemplateService;

    @Autowired
    private AmsStockCategoryService amsStockCategoryService;

    @Log(value = "手续费首页")
    @RequiresPermissions("upms:feeTemplate:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/account/charge/charge.jsp";
    }

    @Log(value = "手续费列表")
    @RequiresPermissions("upms:feeTemplate:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("offset", offset);
        params.put("limit", limit);
        List<Map> rows = amsTradeFeeTemplateService.selectTradeFeeTemplate(params);
        long total = amsTradeFeeTemplateService.selectTradeFeeTemplateCount(params);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("rows", rows);
        result.put("total", total);
        return result;
    }

    @Log(value = "新增手续费模板")
    @RequiresPermissions("upms:feeTemplate:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(HttpServletRequest request) {
        Map<String, Object> params = Maps.newHashMap();
        List<Map> amsStockCategory = amsStockCategoryService.selectAmsStockCategory(params);
        request.setAttribute("amsStockCategory", amsStockCategory);
        return "/account/charge/create_charge.jsp";
    }

    /**
     *
     * @param amsTradeFeeTemplate
     * @return
     */
    @Log(value = "新增手续费模板")
    @RequiresPermissions("upms:feeTemplate:create")
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Object create(AmsTradeFeeTemplate amsTradeFeeTemplate) {
        Long feeTemplateId = IdGeneratorUtil.getKey("ams_trade_fee_template");
        amsTradeFeeTemplate.setFeeTemplateteId(feeTemplateId);
        int result = amsTradeFeeTemplateService.insertSelective(amsTradeFeeTemplate);
        int count = 0;
        if (result > 0) {
            amsTradeFeeTemplate.setOperatorId(getCurrentUser().getUserId());
            count = amsTradeFeeTemplateService.insertSelective(amsTradeFeeTemplate);
            return new ResultSet(StatusCode.ERROR_NONE, count);
        }
        return new ResultSet(StatusCode.INVALID_INSERT, count);
    }

    @Log(value = "修改手续费")
    @RequiresPermissions("upms:feeTemplate:update")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") Long id, HttpServletRequest request) {

        AmsTradeFeeTemplate amsTradeFeeTemplate = amsTradeFeeTemplateService.selectByPrimaryKey(id);
        request.setAttribute("amsTradeFeeTemplate", amsTradeFeeTemplate);
        Map<String, Object> params = Maps.newHashMap();
        List<Map> amsStockCategory = amsStockCategoryService.selectAmsStockCategory(params);
        request.setAttribute("amsStockCategory", amsStockCategory);
        return "/account/charge/update_charge.jsp";
    }

    @Log(value = "修改账号")
    @RequiresPermissions("upms:feeTemplate:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable("id") Long id,AmsTradeFeeTemplate amsTradeFeeTemplate) {
        amsTradeFeeTemplate.setFeeTemplateteId(id);
        int count = amsTradeFeeTemplateService.updateByPrimaryKeySelective(amsTradeFeeTemplate);
        return new ResultSet(StatusCode.ERROR_NONE, count);
    }

}
