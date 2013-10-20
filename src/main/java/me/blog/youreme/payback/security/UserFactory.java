package me.blog.youreme.payback.security;

import me.blog.youreme.payback.model.User;
import me.blog.youreme.payback.service.LoginService;
import me.blog.youreme.payback.util.CookieUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: youreme
 * Date: 13. 10. 17.
 * Time: 오후 5:52
 */
@Service
public class UserFactory {
    private static Logger log = LoggerFactory.getLogger(UserFactory.class);

    public final static String COOKIE_NAME = "payback_user_context";
    protected final static String COOKIE_DELIMETER = ";";

    private static BASE64Decoder decoder = new BASE64Decoder();
    private static BASE64Encoder encoder = new BASE64Encoder();

    @Autowired
    LoginService loginService;

    public User createUser(HttpServletRequest request, HttpServletResponse response) {
        if (validateCookie(request)) {
            try {
                User user = getUserFromCookie(request);
                log.debug("createUser : " +user.toString());
                return user;
            } catch (Exception e) {
                log.error("cookie parsing fail", e);
            }
        }

        User user = loginService.getUser(request.getParameter("userId"));
        setCookieFromUser(request, response, user);

        return user;
    }

    protected boolean validateCookie(HttpServletRequest request) {
        String encodedCookie = CookieUtil.getCookieValue(request, COOKIE_NAME);

        String decodedCookie = "";
        try {
            decodedCookie = new String(decoder.decodeBuffer(encodedCookie));
        } catch (IOException e) {
            return false;
        }

        String userId = request.getParameter("userId");

        String[] userInfo = StringUtils.splitPreserveAllTokens(decodedCookie, COOKIE_DELIMETER);
        if (!StringUtils.equals(userId, userInfo[0])) {
            return false;
        }

        return true;
    }

    public User getUserFromCookie(HttpServletRequest request) throws Exception {
        String encodedCookie = CookieUtil.getCookieValue(request, COOKIE_NAME);
        if (encodedCookie != null) {
            encodedCookie = encodedCookie.replaceAll(" ", "+");
        }

        String decodedCookie = new String(decoder.decodeBuffer(encodedCookie));
        String[] userInfo = StringUtils.splitPreserveAllTokens(decodedCookie, COOKIE_DELIMETER);

        User user = new User();
        user.setUserId(userInfo[0]);
        user.setPassword(userInfo[1]);

        return user;
    }

    protected void setCookieFromUser(HttpServletRequest request, HttpServletResponse response, User user) {
        StringBuilder cookie = new StringBuilder();
        cookie.append(user.getUserId()).append(COOKIE_DELIMETER).append(user.getPassword());


        String encodedCookie = encoder.encode(cookie.toString().getBytes());
        response.addCookie(CookieUtil.createCookie(COOKIE_NAME, encodedCookie));
    }
}
