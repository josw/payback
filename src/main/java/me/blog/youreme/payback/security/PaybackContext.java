package me.blog.youreme.payback.security;

import me.blog.youreme.payback.model.User;
import org.apache.commons.lang.StringUtils;

/**
 * User: youreme
 * Date: 13. 10. 20.
 * Time: 오전 2:46
 */
public class PaybackContext {
    public static final String USER_CONTEXT = "payback_user_context";

    public static void setUser(User user) {
        ContextHolder.setAttribute(USER_CONTEXT, user);
    }

    public static User getUser() {
        User user = (User) ContextHolder.getAttribute(USER_CONTEXT);
        return user;
    }

    public static String getUserId() {
        return getUser().getUserId();
    }
}
