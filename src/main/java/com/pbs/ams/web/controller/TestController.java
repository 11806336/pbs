package com.pbs.ams.web.controller;

import Jama.Matrix;
import com.pbs.ams.web.mappers.*;
import com.pbs.ams.web.model.EnvBean;
import com.pbs.ams.web.model.RptStoStyFactorsDealInfo;
import com.pbs.ams.web.service.TestService;
import com.pbs.ams.web.service.UpmsApiService;
import com.pbs.ams.web.service.UpmsLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

/**
 * Created by RX-013 on 2017/6/7.
 */
@Controller
@RequestMapping(value = "/Test/*")
public class TestController {

    @Autowired
    TestService testService;

    @Autowired
    UpmsApiService upmsApiService;

    @Autowired
    UpmsLogService upmsLogService;

    @Autowired
    UpmsApiMapper upmsApiMapper;

    @Autowired
    UpmsUserMapper upmsUserMapper;


    @Autowired
    UpmsRolePermissionMapper upmsRolePermissionMapper;

    @Autowired
    UpmsUserPermissionMapper upmsUserPermissionMapper;

    @Autowired
    UpmsSystemMapper upmsSystemMapper;

    @Autowired
    UpmsOrganizationMapper upmsOrganizationMapper;

    @Autowired
    UpmsLogMapper upmsLogMapper;

    @Autowired
    EnvBean envBean;

    @Autowired
    RptStoStyFactorsDealInfoMapper rptStoStyFactorsDealInfoMapper;




    //访问地址：http://localhost:8080/Test/returnSuccess
    @RequestMapping(value = "returnSuccess")
    public String returnSuccess() {
        return "/index";
    }

    //访问地址：http://localhost:8080/Test/returnString
    @RequestMapping(value = "returnString", produces = {"text/plain;charset=UTF-8"})
    //produces用于解决返回中文乱码问题，application/json;为json解决中文乱码
    @ResponseBody
    public String returnString() {
        return "hello return string 这是中文，并没有乱码";
    }


    //访问地址：http://localhost:8080/Test/returnString
    @RequestMapping(value = "testService", produces = {"text/plain;charset=UTF-8"})
    //produces用于解决返回中文乱码问题，application/json;为json解决中文乱码
    @ResponseBody
    public String testService() {
        return testService.hello()+ envBean.profile_env;
    }

    //访问地址：http://localhost:8080/Test/returnString
    @RequestMapping(value = "testJama")
    //produces用于解决返回中文乱码问题，application/json;为json解决中文乱码
    @ResponseBody
    public   double[][]  testJama() {

        List<RptStoStyFactorsDealInfo> list = null;
        double[][] array = null;
        try {
            list = rptStoStyFactorsDealInfoMapper.selectAll();
            array = new double[list.size()][];
            Iterator<RptStoStyFactorsDealInfo> iterator = list.iterator();
            int i = 0;
            while (iterator.hasNext()){
                double[] con = Obj2Array(iterator.next());
                array[i] = con;
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //原矩阵
        Matrix matrix = new Matrix(array);

        Matrix DD= null;
        try {
            Matrix AA=matrix.transpose();
            DD = (AA.times(matrix)).inverse().times(AA);
            DD.print(4,2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  DD.getArrayCopy();
    }


    public  double[] Obj2Array(Object obj) throws Exception{

        double[] con = new double[45];

        for (int j = 0; j <28 ; j++) {
            if(j==10){
                con[j] = 1.0;
            }else{
                con[j] = 0.0;
            }
        }

        Field[] fields = obj.getClass().getDeclaredFields();
        int i = 28;
        for(Field field:fields){
            i++;
            if(i>31&i<48){
                field.setAccessible(true);
                BigDecimal bg = new BigDecimal((long)field.get(obj));
                con[i-4] = bg.doubleValue() ;
            }
        }

        return con;
    }
}
