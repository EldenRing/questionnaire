package com.my.questionnaire.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户
 *
 */
@Data
public class User  implements Serializable {

	private static final long serialVersionUID = 3332164225578273028L;
	private Long id;

	private String name;
}