package me.blog.youreme.payback.exception;

import me.blog.youreme.payback.model.ErrorCode;

public class RequestException extends AbstractRuntimeException {

	private static final long serialVersionUID = -8408869435558798369L;

	@Override
	public ErrorCode getExceptionCode() {
		return ErrorCode.REQ_WRONG;
	}

}
