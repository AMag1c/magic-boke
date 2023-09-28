package com.magic.dao;

import com.magic.domain.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface ArticleDao {


    /**
     * 查询文章总行数
     * @return
     */
    @Select("select count(*) from article;")
    int articleCount();


    /**
     * 查询所有文章
     * @return
     */
    @Results(id = "ArticleMap",value = {
            @Result(column="article_id" ,property="articleId"),
            @Result(column="user_name", property="userName"),
            @Result(column="article_details", property="articleDetails"),
            @Result(column="article_transmit" ,property="articleTransmit"),
            @Result(column="article_discuss", property="articleDiscuss"),
            @Result(column="article_like", property="articleLike"),
            @Result(column="create_time" ,property="createTime"),
            @Result(column="modify_time", property="modifyTime")
    })
    @Select("<script> select *\n" +
            "        from article\n" +
            "        <if  test=\"userName != null and userName !=''\">\n" +
            "            where user_name=#{userName}\n" +
            "        </if>\n" +
            "        ORDER BY modify_time DESC\n" +
            "        limit #{begin},#{size}  </script>")
    List<Article> selectArticleAll(@Param("userName")String userName,@Param("begin") int begin, @Param("size") int size);


    /**
     * 添加文章
     * @param userName
     * @param articleDetails
     * @return
     */
    @Insert("insert into article (article_id, user_name, article_details)\n" +
            "        values (null, #{userName}, #{articleDetails});")
    @ResultMap("ArticleMap")
    int articleAdd(@Param("userName")String userName,@Param("articleDetails")String articleDetails);

    /**
     * 删除文章
     * @param articleId
     * @return
     */
    @Delete("delete from article where article_id = #{articleId}")
    int articleDelete(@Param("articleId")Integer articleId);

    /**
     * 修改文章
     * @param article
     * @return
     */
    @Update("UPDATE article\n" +
            "        set article_details=#{articleDetails}\n" +
            "        WHERE article_id = #{articleId};")
    @ResultMap("ArticleMap")
    int articleModify(Article article);



    @Select("select *\n" +
            "        from article\n" +
            "        where article_details like #{search} or user_name like #{search}\n" +
            "        ORDER BY modify_time DESC;")
    @ResultMap("ArticleMap")
    List<Article> articleSearch(String search);

}
