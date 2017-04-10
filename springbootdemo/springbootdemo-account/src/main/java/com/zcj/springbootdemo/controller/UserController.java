package com.zcj.springbootdemo.controller;

import com.zcj.springbootdemo.dao.UserDao;
import com.zcj.springbootdemo.domain.entity.User;
import com.zcj.springbootdemo.service.inter.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/10.
 */
@RestController
@RequestMapping(value = "/user")
@Api(description = "用户")
public class UserController {

    @Resource
    UserService userService;

    /**
     * 添加新用户
     *
     * @param name
     * @param pwd
     * @return
     */
    @ApiOperation(value = "添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "name", paramType = "query", required = true),
            @ApiImplicitParam(name = "pwd", value = "pwd", paramType = "query", required = true)
    })
    @RequestMapping(value = "/adduser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String addUser(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "pwd") String pwd) {
        User user = new User();
        user.setName(name);
        user.setPwd(pwd);
        user.setCreatedAt(new Date());
        userService.addUser(user);

        return "add user success !";
    }

    /**
     * 查找指定用户
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查找指定用户")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "int")
    @RequestMapping(value = "/findbyid", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String findById(@RequestParam(value = "id") Long id) {
        User user = userService.findById(id);

        if (user == null) {
            return "error";
        } else {
            return "name:" + user.getName();
        }
    }

    /**
     * 查找所有用户
     *
     * @return
     */
    @ApiOperation(value = "查询所有用户")
    @RequestMapping(value = "/findall", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Iterable findAll() {
        Iterable<User> userList = userService.findAll();
        return userList;
    }

    /**
     * 删除指定用户
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除用户")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "int")
    @RequestMapping(value = "/deletebyid", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String deleteById(@RequestParam(value = "id") Long id) {
        userService.deleteById(id);

        return "delete success !";
    }
}
