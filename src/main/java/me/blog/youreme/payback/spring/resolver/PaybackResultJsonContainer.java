package me.blog.youreme.payback.spring.resolver;

import me.blog.youreme.payback.model.ErrorCode;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * User: youreme
 * Date: 13. 10. 6.
 * Time: 오후 4:00
 *
 * 실행 결과를 결과 코드를 포함한 JSON으로 감싸기 위한 컨테이너
 */
@JsonSerialize
public class PaybackResultJsonContainer {
    private ErrorCode code;
    private Object value;

    public PaybackResultJsonContainer() {
        this(ErrorCode.OK);
    }

    public PaybackResultJsonContainer(Object value) {
        this();
        this.value = value;
    }

    public PaybackResultJsonContainer(ErrorCode code) {
        this.code = code;
    }

    public String getCode() {
        return code.code;
    }

    public String getMessage() {
        return code.name();
    }

    public Object getValue() {
        return value;
    }

}
