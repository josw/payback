package me.blog.youreme.payback.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

/**
 * User: youreme
 * Date: 13. 10. 1.
 * Time: 오후 9:13
 *
 * reference : WEB-INF/web.xml
 * http://docs.spring.io/spring/docs/3.1.x/javadoc-api/org/springframework/web/WebApplicationInitializer.html
 *
 */
public class PaybackWebApplicationInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext container) throws ServletException {
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(PaybackConfiguration.class);

        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));
        container.addListener(new RequestContextListener());

        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
        mvcContext.register(WebMvcConfiguration.class);

        /*
        <!-- Processes application requests -->
        <servlet>
            <servlet-name>payback</servlet-name>
            <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
            <init-param>
                <param-name>contextConfigLocation</param-name>
                <param-value>classpath:servlet-context.xml</param-value>
            </init-param>
            <init-param>
                <param-name>detectAllHandlerAdapters</param-name>
                <param-value>false</param-value>
            </init-param>
            <load-on-startup>1</load-on-startup>
        </servlet>

        <servlet-mapping>
		    <servlet-name>payback</servlet-name>
		    <url-pattern>/</url-pattern>
	    </servlet-mapping>
         */

        // Register and map the dispatcher servlet
        container.getServletRegistration("default").addMapping("*.js", "*.css");

        ServletRegistration.Dynamic dispatcher = container.addServlet("payback", new DispatcherServlet(mvcContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
        //dispatcher.setMultipartConfig(new MultipartConfigElement(null, 1024 * 1024, -1L, 1024 * 1024));

        /*
        <!-- Encoding Filter -->
        <filter>
            <filter-name>encodingFilter</filter-name>
            <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
            <init-param>
                <param-name>encoding</param-name>
                <param-value>UTF-8</param-value>
            </init-param>
        </filter>
        <filter-mapping>
            <filter-name>encodingFilter</filter-name>
            <url-pattern>/*</url-pattern>
        </filter-mapping>
        */
        FilterRegistration encodingFilter = container.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
        encodingFilter.setInitParameter("encoding", "UTF-8");
        //encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD), true, "/*");
    }
}
