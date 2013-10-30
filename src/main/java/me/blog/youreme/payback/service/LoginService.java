package me.blog.youreme.payback.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;

import me.blog.youreme.payback.model.Login;
import me.blog.youreme.payback.model.User;
import me.blog.youreme.payback.repository.UserRepository;
import me.blog.youreme.payback.util.BCrypt;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * User: youreme
 * Date: 13. 9. 28.
 * Time: 오후 11:29
 */
@Service
public class LoginService {
    @Autowired
    UserRepository userRepository;
    
	@Value("${login.salt}")
	private String AUTH_SALT;
	
	@Value("${login.cookie.name}")
	private String LOGIN_COOKIE_NAME;

    
	private BCrypt bCrypt;
	
	DateFormat df = new SimpleDateFormat("yyyyMMDDHHmmss");

	@PostConstruct
	public void init() {
		bCrypt = new BCrypt(AUTH_SALT);
	}


    public User getUser(String email) {
           return userRepository.findByEmail(email);
    }
    
    public Cookie createLoginCookie(User user) throws DataLengthException, IllegalStateException, InvalidCipherTextException, UnsupportedEncodingException {
    	
    	StringBuilder token = new StringBuilder();
    	token.append(user.getUserId()).append("|");
    	token.append(user.getEmail()).append("|");
    	token.append(df.format(new Date()));
    	
		return new Cookie(LOGIN_COOKIE_NAME, URLEncoder.encode(bCrypt.encrypt(token.toString()), "UTF-8"));
    }
    
    public Login getLogin(String cookie)  {

    	String decrypted = null;
		try {
			decrypted = bCrypt.decrypt(URLDecoder.decode(cookie, "UTF-8"));
		} catch (Exception e) {
			return new Login();
		} 
    	
    	String[] cookiePat = decrypted.split("\\|");
    	
    	if (cookiePat.length < 3 || cookiePat[0].length() == 0 || cookiePat[1].length() == 0) {
    		return new Login();
    	}
    	
    	User user = userRepository.findOne(Long.parseLong(cookiePat[0]));
    	
    	if (!cookiePat[1].equalsIgnoreCase(user.getEmail())) {
    		return new Login();
    	}
    	
    	Login login = new Login(cookie);
    	login.setLogged(true);
    	login.setUser(user);
    	login.setUserId(user.getUserId());
    	
    	return login;
    	
    }
}
