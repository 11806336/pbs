package com.pbs.ams.web.service.impl;

import com.pbs.ams.web.service.TestService;
import org.springframework.stereotype.Service;

/**
 * Created by RX-013 on 2017/6/8.
 */
@Service
public class TestServiceImpl implements TestService{
    @Override
    public String hello() {
        return "test-hello-service";
    }
}
