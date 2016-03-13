package com.vector.tfriend.handler;

import com.vector.tfriend.helper.JsonResult;
import com.vector.tfriend.helper.StatusCode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.PriorityOrdered;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全部异常都使用者类来处理。DefaultHandlerExceptionResolver 和 SimpleMappingExceptionResolver
 * 都不起作用了
 *
 * @author vector.huang
 * @date 2016年2月29日 下午12:03:35
 */
public class CustomExceptionResolver implements HandlerExceptionResolver,
        PriorityOrdered {

    private Logger logger = LoggerFactory
            .getLogger(CustomExceptionResolver.class);

    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {

        JsonResult result = new JsonResult();
//        LogUtils.printException2File(ex);

        logger.debug("出现了异常了 -- " + ex.getMessage());
        ex.printStackTrace();
        Map<String, Object> model = new HashMap<String, Object>();

        if (ex instanceof MultipartException) {
            /**
             * 上传文件需要使用Multipart 方式
             */
            result.setStatus(StatusCode.CODE_REQUEST_MODEL_ERROR);
            result.setMessage("请使用Multipart 方式请求");

//        } else if (ex instanceof EmptyFileException) {
            /**
             * 上传了一个空文件
             */
//            result.setStatus(StatusCode.CODE_PARAM_INCORRECT);
//            result.setMessage(ex.getMessage());
        } else if (ex instanceof NullPointerException
                || ex instanceof IOException
                || ex instanceof IllegalStateException
                || ex instanceof IllegalArgumentException) {
            result.setStatus(StatusCode.CODE_SYSTEM_ERROR);
            result.setMessage("口袋正在努力修复中(-1.-1)");
        /*} else if (ex instanceof SQLGrammarException) {
            result.setStatus(StatusCode.CODE_SYSTEM_ERROR);
            result.setMessage("口袋数据库升级中(-1,-2)");
        } else if (ex instanceof MissingServletRequestParameterException) {
            result.setStatus(StatusCode.CODE_PARAM_INCORRECT);
            MissingServletRequestParameterException exception = (MissingServletRequestParameterException) ex;
            result.setMessage("缺少请求参数 : " + exception.getParameterName());
        } else if (ex instanceof DataIntegrityViolationException) {
            //违反约束，一般是找不到对应的id号
            StatusUtils.isRecordNotFound(null, result);*/
        } else if (ex instanceof TypeMismatchException) {
            result.setStatus(StatusCode.CODE_PARAM_INCORRECT);
            TypeMismatchException exception = (TypeMismatchException) ex;
            result.setMessage("请求参数 " + exception.getValue() + "不是 " + exception.getRequiredType() + "类型");
        } else {
            logger.error("未处理的异常 -- " + ex.getMessage());
            result.setStatus(StatusCode.CODE_UNKNOW_ERROR);
            result.setMessage("口袋也不知道怎么回事了(1.1)");
        }
        model.put("result", result.toJson());
        return new ModelAndView("customExceptionView", model);
    }

    public int getOrder() {
        return 0;
    }
}
