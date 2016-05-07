package com.vector.tfriend.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * author: vector.huang
 * date：2016/3/11 15:55
 */
@RequestMapping("public")
@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "login", method = {RequestMethod.GET})
    public String hello() {
        logger.debug("Hello Maven login");
        System.out.println("Hello Maven login");
        return "login";
    }

}
