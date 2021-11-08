package top.aliceproject.alcprj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import top.aliceproject.alcprj.entity.User;
import top.aliceproject.alcprj.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/Login")
public class LoginController {
    @Autowired
    private LoginService loginService;

//    @RequestMapping("/Login")
//    public ModelAndView page(){
//        ModelAndView mv=new ModelAndView();
//        mv.setViewName("sign_in");
//        return mv;
//    }

    @PostMapping("/SignIn")
    public Map<String, Object> login(User user, HttpServletRequest request){
        return loginService.login(user,request);
    }

    @GetMapping("/LoginOut")
    public void loginOut(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("userId");
        response.sendRedirect("/page/sign_in.html");
    }

}
