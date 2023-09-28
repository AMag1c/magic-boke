package com.magic.service.impl;

import com.magic.dao.ArticleDao;
import com.magic.domain.Article;
import com.magic.domain.PageBean;
import com.magic.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public PageBean selectArticleAll(String username,Integer currentpage,Integer pageSize) {

        PageBean page =new PageBean();
        int size = currentpage*pageSize;

        int countall = articleDao.articleCount();
        List<Article> all = articleDao.selectArticleAll(username,0,size);
        if ((size+pageSize)>=countall){
            page.setCode(1);
        }

        page.setCurrent(currentpage+1);
        page.setTotalCount(countall);
        page.setPojo(all);

        return page;
    }

    @Override
    public Integer articleAdd(String userName,String articleDetails) {
        return articleDao.articleAdd(userName,articleDetails);
    }

    @Override
    public Integer articleDelete(Integer articleId) {
        return articleDao.articleDelete(articleId);
    }

    @Override
    public Integer articleModify(Article article) {
        return articleDao.articleModify(article);
    }

    @Override
    public PageBean articleSearch(String username, String search) {
        PageBean pageBean = new PageBean();

        List<Article> ar = articleDao.articleSearch("%" + search + "%");
        List<Article> a = articleDao.selectArticleAll(username, 0, 7);

        if (ar == null || ar.isEmpty()) {
            pageBean.setCode(0);
            pageBean.setPojo(a);
            return pageBean;
        }

        System.out.println(ar);
        pageBean.setCode(1);
        pageBean.setPojo(ar);

        return pageBean;
    }
}
