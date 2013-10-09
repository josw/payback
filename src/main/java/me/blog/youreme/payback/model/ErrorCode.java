package me.blog.youreme.payback.model;

/**
 * Created with IntelliJ IDEA.
 * User: youreme
 * Date: 13. 10. 6.
 * Time: 오후 4:03
 * To change this template use File | Settings | File Templates.
 */
public enum ErrorCode {
    OK("000"),
    LOGIN_REQUIRED("100"),
    REQ_WRONG("200"),
    ERR_EXEC("300"),
    ;

    public String code;
    ErrorCode(String code) {
        this.code = code;
    }
}
