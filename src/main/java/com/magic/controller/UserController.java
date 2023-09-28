package com.magic.controller;

import com.magic.domain.MessageModel;
import com.magic.domain.PageBean;
import com.magic.domain.User;
import com.magic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录状态
     */
    @RequestMapping("/state")
    public Object state(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("user");
        System.out.println("This is Session:"+user);

        if (user != null || user.equals("")) ;
        {
            return user;
        }

    }

    /**
     * 登录
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public MessageModel login(@RequestBody User user,HttpServletRequest request) {

        MessageModel messageModel = userService.login(user);

        if (messageModel.getCode() == 1) {   //成功
            //将消息模型中的用户信息设置到session作用域中
            request.getSession().setAttribute("user", messageModel);
            System.out.println("使用一次");

        } else {     //失败
            // 将消息模型对象设置到request作用域中
            request.setAttribute("loginModel", messageModel);
        }

        return messageModel;
    }

    /**
     * 注册
     * @param
     * @return
     */
    @RequestMapping("/registe")
    public MessageModel registe(@RequestBody User user) {
        return userService.registe(user);
    }


//
    /**
     * 注销
     */
    @RequestMapping("/logout")
    public int logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if (session != null || session.equals("")) {
            // 2.删除属性
            session.removeAttribute("user");
            return 1;
        }else {
            return 2;
        }
    }


    @RequestMapping("/modifyPassword")
    public MessageModel modifyPassword(@RequestBody User user,HttpServletRequest request) {

        MessageModel messageModel = userService.modifyPassword(user);

        if (messageModel.getCode() > 0) {

            request.getSession().setAttribute("user", messageModel);
        }
        return messageModel;
    }


    /**
     * 用户个人界面信息
     * @param userName
     * @return
     */
    @RequestMapping("/userDetails")
    public User userDetails(String userName) {

        return userService.userDetails(userName);
    }


    /**
     * 对是否关注了该用户的判断
     * @param otherUsers
     * @return
     */
    @RequestMapping("/followSelect")
    public Integer followSelect(@RequestParam("userName") String otherUsers) {

        String userName="magic";

        return userService.followSelect(userName,otherUsers);
    }


    /**
     * 添加关注用户
     * @param folloname
     * @return
     */
    @RequestMapping("/followUsers")
    public Integer followUsers(@RequestParam("userName") String folloname) {

        String userName="magic";
        return userService.followUsers(userName,folloname);
    }

    /**
     * 取消关注用户
     * @param folloname
     * @return
     */
    @RequestMapping("/unFollow")
    public Integer unFollow(@RequestParam("userName") String folloname) {
        String userName="magic";
        return userService.unFollow(userName,folloname);
    }


    /**
     * 查看关注列表
     */
    @RequestMapping("/followList")
    public PageBean followList(Integer current,Integer size) {

        String userName="magic";

        return userService.followList(userName,current,size);
    }
//
//    /**
//     * 点赞
//     */
//    @RequestMapping("/userLike")
//    public void userLike() {
//
//        return userService.userLike();
//    }
//
//    /**
//     * 取消点赞
//     */
//    @RequestMapping("/userUnLike")
//    public void userUnLike() {
//
//        return userService.userUnLike();
//    }
}
