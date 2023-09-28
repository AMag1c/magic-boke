package com.magic.service;

import com.magic.domain.MessageModel;
import com.magic.domain.PageBean;
import com.magic.domain.User;

public interface UserService {



    MessageModel login(User user);

    MessageModel registe(User user);

    User userDetails(String userName);

    Integer followSelect(String userName, String otherUsers);

    Integer followUsers(String userName, String folloname);

    Integer unFollow(String userName, String folloname);

    PageBean followList(String userName, Integer current, Integer size);

    MessageModel modifyPassword(User user);



}
