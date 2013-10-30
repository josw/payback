package me.blog.youreme.payback.service.impl;

import java.security.InvalidParameterException;
import java.util.Map;

import javax.annotation.PostConstruct;

import me.blog.youreme.payback.exception.CommonException;
import me.blog.youreme.payback.model.PlatformCd;
import static me.blog.youreme.payback.model.QUser.user;
import me.blog.youreme.payback.model.User;
import me.blog.youreme.payback.repository.UserRepository;
import me.blog.youreme.payback.service.RegisterService;
import me.blog.youreme.payback.util.BCrypt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	private final static Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);
	
	@Value("${login.salt}")
	private String AUTH_SALT;
	
	@Autowired
	private UserRepository userRepository;

	private BCrypt bCrypt;
	

	@PostConstruct
	public void init() {
		bCrypt = new BCrypt(AUTH_SALT);
	}
	
	@Override
	public User register(String email, String password, String name, String strCountryIso, String strPhoneNumber, PlatformCd platformCd) {
		
		User findUser = userRepository.findByEmail(email);
		
		logger.debug (">>>>>>>{}", findUser);
		
		if (findUser != null) {
			Map<String, String> param = Maps.newHashMap();
			param.put("msg", "아이디 중복");
			throw new CommonException(param);
		}
		
		PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();

		PhoneNumber phoneNumber = null;
		try {
			phoneNumber = phoneUtil.parseAndKeepRawInput(strPhoneNumber, strCountryIso.toUpperCase());
		} catch (NumberParseException e1) {
			e1.printStackTrace();
			throw new InvalidParameterException("invalid phone number or country iso code");
		}

		String e164PhoneNumber = phoneUtil.format(phoneNumber, PhoneNumberFormat.E164);

		User user = new User();
		
		user.setEmail(email);
		user.setPassword(password);
		user.setName(name);
		user.setPhoneNo(e164PhoneNumber);

		return userRepository.save(user);

	}

	@Override
	public Boolean isEmailAvailable(String email) {
		
//		QUser user = QUser.user;
		
//		Predicate predicate = QUser.user.email.eq(email);
				
		long userCnt = userRepository.count(user.email.eq(email));

		return userCnt==0?true:false;
	}
}
