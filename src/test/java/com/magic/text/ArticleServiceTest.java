package com.magic.text;

import com.magic.config.SpringConfig;
import com.magic.dao.ArticleDao;
import com.magic.domain.Article;
import com.magic.domain.MessageModel;
import com.magic.domain.PageBean;
import com.magic.domain.User;
import com.magic.service.ArticleService;
import com.magic.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class ArticleServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGet(){
        User user=new User();
        user.setUserName("QQQ");
        user.setPassword("123");
        MessageModel all = userService.login(user);
        System.out.println(all);
    }

}
