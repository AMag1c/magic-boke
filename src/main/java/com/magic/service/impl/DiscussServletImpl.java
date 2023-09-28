package com.magic.service.impl;

import com.magic.dao.ArticleDao;
import com.magic.dao.DicussDao;
import com.magic.domain.Discuss;
import com.magic.domain.PageBean;
import com.magic.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussServletImpl implements DiscussService {

    @Autowired
    private DicussDao dicussDao;
    @Override
    public PageBean selectDiscuss(Integer articleId, Integer current, Integer size) {
        PageBean pageBean=new PageBean();

        int begin = (current-1)*size;
        List<Discuss> discuss=dicussDao.selectDiscuss(articleId,begin,size);
        int rows =  dicussDao.discussCount(articleId);

        pageBean.setCurrent(current);
        pageBean.setSize(size);
        pageBean.setTotalCount(rows);
        pageBean.setPojo(discuss);
        return pageBean;
    }


    @Override
    public Integer discussAdd(Discuss discuss) {
        return dicussDao.discussAdd(discuss);
    }


}
