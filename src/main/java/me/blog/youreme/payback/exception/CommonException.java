package me.blog.youreme.payback.exception;

import java.util.Map;

import me.blog.youreme.payback.model.ErrorCode;

public class CommonException extends AbstractRuntimeException {

	private static final long serialVersionUID = 4236902621749375429L;

	@Override
	public ErrorCode getExceptionCode() {
		return ErrorCode.ERR_EXEC;
	}
	
	public CommonException(Map<String, String> errorParamMap) {
		super(errorParamMap);
	}
}
