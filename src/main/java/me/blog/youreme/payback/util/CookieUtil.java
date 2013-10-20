package me.blog.youreme.payback.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: youreme
 * Date: 13. 10. 17.
 * Time: 오후 6:10
 */
public class CookieUtil {
    private static Logger log = LoggerFactory.getLogger(CookieUtil.class);

    public final static String COOKIE_NAME = "payback_user_context";
    public static final String COOKIE_DEFAULT_PATH = "/";
    public static final int COOKIE_DEFAULT_MAX_AGE = -1;
    public static final int COOKIE_DEFAULT_MIN_AGE = 0;

    public static Cookie createCookie(String name, String value, int maxAge, String domain, String path) {
        Cookie cookie = new Cookie(name, value);

        if (domain != null) {
            cookie.setDomain(domain);
        }

        cookie.setMaxAge(maxAge);
        cookie.setPath(path);
        return cookie;
    }

    public static Cookie createCookie(String name, String value) {
        return createCookie(name, value, COOKIE_DEFAULT_MAX_AGE, null, COOKIE_DEFAULT_PATH);
    }

    public static Cookie setCookie(HttpServletResponse response, String name, String value, int maxAge, String domain,
                                   String path) {
        Cookie cookie = createCookie(name, value, maxAge, domain, path);
        response.addCookie(cookie);

        if (log.isDebugEnabled()) {
            log.debug("CookieUtils.setCookie " + name + ":" + value + " maxAge=" + maxAge + ",domain=" + domain + ",path=" + path);
        }
        return cookie;
    }

    public static Cookie getCookie(HttpServletRequest request, String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }

        Cookie cookies[] = request.getCookies();

        if (cookies == null) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                return cookie;
            }
        }

        return null;
    }

    public static String getCookieValue(HttpServletRequest request, String name) {
        Cookie cookie = getCookie(request, name);

        if (cookie != null) {
            return cookie.getValue();
        }

        return null;
    }

    public static void invalidateCookie(HttpServletResponse response, String cookieName, String domain, String path) {
        setCookie(response, cookieName, null, COOKIE_DEFAULT_MIN_AGE, domain, path);
    }

    public static void invalidateOptionCookie(HttpServletResponse response) {
        invalidateCookie(response, COOKIE_NAME, null, COOKIE_DEFAULT_PATH);
    }

    public static void invalidateCookie(HttpServletResponse response, String cookieName) {
        invalidateCookie(response, cookieName, null, COOKIE_DEFAULT_PATH);
    }
}
