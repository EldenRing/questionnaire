package com.my.questionnaire.comm.untils;

import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

/**
 * @Author: Chen Wei
 * @Date: Created in 16:50 2019/7/24
 */

public class JwtTokenUtil implements Serializable {
    private static final long serialVersionUID = -3662417479566179888L;
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;
}
