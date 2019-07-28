package com.my.questionnaire.mapper;

import com.my.questionnaire.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Chen Wei
 * @Date: Created in 15:40 2019/7/18
 */

public interface UserMapper {
    @Select("SELECT * FROM usertest")
    List<User> getAll();

    @Insert("INSERT INTO usertest (name) VALUES(#{name})")
    void insert(User user);

    @Select("select * from usertest where id=#{id}")
    User getOne(Long id);
}
