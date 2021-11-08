package top.aliceproject.alcprj.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.aliceproject.alcprj.entity.AppFile;
import top.aliceproject.alcprj.entity.AppUrl;

import java.util.List;

@Mapper
public interface AppMapper {

    @Select("SELECT * FROM AppUrl WHERE userId=#{userId}")
    List<AppUrl> getAppUrl(String userId);

    @Select("SELECT * FROM AppFile WHERE userId=#{userId}")
    List<AppFile> getAppFile(String userId);

    @Select("SELECT * FROM AppUrl WHERE userId=#{userId} and urlName=#{app.urlName} and urlPath=#{app.urlPath}")
    AppUrl findAppUrl(@Param("app")AppUrl appUrl,@Param("userId")String userId);

    @Insert("INSERT INTO AppUrl(urlId,userId,urlName,urlPath,urlImg,`show`) " +
            "value(#{app.urlId},#{userId},#{app.urlName},#{app.urlPath},#{app.urlImg},#{app.show})")
    int addAppUrl(@Param("app")AppUrl appUrl,@Param("userId")String userId);

    @Insert("INSERT INTO AppFile(fileId,userId,fileName,filePath,fileImg,`show`) " +
            "value(#{app.fileId},#{userId},#{app.fileName},#{app.filePath},#{app.fileImg},#{app.show})")
    void addAppFile(@Param("app")AppFile appFile,@Param("userId")String userId);



}
