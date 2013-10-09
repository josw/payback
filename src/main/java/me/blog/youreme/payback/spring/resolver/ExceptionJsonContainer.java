package me.blog.youreme.payback.spring.resolver;

import lombok.ToString;
import me.blog.youreme.payback.exception.CommonException;
import me.blog.youreme.payback.model.ErrorCode;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * User: youreme
 * Date: 13. 10. 6.
 * Time: 오후 5:27
 */
@JsonSerialize
@ToString
public class ExceptionJsonContainer extends PaybackResultJsonContainer implements Serializable {
    private Map<String, ?> errParamMap = null;

    public ExceptionJsonContainer(CommonException ex) {
        super(ex.getExceptionCode());
        this.errParamMap = ex.getErrorParamMap();
    }

    public ExceptionJsonContainer(ErrorCode errorCode, String msg) {
        super(errorCode);
        Map<String, String> errorMessage = new HashMap<String, String>();
        errorMessage.put("msg", msg);
        this.errParamMap = errorMessage;
    }

    public ExceptionJsonContainer(ErrorCode errorCode) {
        super(errorCode);
    }

    public Map<String, ?> getErrorParams() {
        return errParamMap;
    }

    // exception은 value 라는 필드가 필요없기 때문에 json ignore.
    @Override
    @JsonIgnore
    public Object getValue() {
        return null;
    }
}
