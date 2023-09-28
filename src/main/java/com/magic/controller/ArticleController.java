package com.magic.controller;

import com.magic.domain.Article;
import com.magic.domain.MessageModel;
import com.magic.domain.PageBean;
import com.magic.domain.User;
import com.magic.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("/Articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 查找所有文章
     * @return
     */
    @RequestMapping("/selectArticleAll")
    public PageBean selectArticleAll(Integer currentpage,String userName) {
        //设置每次显示条数
        int pageSize = 7;

        return articleService.selectArticleAll(userName,currentpage,pageSize);
    }

    /**
     * 添加文章
     * @param
     * @param articleDetails
     * @return
     */
    @RequestMapping("/articleAdd")
    public Integer articleAdd(@RequestBody String articleDetails, HttpServletRequest request){

        System.out.println("article+++++"+request.getSession().getAttribute("user"));

//        System.out.println(user.getObject());
//        System.out.println(us.getUserName());

        return articleService.articleAdd("magic",articleDetails);
    }

    /**
     * 删除文章
     * @param articleId
     * @return
     */
    @RequestMapping("/articleDelete")
    public Integer articleDelete(@RequestParam("id") Integer articleId){
        return articleService.articleDelete(articleId);
    }


    /**
     * 修改文章
     * @param article
     * @return
     */
    @RequestMapping("/articleModify")
    public Integer articleModify(@RequestBody Article article){
        return articleService.articleModify(article);
    }

    /**
     * 搜索文章
     * @param inputSearch
     * @return
     */
    @RequestMapping("/articleSearch")
    public PageBean articleSearch(String inputSearch){
        String username=null;
        return articleService.articleSearch(username,inputSearch);
    }


//    @RequestMapping("/selectUserArticle")
//    public PageBean selectUserArticle(String userName){
//        String username=null;
//        return articleService.articleSearch(username,inputSearch);
//    }



}
