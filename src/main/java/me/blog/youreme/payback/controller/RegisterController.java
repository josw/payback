package me.blog.youreme.payback.controller;

import me.blog.youreme.payback.exception.CommonException;
import me.blog.youreme.payback.exception.RequestException;
import me.blog.youreme.payback.model.PlatformCd;
import me.blog.youreme.payback.model.QUser;
import me.blog.youreme.payback.model.User;
import me.blog.youreme.payback.repository.UserRepository;
import me.blog.youreme.payback.service.RegisterService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysema.query.types.Predicate;

@Controller
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView register(ModelAndView mav) {
		return mav;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	@ResponseBody
	public String registerAction(ModelAndView mav,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("phone") String phone) {
		
		
		if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password) || StringUtils.isEmpty(name) || StringUtils.isEmpty(phone) ) {
			throw new RequestException();
		}
		
		User user = registerService.register(email, password, name, "KR", phone, PlatformCd.WEB);
		
		if (user == null) {
			throw new CommonException(null);
		}

		return user.getEmail();
	}

	
	@RequestMapping(value="/register/email/check")
	@ResponseBody
	public Boolean isAvailableUsername(
			@RequestParam("email") String email
			) {
		
		if (email.trim().length() < 8) {
			return false;
		}
		
		return registerService.isEmailAvailable(email);
	}
	
}
