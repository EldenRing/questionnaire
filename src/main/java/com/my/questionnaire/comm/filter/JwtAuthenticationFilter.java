package com.my.questionnaire.comm.filter;

import com.my.questionnaire.domain.enums.CommonConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 请求提取head中的token 实现认证 @Author: Chen Wei @Date: Created in 10:35 2019/7/27 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
  private RequestMatcher requireAuthenicationRequestMatcher;

  public JwtAuthenticationFilter() {
    requireAuthenicationRequestMatcher =
        new RequestHeaderRequestMatcher(CommonConstants.HEAD_ATTRIBUTE_AUTHORIZTION);
  }

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    // 确认是否要权限认证 请求头带不带authoriztion
    if (!requiresAuthenication(request)) {
      filterChain.doFilter(request, response);
      return;
    }
    String jwtToken = getJwtToken(request);

  }

  protected String getJwtToken(HttpServletRequest request) {
    return StringUtils.removeStart(request.getHeader(CommonConstants.HEAD_ATTRIBUTE_AUTHORIZTION),"Bearer ");
  }

  protected boolean requiresAuthenication(HttpServletRequest request) {
    return requireAuthenicationRequestMatcher.matches(request);
  }
}
