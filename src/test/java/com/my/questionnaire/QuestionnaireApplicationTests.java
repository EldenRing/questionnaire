package com.my.questionnaire;

import com.my.questionnaire.mapper.UserMapper;
import com.my.questionnaire.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionnaireApplicationTests {
	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
	}

	/**
	 * mysql数据库功能测试
	 */
	@Test
	public void dbtest(){
		User user = new User();
		user.setName("1111");
		userMapper.insert(user);
		userMapper.getAll();
	}

}
