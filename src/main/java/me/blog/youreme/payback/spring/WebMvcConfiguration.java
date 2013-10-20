package me.blog.youreme.payback.spring;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.blog.youreme.payback.interceptor.LoginInterceptor;
import me.blog.youreme.payback.spring.resolver.PaybackExceptionResolver;
import me.blog.youreme.payback.spring.resolver.PaybackJsonHttpMessageConverter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.AbstractHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * User: youreme
 * Date: 13. 10. 6.
 * Time: 오후 3:44
 */
@Configuration
@ComponentScan(basePackages = { "me.blog.youreme" }, useDefaultFilters = false, includeFilters = @ComponentScan.Filter(Controller.class))
@Import({ThymeleafConfig.class})
@PropertySource(value = {"classpath:properties/common.properties", "classpath:properties/jdbc.properties"})
public class WebMvcConfiguration extends WebMvcConfigurationSupport {
    @Inject
    Environment environment;

    @Inject
    ApplicationContext applicationContext;

    @Inject
    LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludeURI = new ArrayList<String>();
        excludeURI.add("/");
        excludeURI.add("/login");

        loginInterceptor.setExcludeURI(excludeURI);

        registry.addInterceptor(loginInterceptor);
    }

    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping requestMappingHandlerMapping = super.requestMappingHandlerMapping();
        requestMappingHandlerMapping.setUseSuffixPatternMatch(false);
        requestMappingHandlerMapping.setUseTrailingSlashMatch(false);
        return requestMappingHandlerMapping;
    }

    @Override
    protected void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add(new PaybackExceptionResolver());
        super.configureHandlerExceptionResolvers(exceptionResolvers);
    }

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new PaybackJsonHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());
        //converters.add(new SourceHttpMessageConverter<Source>());
        converters.add(new AllEncompassingFormHttpMessageConverter());
        converters.add(new FormHttpMessageConverter());
        
        super.configureMessageConverters(converters);
    }
    
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/image/**").addResourceLocations("/image/");
        super.addResourceHandlers(registry);
    }
    
    @Override
    public HandlerMapping resourceHandlerMapping() {
        AbstractHandlerMapping handlerMapping = (AbstractHandlerMapping) super.resourceHandlerMapping();
        handlerMapping.setOrder(-1);
        return handlerMapping;
    }

    /*
    reference : servlet-context.xml
    <bean class="org.springframework.web.servlet.view.BeanNameViewResolver" p:order="1"/>
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" p:prefix="/WEB-INF/jsp/" p:suffix=".jsp" p:order="2"/>
     */

    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
    }

    @Bean
    public MessageSource messageSource() {
        /*
        reference : servlet-context.xml
        <bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource" p:basename="messages"/>
         */

        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(1);
        messageSource.setBasename("messages/messages");

        return messageSource;
    }
    
}
