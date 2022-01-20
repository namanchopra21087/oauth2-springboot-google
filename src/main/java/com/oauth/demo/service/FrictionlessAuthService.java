package com.oauth.demo.service;

import com.oauth.demo.config.ApplicationProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FrictionlessAuthService {

    @Autowired
    ApplicationProperties appProperty;

    public void dummyService(){
        System.out.println(appProperty.getSqsReceiveMessageUrl());
    }
}
