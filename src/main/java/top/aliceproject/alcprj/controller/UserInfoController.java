package top.aliceproject.alcprj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import top.aliceproject.alcprj.service.UserInfoService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/UserInfo")
public class UserInfoController {
    @Autowired
    private UserInfoService service;

//    @RequestMapping("/UserInfo")
//    public ModelAndView page(){
//        ModelAndView mv=new ModelAndView();
//        mv.setViewName("user_info");
//        return mv;
//    }
    @PostMapping("/UpdataImg")
    public Map<String, Object> updataImg(MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        return service.updataImgUrl(multipartFile,request);
    }

    @GetMapping("/GetImgUrl")
    public Map<String, Object> getImgUrl(HttpServletRequest request){
        return service.getImgUrl(request);
    }
}
