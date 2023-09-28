package com.magic.dao;

import com.magic.domain.Discuss;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DicussDao {
    //获得影响行数
    int countrow();

    //评论分页查询
    @Results(id = "DiscussMap",value = {
            @Result(column="article_id" ,property="articleId"),
            @Result(column="user_name" ,property="userName"),
            @Result(column="discuss_details" ,property="discussDetails"),
            @Result(column="discuss_like" ,property="discussLike"),
            @Result(column="create_time", property="createTime"),
            @Result(column="modify_time", property="modifyTime")
    })
    @Select("select * from discuss where article_id=#{articleId} ORDER BY modify_time DESC limit #{begin},#{size} ;")

    List<Discuss> selectDiscuss(@Param("articleId") int articleId, @Param("begin")int begin, @Param("size")int size);

    //添加评论
    @Insert("insert into discuss (article_id, user_name, discuss_details, discuss_like)\n" +
            "        values (#{articleId}, #{userName}, #{discussDetails}, #{discussLike});\n" +
            "        UPDATE article set article_discuss=article_discuss+1 where article_id=#{articleId};")
    @ResultMap("DiscussMap")
    int discussAdd(Discuss discuss);

    //总评论数
    @Select("select count(*) from discuss where article_id= #{articleId}")
    int discussCount(@Param("articleId") int articleId);





}
