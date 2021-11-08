package top.aliceproject.alcprj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.aliceproject.alcprj.entity.User;
import top.aliceproject.alcprj.mapper.LoginMapper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;

    public Map<String,Object> login(User user, HttpServletRequest request){
        Map<String,Object> res=new HashMap<>();
        String status="fail";
        List<User> list =loginMapper.getUser(user);
        if (list.size()>0) {
            status="success";
            request.getSession().setAttribute("userId",list.get(0).getUserId());
        }
        res.put("status",status);
        return res;
    }

}
