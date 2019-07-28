package com.my.questionnaire.comm.config;

import com.my.questionnaire.comm.filter.OptionsRequestFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.Header;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * @Author: Chen Wei
 * @Date: Created in 10:51 2019/7/25
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/css/**", "/js/**", "/index").permitAll()//放过的请求
                .anyRequest().authenticated()//权限拦截的请求
                .and()
                .csrf().disable()//关闭csrf处理
                .formLogin().disable()//放弃form登入提交方式
                .sessionManagement().disable()//禁用session
                .cors()//支持跨领
                .and() //添加header设置，支持跨域和ajax请求
                .headers().addHeaderWriter(new StaticHeadersWriter(Arrays.asList(
                new Header("Access-control-Allow-Origin", "*"),
                new Header("Access-Control-Expose-Headers", "Authorization")
        )))//返回*
                .and()
                .addFilterAfter(new OptionsRequestFilter(), CorsFilter.class);//拦截OPTIONS请求，直接返回header



    }

}
