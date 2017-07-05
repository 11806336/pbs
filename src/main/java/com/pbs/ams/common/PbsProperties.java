package com.pbs.ams.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by whb on 2017/7/4.
 */
@Configuration
@PropertySource("classpath:pbs.properties")
public class PbsProperties {
    @Value("${jdbc_url}")
    public  String jdbcUrl; //这里变量不能定义成static

    @Value("${jdbc_username}")
    public  String username;

    @Value("${jdbc_password}")
    public  String password;
}
