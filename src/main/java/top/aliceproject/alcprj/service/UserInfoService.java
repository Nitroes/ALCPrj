package top.aliceproject.alcprj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import top.aliceproject.alcprj.entity.UserInfo;
import top.aliceproject.alcprj.mapper.UserInfoMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public Map<String,Object> updataImgUrl(MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        Map<String,Object> res=new HashMap<>();
        String userId = request.getSession().getAttribute("userId").toString();
        /*-------------------保存图片-------------------*/
        String path="file/"+userId+"/";
        //调试路径
//        String sourcePath= ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/";
        //服务器路径
        String sourcePath= "/www/wwwroot/SpringBoot/ALCPrj/";
        String suffix=multipartFile.getOriginalFilename();
        suffix=suffix.substring(suffix.lastIndexOf("."));
        String fileName=userId+suffix;
        File file=new File(sourcePath+path,fileName);
        if(!file.exists()) file.mkdirs();
        multipartFile.transferTo(file);
        /*--------------------------------------------*/
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setImgUrl("../"+path+fileName);
        if (userInfoMapper.getUserInfo(userId).size()>0) {
            userInfoMapper.updateUserInfo(userInfo);
        }else {
            userInfoMapper.newUserInfo(userInfo);
        }
        res.put("msg",userInfo.getImgUrl());
        res.put("id",userId);
        return res;//{msg:"path",id:"userid"}
    }

    public Map<String,Object> getImgUrl(HttpServletRequest request){
        Map<String,Object> res=new HashMap<>();
        String userId = request.getSession().getAttribute("userId").toString();
        res.put("id",userId);
        List<UserInfo> list= userInfoMapper.getUserInfo(userId);
        if (list.size()>0){
            res.put("url",list.get(0).getImgUrl());
        }else {
            res.put("url","../images/icon.jpg");
        }
        return res;
    }
}
