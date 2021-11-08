package top.aliceproject.alcprj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.aliceproject.alcprj.entity.User;

import java.util.List;

@Mapper
public interface LoginMapper {
    @Select("SELECT * From User WHERE name=#{name} and password=#{password}")
    List<User> getUser(User user);
}
