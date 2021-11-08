package top.aliceproject.alcprj.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.aliceproject.alcprj.entity.AppFile;
import top.aliceproject.alcprj.entity.AppUrl;
import top.aliceproject.alcprj.service.AppManageService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/AppManage")
public class AppManageController {
    @Autowired
    private AppManageService service;

    @GetMapping("/GetAppUrl")
    public List<AppUrl> getAppUrl(HttpServletRequest request){
        return service.getAppUrl(request);
    }

    @GetMapping("/GetAppFile")
    public List<AppFile> getAppFile(HttpServletRequest request){
        return service.getAppFile(request);
    }
    @GetMapping("/GetApp")
    public Map<String,Object> getApp(HttpServletRequest request){
        return service.getApp(request);
    }

    @PostMapping("/AddAppUrl")
    public Map<String,Object> addAppUrl(HttpServletRequest request,AppUrl appUrl){
        return service.addAppUrl(request,appUrl);
    }

    @PostMapping("/AddAppFile")
    public Map<String,Object> addAppFile(HttpServletRequest request, AppFile appFile){
        return service.addAppFile(request,appFile);
    }
}
