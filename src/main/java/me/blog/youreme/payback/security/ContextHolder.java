package me.blog.youreme.payback.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;

/**
 * User: youreme
 * Date: 13. 10. 20.
 * Time: 오후 7:51
 */
public class ContextHolder {
    private static Logger log = LoggerFactory.getLogger(ContextHolder.class);

    public static final ThreadLocal<ServletContext> SERVLET_CONTEXT_HOLDER = new ThreadLocal<ServletContext>() {
        @Override
        public ServletContext get() {
            ServletContext servletContext = super.get();
            if (servletContext == null) {
                log.error("Could not find valid ServletContext!");
            }
            return servletContext;
        }
    };

    public static void setAttribute(String key, Object value) {
        SERVLET_CONTEXT_HOLDER.get().setAttribute(key, value);
    }


    public static Object getAttribute(String key) {
        return SERVLET_CONTEXT_HOLDER.get().getAttribute(key);
    }
}
