package com.vector.tfriend.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * author: vector.huang
 * date：2016/3/2 14:59
 */
public final class StatusUtils {

    private static Logger logger = LoggerFactory.getLogger(StatusUtils.class);

    public static boolean isRecordNotFound(Object o, JsonResult result) {
        String message = "找不到该记录";
        return isRecordNotFound(o, message, result);
    }

    public static boolean isRecordNotFound(Object o, String message, JsonResult result) {
        if (o == null) {
            logger.debug(message);
            result.setMessage(message);
            result.setStatus(StatusCode.CODE_RECORD_NOT_FOUND);
            return true;
        }
        return false;
    }

    public static boolean notLogin(Object o, JsonResult result) {
        if (o == null) {
            String message = "token 已过期，请重新登录";
            logger.debug(message);
            result.setMessage(message);
            result.setStatus(StatusCode.CODE_NOT_LOGIN);
            return true;
        }
        return false;
    }

}
