package top.aliceproject.alcprj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.aliceproject.alcprj.entity.AppFile;
import top.aliceproject.alcprj.entity.AppUrl;
import top.aliceproject.alcprj.mapper.AppMapper;
import top.aliceproject.alcprj.utils.ALCFileUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppManageService {
    @Autowired
    private AppMapper appMapper;


    public List<AppUrl> getAppUrl(HttpServletRequest request){
        List<AppUrl> list=new ArrayList<>();
        String userId = request.getSession().getAttribute("userId").toString();
        list=appMapper.getAppUrl(userId);
        return list;
    }

    public List<AppFile> getAppFile(HttpServletRequest request){
        List<AppFile> list=new ArrayList<>();
        String userId = request.getSession().getAttribute("userId").toString();
        list=appMapper.getAppFile(userId);
        return list;
    }

    public Map<String,Object> getApp(HttpServletRequest request){
        Map<String,Object> res=new HashMap<>();
        res.put("appUrl",getAppUrl(request));
        res.put("appFile",getAppFile(request));
        return res;
    }

    public Map<String,Object> addAppUrl(HttpServletRequest request,AppUrl appUrl){
        Map<String,Object> res=new HashMap<>();
        String userId = request.getSession().getAttribute("userId").toString();
        appUrl.setUrlId("default");
        if(appMapper.findAppUrl(appUrl,userId)!=null){
            res.put("status","fail");
            return  res;
        }
        int status= appMapper.addAppUrl(appUrl,userId);
        res.put("status",status);
        res.put("context",appMapper.findAppUrl(appUrl,userId));
        return  res;
    }

    public Map<String,Object> addAppFile(MultipartFile upLoadFile, HttpServletRequest request, AppFile appFile) throws IOException {
        Map<String,Object> res=new HashMap<>();
        String userId = request.getSession().getAttribute("userId").toString();
        appFile.setFileId("default");
        appFile.setFileImg("../images/icon.jpg");
        appFile.setShow(false);
        ALCFileUtils alcFileUtils=new ALCFileUtils();
        String urlPath=alcFileUtils.saveFile(upLoadFile,userId,appFile.getFileName());
        appFile.setFilePath(urlPath);
        appMapper.addAppFile(appFile,userId);
        res.put("context",appFile);
        res.put("status",1);
        res.put("Id",userId);
        return  res;
    }
}
