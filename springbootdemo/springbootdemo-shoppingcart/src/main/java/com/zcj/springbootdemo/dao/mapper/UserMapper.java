package com.zcj.springbootdemo.dao.mapper;

import com.zcj.springbootdemo.domain.entity.User;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/4/7.
 */
@Repository("userMapper")
public interface UserMapper {
    @Select("SELECT * from `user`  where user_code = #{userCode}")
    @ResultType(User.class)
    User selectByPrimaryKey(Integer userCode);
}
