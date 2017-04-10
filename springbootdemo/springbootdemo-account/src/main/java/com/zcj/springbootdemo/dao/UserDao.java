package com.zcj.springbootdemo.dao;

import com.zcj.springbootdemo.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2017/4/10.
 */
public interface UserDao extends CrudRepository<User, Long> {
    public User findById(Long id);
}
