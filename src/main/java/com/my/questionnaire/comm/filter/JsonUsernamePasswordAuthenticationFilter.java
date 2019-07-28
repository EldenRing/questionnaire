package com.my.questionnaire.comm.filter;

import com.my.questionnaire.domain.enums.CommonConstants;
import com.alibaba.fastjson.JSONObject;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 自定义json登入过滤器(替换springboot默认的form登入) 拦截/login地址
 * @Author: Chen Wei
 * @Date: Created in 9:23 2019/7/26
 */
@Component
public class JsonUsernamePasswordAuthenticationFilter  extends AbstractAuthenticationProcessingFilter {
    public JsonUsernamePasswordAuthenticationFilter(){
        super(new AntPathRequestMatcher("/login", RequestMethod.POST.name()));
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String reaquestBody = StreamUtils.copyToString(request.getInputStream(), Charset.forName(CommonConstants.UTF8));
        String username = null;
        String password = null;
        if (StringUtils.hasText(reaquestBody)) {
            JSONObject jsonObject = JSONObject.parseObject(reaquestBody);
            username=jsonObject.getString("username");
            password=jsonObject.getString("password");
        }
        //将token配置进authenticationManager
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username == null ? "" : username.trim(), password == null ? "" : password);
        return this.getAuthenticationManager().authenticate(token);
    }
}
