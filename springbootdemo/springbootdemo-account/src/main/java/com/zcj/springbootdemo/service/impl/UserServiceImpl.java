package com.zcj.springbootdemo.service.impl;

import com.zcj.springbootdemo.dao.UserDao;
import com.zcj.springbootdemo.domain.entity.User;
import com.zcj.springbootdemo.service.inter.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/4/7.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    /**
     * 新增用户
     * @param user
     * @return
     */
    @Override
    public User addUser(User user) {
        return userDao.save(user);
    }

    /**
     * 查找指定用户
     * @param id
     * @return
     */
    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    /**
     * 查找所有用户
     * @return
     */
    @Override
    public Iterable<User> findAll() {
        return userDao.findAll();
    }

    /**
     * 删除指定用户
     * @param id
     */
    @Override
    public void deleteById(Long id) {
        userDao.delete(id);
    }
}
