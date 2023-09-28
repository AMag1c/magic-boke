package com.magic.service;

import com.magic.domain.Discuss;
import com.magic.domain.PageBean;

public interface DiscussService {
    PageBean selectDiscuss(Integer articleId, Integer current, Integer size);

    Integer discussAdd(Discuss discuss);
}
