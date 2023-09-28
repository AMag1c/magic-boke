package com.magic.dao;

import com.magic.domain.Photo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PhotoDao {
    //获得影响行数
    int countrow();

    //获取用户的相册图片
    List<Photo> PhotoAll(@Param("userName")String username);


}
