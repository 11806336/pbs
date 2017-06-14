package com.pbs.ams.web.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by RX-013 on 2017/6/12.
 */
@Component
@Scope(value = "prototype")
public class EnvBean {
    //实体类前加@Component ，让spring扫描到该实体类，默认是单例模式,该实体类的功能是从 data.properties 资源文件中读取对应的内容
    @Value("${profile.env}")
    public  String profile_env;


    @Value("${jdbc.url}")
    public  String jdbc_url;
}
