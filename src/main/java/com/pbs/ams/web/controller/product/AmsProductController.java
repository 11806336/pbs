package com.pbs.ams.web.controller.product;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.google.common.collect.Maps;
import com.pbs.ams.common.base.BaseController;
import com.pbs.ams.common.constant.UpmsResult;
import com.pbs.ams.common.constant.UpmsResultConstant;
import com.pbs.ams.common.util.IdGeneratorUtil;
import com.pbs.ams.common.validator.LengthValidator;
import com.pbs.ams.web.model.AmsProduct;
import com.pbs.ams.web.model.AmsProductAccount;
import com.pbs.ams.web.service.AmsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TiAmo on 17/6/23.
 */
@Controller
@Api(value = "产品管理", description = "产品管理")
@RequestMapping("/product")
public class AmsProductController extends BaseController{

    @Autowired
    private AmsProductService amsProductService;

    @ApiOperation(value = "产品管理首页")
    @RequiresPermissions("ams:product:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/product/index.jsp";
    }

    @ApiOperation(value = "产品列表")
    @RequiresPermissions("ams:product:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search) {

        Map<String,Object> map = Maps.newHashMap();
        map.put("offset",offset);
        map.put("limit",limit);
        if (!StringUtils.isBlank(search)) {
            map.put("search",search);
        }
        List<Map> rows = amsProductService.selectProductWithDetail(map);

        long total = amsProductService.selectProductWithDetailCount(map);

        Map<String, Object> result = new HashMap<>();
        result.put("rows", rows);
        result.put("total", total);
        return result;
    }

    @ApiOperation(value = "新增产品导航")
    @RequiresPermissions("ams:product:create")
    @RequestMapping(value = "/create/tab", method = RequestMethod.GET)
    public String create() {
        return "/product/create/tab.jsp";
    }



    @ApiOperation(value = "新增产品页")
    @RequiresPermissions("ams:product:create")
    @RequestMapping(value = "/createProduct", method = RequestMethod.GET)
    public String createProduct() {
        return "/product/create/create_product.jsp";
    }


    @ApiOperation(value = "新增产品")
    @RequiresPermissions("ams:product:create")
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Object create(AmsProduct amsProduct,String startDate,String endDate) {
        ComplexResult result = FluentValidator.checkAll()
                .on(amsProduct.getProductName(), new LengthValidator(1, 20, "名称"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess()) {
            return new UpmsResult(UpmsResultConstant.INVALID_LENGTH, result.getErrors());
        }
        long time = System.currentTimeMillis();
        amsProduct.setCreateTime(time);
        int count = amsProductService.insertSelective(amsProduct);
        return new UpmsResult(UpmsResultConstant.SUCCESS, count);
    }




    @ApiOperation(value = "设置账号页")
    @RequiresPermissions("ams:product:create")
    @RequestMapping(value = "/accountSettings", method = RequestMethod.GET)
    public String accountSettings() {
        return "/product/create/product_account_settings.jsp";
    }



    @ApiOperation(value = "绑定账号")
    @RequiresPermissions("ams:product:create")
    @ResponseBody
    @RequestMapping(value = "/bindAccount", method = RequestMethod.GET)
    public int bindAccount(AmsProductAccount amsProductAccount) {
        Long id = IdGeneratorUtil.getKey("ams_product_account");
        amsProductAccount.setProductTradeAccountId(id);
        return amsProductService.insertAmsProductAccount(amsProductAccount);
    }


//
//
//    @ApiOperation(value = "修改组织")
//    @RequiresPermissions("ams:product:update")
//    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
//    public String update(@PathVariable("id") long id, ModelMap modelMap) {
//        AmsProduct amsProduct = amsProductService.selectByPrimaryKey(id);
//        modelMap.put("amsProduct", amsProduct);
//        return  "/product/update";
//    }
//
//    @ApiOperation(value = "修改组织")
//    @RequiresPermissions("ams:product:update")
//    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
//    @ResponseBody
//    public Object update(@PathVariable("id") long id, AmsProduct amsProduct) {
//        ComplexResult result = FluentValidator.checkAll()
//                .on(amsProduct.getProductName(), new LengthValidator(1, 20, "名称"))
//                .doValidate()
//                .result(ResultCollectors.toComplex());
//        if (!result.isSuccess()) {
//            return new UpmsResult(UpmsResultConstant.INVALID_LENGTH, result.getErrors());
//        }
//        amsProduct.setProductId(id);
//        int count = amsProductService.updateByPrimaryKeySelective(amsProduct);
//        return new UpmsResult(UpmsResultConstant.SUCCESS, count);
//    }
}
