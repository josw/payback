package me.blog.youreme.payback.exception;

import me.blog.youreme.payback.model.ErrorCode;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: youreme
 * Date: 13. 10. 6.
 * Time: 오후 5:30
 * To change this template use File | Settings | File Templates.
 */
public abstract class CommonException extends  RuntimeException {
    Map<String, ?> errorParamMap = null;

    public CommonException() {
        super();
    }

    public CommonException(Map<String, ?> errorParamMap) {
        super();
        this.errorParamMap = errorParamMap;
    }

    public abstract ErrorCode getExceptionCode();

    public Map<String, ?> getErrorParamMap() {
        return this.errorParamMap;
    }
}
