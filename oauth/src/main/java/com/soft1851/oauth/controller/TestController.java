package com.soft1851.oauth.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zeng
 * @ClassName TestController
 * @Description TOOD
 * @Date 2020/4/29
 * @Version 1.0
 **/
@RestController
public class TestController {
    @RequestMapping("/")
    public String simpleIndex(ModelMap map) {
        return "hello";
    }
}
