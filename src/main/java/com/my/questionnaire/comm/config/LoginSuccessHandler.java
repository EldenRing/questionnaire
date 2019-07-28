package com.my.questionnaire.comm.config;

import com.my.questionnaire.domain.enums.CommonConstants;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 登入成功返回token @Author: Chen Wei @Date: Created in 10:00 2019/7/27 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
  @Override
  public void onAuthenticationSuccess(
      HttpServletRequest request, HttpServletResponse response, Authentication authentication)
      throws IOException, ServletException {
    String token = ""; // 具体token生成方法
    response.setHeader(CommonConstants.HEAD_ATTRIBUTE_AUTHORIZTION, token);
  }
}
