package me.blog.youreme.payback.spring.resolver;

import me.blog.youreme.payback.exception.AbstractRuntimeException;
import me.blog.youreme.payback.model.ErrorCode;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 예외를 json 형태로 보여주기 위한 exception resolver. 구현 편의를 위해 현재는 모두 다 json 으로 보내도록 했음. 향후 확장이 필요하다면 아래 클래스 구현 참고할 것.
 * org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerExceptionResolver
 *
 * @author kingori
 *
 */
public class PaybackExceptionResolver extends AbstractHandlerExceptionResolver {
    private static final Log logger = LogFactory.getLog(PaybackExceptionResolver.class);
    private HttpMessageConverter<Object> messageConverter = new MappingJacksonHttpMessageConverter();

    private ModelAndView handleResponseBody(ExceptionJsonContainer returnValue, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        HttpOutputMessage outputMessage = new ServletServerHttpResponse(response);
        messageConverter.write(returnValue, MediaType.APPLICATION_JSON, outputMessage);

        return new ModelAndView();
    }
    
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (logger.isDebugEnabled()) {
            logger.debug(request.getServletPath());
            logger.debug(request.getContextPath());
            logger.debug(request.getPathInfo());
            logger.debug(request.getRequestURI());
        }

        ExceptionJsonContainer result = null;
        if (ex instanceof AbstractRuntimeException) {
            result = new ExceptionJsonContainer((AbstractRuntimeException) ex);
        } else if (ex instanceof IllegalArgumentException) {
            if (ex.getMessage() != null) {
                result = new ExceptionJsonContainer(ErrorCode.REQ_WRONG, ex.getMessage());
            } else {
                result = new ExceptionJsonContainer(ErrorCode.REQ_WRONG);
            }
        } else {
            result = new ExceptionJsonContainer(ErrorCode.ERR_EXEC);
        }

        logger.warn("error in process", ex);
        ModelAndView mav = null;

//        if (!"application/json".equalsIgnoreCase(request.getContentType())) {
//        	return new ModelAndView("login_required");
//        }

        try {
            mav = handleResponseBody(result, request, response);
        } catch (Exception e) {
            logger.error("error in making error json", e);
        }

        return mav;
    }
}
