package com.zcj.springbootdemo.service.inter;

import com.zcj.springbootdemo.domain.entity.User;

/**
 * Created by Administrator on 2017/4/7.
 */
public interface UserService {
    public User selectByPrimaryKey(Integer userCode);
}
