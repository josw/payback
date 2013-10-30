package me.blog.youreme.payback.exception;

import me.blog.youreme.payback.model.ErrorCode;


public class LoginRequiredException extends AbstractRuntimeException{

	private static final long serialVersionUID = 1L;

	@Override
	public ErrorCode getExceptionCode() {
		return ErrorCode.LOGIN_REQUIRED;
	}

}
