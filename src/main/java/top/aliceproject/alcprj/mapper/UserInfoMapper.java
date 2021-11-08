package top.aliceproject.alcprj.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.aliceproject.alcprj.entity.UserInfo;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Select("SELECT * From UserInfo WHERE userId=#{userId}")
    List<UserInfo> getUserInfo(String userId);

    @Insert("INSERT INTO UserInfo(userId,imgUrl) value(#{userId},#{imgUrl})")
    void newUserInfo(UserInfo userInfo);

    @Update("UPDATE UserInfo SET imgUrl=#{imgUrl}  WHERE userId=#{userId} ")
    void updateUserInfo(UserInfo userInfo);
}
