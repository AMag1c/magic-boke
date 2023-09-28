package com.magic.controller;

import com.magic.domain.Discuss;
import com.magic.domain.PageBean;
import com.magic.service.ArticleService;
import com.magic.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/Discuss")
public class DiscussController {
    @Autowired
    private DiscussService discussService;


    /**
     * 评论分页查询
     * @param articleId
     * @param current
     * @param size
     * @return
     */
    @RequestMapping("/selectDiscuss")
    public PageBean selectDiscuss(Integer articleId, Integer current,Integer size) {
        System.out.println(discussService.selectDiscuss(articleId,current,size));
        return discussService.selectDiscuss(articleId,current,size);
    }


    /**
     * 添加评论
     * @param discuss
     * @param request
     * @return
     */

    @RequestMapping("/discussAdd")
    public Integer discussAdd(@RequestBody Discuss discuss, HttpServletRequest request) {


        System.out.println("article+++++"+request.getSession().getAttribute("user"));

        String userName="magic";

        discuss.setUserName(userName);

        return discussService.discussAdd(discuss);
    }

}
