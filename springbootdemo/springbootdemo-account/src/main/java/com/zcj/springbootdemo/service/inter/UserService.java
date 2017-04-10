package com.zcj.springbootdemo.service.inter;

import com.zcj.springbootdemo.domain.entity.User;

/**
 * Created by Administrator on 2017/4/7.
 */
public interface UserService {
    /**
     * 新增用户
     * @param user
     * @return
     */
    User addUser(User user);

    /**
     * 依照Id查找用户
     * @param id
     * @return
     */
    User findById(Long id);

    /**
     * 获取所有用户
     * @return
     */
    Iterable<User> findAll();

    /**
     * 删除指定用户
     * @param id
     */
    void deleteById(Long id);
}
