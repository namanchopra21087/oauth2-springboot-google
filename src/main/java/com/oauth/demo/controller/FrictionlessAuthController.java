package com.oauth.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Slf4j
public class FrictionlessAuthController {

    @GetMapping(value = "/welcome", produces = "application/json")
    public String fasAuth() throws IOException {
        log.info("Request initiated inside fasAuth");
        return "WELCOME TO FAS";
    }

}
