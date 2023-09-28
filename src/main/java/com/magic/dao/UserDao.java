package com.magic.dao;

import com.magic.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    //获得影响行数
    int countrow();

    /*登录 查找用户SQL(根据用户名)*/
    @Results(id = "UserMap",value = {
            @Result(column="user_id" ,property="userId"),
            @Result(column="user_name" ,property="userName"),
            @Result(column="user_password", property="password"),
            @Result(column="user_email" ,property="email"),
            @Result(column="user_introduction", property="userIntroduction"),
            @Result(column="user_fannum", property="userFanNum"),
            @Result(column="user_attentionnum" ,property="userAttentionNum")
    })
    @Select("select * from user where user_name = #{userName};")
    User selectUser(@Param("userName")String userName);

    /*登录 查找用户邮箱*/
    @Select("select * from user where user_email = #{email};")
    User selectUserEmail(String email);

//    /*登录 查找用户密码*/
//    @Select("select *\n" +
//            "        from user\n" +
//            "        where user_name=#{userName} and user_password = #{oldPassword};")
//    User selectUserPassword(User user);

    /*注册 添加用户SQL*/
    @Insert("insert into user (user_id, user_name, user_password, user_email)\n" +
            "        values (null, #{userName}, #{password}, #{email});")
    @ResultMap("UserMap")
    void userAdd(User user);

    //用户密码修改
    @Update("UPDATE user set user_password = #{password} where user_name=#{userName};")
    @ResultMap("UserMap")
    int modifyPassword(User user);

    //上传照片
    int userPhotoUpload(@Param("userName")String userName,@Param("photoPath")String photoPath);

    //判断是否已关注该用户
    @Select("select count(*) from user_follow where user_name=#{userName} and follow_name=#{otherUsers};")
    int followSelect(@Param("userName")String userName,@Param("otherUsers")String otherUsers);

    //添加用户关注
    @Insert("insert into user_follow (user_name, follow_name) values (#{userName},#{folloName});\n" +
            "        UPDATE user set\n" +
            "            user_attentionnum =user_attentionnum+1  where user_name=#{userName};\n" +
            "        UPDATE user set\n" +
            "            user_fannum =user_fannum+1  where user_name=#{folloName};")
    int followUsers(@Param("userName")String userName,@Param("folloName")String folloName);

    //取消用户关注
    @Delete("delete from user_follow where user_name=#{userName} and follow_name=#{folloName};\n" +
            "    UPDATE user set\n" +
            "        user_attentionnum =user_attentionnum-1  where user_name=#{userName};\n" +
            "    UPDATE user set\n" +
            "        user_fannum =user_fannum-1  where user_name=#{folloName};")
    int unFollow(@Param("userName")String userName,@Param("folloName")String folloName);

    //查看关注列表
    @Select("select *from user where user_name in\n" +
            "         (select follow_name from user_follow where user_name=#{userName}) \n" +
            "         limit #{begin},#{size};")
    @ResultMap("UserMap")
    List<User> followList(@Param("userName")String userName,@Param("begin") int begin,@Param("size") int size);

    //查找用户关注行数
    @Select("select count(*) from user_follow where user_name=#{userName};")
    int focusCount(@Param("userName")String userName);

//    用户点赞
    int userLike(@Param("userName")String userName, @Param("articleId")String articleId);

//    取消点赞
    int userUnLike(@Param("userName")String userName, @Param("articleId")String articleId);

}
