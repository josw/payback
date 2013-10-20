package me.blog.youreme.payback.interceptor;

import me.blog.youreme.payback.model.User;
import me.blog.youreme.payback.security.PaybackContext;
import me.blog.youreme.payback.security.UserFactory;
import me.blog.youreme.payback.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;

/**
 * User: youreme
 * Date: 13. 9. 29.
 * Time: 오후 1:06
 */
@Service
public class LoginInterceptor extends WebContentInterceptor {
    private static Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
    protected List<String> excludeURI = Collections.emptyList();

    @Autowired
    LoginService loginService;

    @Autowired
    UserFactory userFactory;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
        String requestURI = request.getRequestURI();

        for (String uri : excludeURI) {
            if (requestURI.startsWith(uri)) {
                return true;
            }
        }

        User user = userFactory.createUser(request, response);
        PaybackContext.setUser(user);

        log.debug(user.toString());

        return true;
    }

    public void setExcludeURI(List<String> excludeURI) {
        this.excludeURI = excludeURI;
    }

    public List<String> getExcludeURI() {
        return excludeURI;
    }
}
