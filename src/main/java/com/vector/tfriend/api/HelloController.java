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
@RequestMapping("hello")
@Controller
public class HelloController {
    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "say", method = {RequestMethod.GET})
    public String hello() {
        logger.debug("Hello Maven SpringMVC");
        System.out.println("Hello Maven SpringMVC");
        return "success";
    }

    @RequestMapping(value = "failure", method = {RequestMethod.GET})
    public String failure() {
        logger.debug("Hello Maven failure");
        System.out.println("Hello Maven failure");
        return "failure";
    }

    @RequestMapping(value = "logout", method = {RequestMethod.GET})
    public String logout() {
        logger.debug("Hello Maven logout");
        System.out.println("Hello Maven logout");
        return "logout";
    }

    @RequestMapping(value = "admin", method = {RequestMethod.GET})
    public String admin() {
        logger.debug("Hello Maven SpringMVC");
        System.out.println("Hello Maven SpringMVC");
        return "success";
    }

}
