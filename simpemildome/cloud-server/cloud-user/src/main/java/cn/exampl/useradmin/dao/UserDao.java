package cn.exampl.useradmin.dao;

import cn.exampl.useradmin.enitiy.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    //判断是否有用户
    User getUser(User user);
   //查询全部数据
    List<User> listUser();
    // 删除用户
    int delUser(int id);
    //更新用户数据
    int upUser(User user);
}
