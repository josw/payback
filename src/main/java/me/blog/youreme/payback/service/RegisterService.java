package me.blog.youreme.payback.service;

import me.blog.youreme.payback.model.PlatformCd;
import me.blog.youreme.payback.model.User;

public interface RegisterService {

	User register(String email, String password, String name,
			String strCountryIso, String strPhoneNumber, PlatformCd platformCd);

	Boolean isEmailAvailable(String email);

}
