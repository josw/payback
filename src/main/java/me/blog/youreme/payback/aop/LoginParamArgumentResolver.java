package me.blog.youreme.payback.aop;

import javax.inject.Provider;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import me.blog.youreme.payback.exception.LoginRequiredException;
import me.blog.youreme.payback.model.Login;
import me.blog.youreme.payback.service.LoginService;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


public class LoginParamArgumentResolver implements HandlerMethodArgumentResolver {

	private static final Logger logger = LoggerFactory.getLogger(LoginParamArgumentResolver.class);

	private static final String LOGIN_COOKIE_NAME = "login";

	@Autowired
	private Provider<HttpServletRequest> requestProvider;

	@Value("${env}")
	String env;

	@Autowired
	private LoginService loginService;

	@Override
	public boolean supportsParameter(MethodParameter parameter) {

		logger.debug("supports: " + parameter.getParameterAnnotation(LoginParam.class) + ":"
				+ parameter.getParameterType());

		if (parameter.getParameterAnnotation(LoginParam.class) != null && Login.class == parameter.getParameterType())
			return true;
		else
			return false;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

		LoginParam loginParam = parameter.getParameterAnnotation(LoginParam.class);
		
		logger.debug("999{}",loginParam);
		
		String loginCookie = webRequest.getHeader(LOGIN_COOKIE_NAME);
				
		if (StringUtils.isBlank(loginCookie)) {
			loginCookie = getCookie((HttpServletRequest) webRequest.getNativeRequest(), LOGIN_COOKIE_NAME);
		}

		logger.debug ("cc1cc " + loginCookie);

		if (StringUtils.isBlank(loginCookie)) {
			if (loginParam.required()) {
				throw new LoginRequiredException();
			}
			return new Login();
		}

		Login login = loginService.getLogin(loginCookie);

		if (!login.isLogged() && loginParam.required())
			throw new LoginRequiredException();

		return login;
	}
	
	private String getCookie(HttpServletRequest request, String name) {
		
		for (Cookie cookie : request.getCookies()) {
			if (name.equals(cookie.getName())) {
				return cookie.getValue();
			}
		}
		return "";		
	}

}
