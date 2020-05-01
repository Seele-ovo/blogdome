package cn.exampl.useradmin.controller;

import cn.exampl.useradmin.dao.UserDao;
import cn.exampl.useradmin.enitiy.User;
import cn.example.code.entity.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 此类用于管理用户的注册与登陆权限，注册后会给相应的邮箱发送一个邮件
 * 用到消息队列
 */
@RestController
public class UserController {


}
