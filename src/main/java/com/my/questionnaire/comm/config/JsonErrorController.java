package com.my.questionnaire.comm.config;

import com.my.questionnaire.domain.result.R;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 默认异常json返回异常处理格式
 *
 * @Author: Chen Wei
 * @Date: Created in 16:04 2019/7/19
 */
@RestController
@RequestMapping("${server.error.path:${error.path:/error}}")
public class JsonErrorController extends BasicErrorController {
    private static final ErrorProperties ERROR_PROPERTIES;
    private static final ErrorAttributes ERROR_ATTRIBUTES;

    static {
        ERROR_PROPERTIES = new ErrorProperties();
        ERROR_PROPERTIES.setIncludeStacktrace(ErrorProperties.IncludeStacktrace.ALWAYS);
        ERROR_ATTRIBUTES = new DefaultErrorAttributes();
    }

    public JsonErrorController() {
        super(ERROR_ATTRIBUTES, ERROR_PROPERTIES);
    }

    /**
     * JSON格式错误信息
     */
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> body = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.ALL));
        body = R.toMap(R.failed(null, String.valueOf(body.get("message"))));
        HttpStatus status = getStatus(request);
        return new ResponseEntity<>(body, status);
    }


}
