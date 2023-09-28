package com.magic.service.impl;

import com.magic.dao.UserDao;
import com.magic.domain.MessageModel;
import com.magic.domain.PageBean;
import com.magic.domain.User;
import com.magic.service.UserService;
import com.magic.util.Stringutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public MessageModel login(User user) {
        MessageModel messageModel = new MessageModel();
        User users=userDao.selectUser(user.getUserName());
        messageModel.setObject(user);

        //1.参数的非空判断
        if(Stringutil.isEmpty(user.getUserName())||Stringutil.isEmpty(user.getPassword())){
            messageModel.setMsg("用户名、密码不能为空");
            return messageModel;
        }

        if (users==null){
            messageModel.setMsg("用户不存在");
            return messageModel;
        }
        if (!user.getPassword().equals(users.getPassword())){
            messageModel.setMsg("密码错误");
            return messageModel;
        }

        messageModel.setCode(1);
        messageModel.setMsg("登录成功");
        messageModel.setObject(users);
        System.out.println(messageModel);
        return messageModel;

    }

    @Override
    public MessageModel registe(User user) {
        MessageModel messageModel = new MessageModel();
        messageModel.setObject(user);

        if(Stringutil.isEmpty(user.getUserName())||Stringutil.isEmpty(user.getPassword())||Stringutil.isEmpty(user.getEmail())){
            messageModel.setMsg("不能留空");
            return messageModel;
        }

        if (userDao.selectUser(user.getUserName())!=null){
            messageModel.setMsg("用户名已存在");
            return messageModel;
        }

        System.out.println(userDao.selectUserEmail(user.getEmail()));

        if (userDao.selectUserEmail(user.getEmail())!=null){
            messageModel.setMsg("该邮箱已注册");
            return messageModel;
        }

        if (!user.getPassword().equals(user.getPasswordAgain())){
            messageModel.setMsg("两次输入的密码不一致");
            return messageModel;
        }


        userDao.userAdd(user);
        messageModel.setCode(1);
        messageModel.setMsg("注册成功");
        return messageModel;
    }


    @Override
    public MessageModel modifyPassword(User user) {

        MessageModel messageModel = new MessageModel();

        if(Stringutil.isEmpty(user.getPassword())||Stringutil.isEmpty(user.getPasswordAgain())||Stringutil.isEmpty(user.getOldPassword())){
            messageModel.setMsg("不能留空");
            return messageModel;
        }

        User us = userDao.selectUser(user.getUserName());



        if (!user.getOldPassword().equals(us.getPassword())){
            messageModel.setMsg("旧密码输入错误");
            return messageModel;
        }

        if (!user.getPassword().equals(user.getPasswordAgain())){
            messageModel.setMsg("两次输入的密码不一致");
            return messageModel;
        }
        System.out.println("88448484");
        int row = userDao.modifyPassword(user);

        if (row>0){
            messageModel.setCode(1);
            messageModel.setMsg("修改成功");
            messageModel.setObject(us);
            return messageModel;
        }

        messageModel.setMsg("修改失败");

        return messageModel;
    }

    @Override
    public User userDetails(String userName) {
        return userDao.selectUser(userName);
    }

    @Override
    public Integer followSelect(String userName, String otherUsers) {
        return userDao.followSelect(userName,otherUsers);
    }

    @Override
    public Integer followUsers(String userName, String folloname) {
        return userDao.followUsers(userName,folloname);
    }

    @Override
    public Integer unFollow(String userName, String folloname) {
        return userDao.unFollow(userName,folloname);
    }

    @Override
    public PageBean followList(String userName, Integer current, Integer size) {

        PageBean pageBean = new PageBean();

        int begin = (current-1)*size;

        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotalCount(userDao.focusCount(userName));
        pageBean.setPojo(userDao.followList(userName,begin,size));

        return pageBean;
    }

}
