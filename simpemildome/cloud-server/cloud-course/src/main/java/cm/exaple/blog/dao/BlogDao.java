package cm.exaple.blog.dao;


import cn.example.code.entity.BlogBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BlogDao {
    List<BlogBean> selBlog();

    BlogBean selBlogBean(int id);

    List<BlogBean> selSerchBlog(String title);

    int upReadBlog(int id);

    int delBlog(int id);

    int upBlog(@Param("title") String title,@Param("content") String content,@Param("smile") String smile,@Param("id") String id);

    int addBlog(String title, String content, String img);
}
