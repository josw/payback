package me.blog.youreme.payback.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 
 * Login 인증  
 * 
 * 단말기의 인증을 담당한다. 
 * 인증은 uuid 화 rtoken 으로 한다. 
 * 
 * 요청하는 모든 controller 에 포함되어야 한다.   
 * required 가 true 일 경우, rtoken 이 반드시 필요하다. 
 * 
 * 인증에 성공할 경우 login 에 member 정보가 포함되어 리턴된다. 
 * 
 * 
 * @author josw
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface LoginParam {
	boolean required() default true;
}
