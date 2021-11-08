package top.aliceproject.alcprj.configuration;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("/page/sign_in.html".equals(request.getRequestURI())||"/Login/SignIn".equals(request.getRequestURI())) {
            return true;
        }
        //重定向
        Object object = request.getSession().getAttribute("userId");
        if (null == object) {
            response.sendRedirect("/page/sign_in.html");
            return false;
        }
        return true;
    }
}
