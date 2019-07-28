package com.my.questionnaire.comm.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * 全局异常处理器
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    //例子
    /*@ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public R RErrorHandler(Exception e, HttpServletRequest request) {
        log.info("请求地址：" + request.getRequestURL());
        log.error("异常信息：", e);
        return R.failed(e.getLocalizedMessage());
    }*/
}
