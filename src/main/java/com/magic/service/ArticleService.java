package com.magic.service;

import com.magic.domain.Article;
import com.magic.domain.PageBean;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

public interface ArticleService {

    /**
     * 查询所有文章
     * @return
     */
    PageBean selectArticleAll(String username,Integer currentpage,Integer pageSize);

    /**
     * 添加文章
     * @param userName
     * @param articleDetails
     * @return
     */
    Integer articleAdd(String userName,String articleDetails);

    /**
     * 删除文章
     * @param articleId
     * @return
     */
    Integer articleDelete(Integer articleId);


    /**
     * 修改文章
     * @param article
     * @return
     */
    Integer articleModify(Article article);

    PageBean articleSearch(String username ,String search);
}
