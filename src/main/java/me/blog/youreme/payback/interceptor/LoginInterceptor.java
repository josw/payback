package me.blog.youreme.payback.interceptor;

import org.springframework.web.servlet.mvc.WebContentInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: youreme
 * Date: 13. 9. 29.
 * Time: 오후 1:06
 * To change this template use File | Settings | File Templates.
 */
public class LoginInterceptor extends WebContentInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
        return true;
    }
}
