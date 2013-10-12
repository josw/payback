package me.blog.youreme.payback.model;

/**
 * User: youreme
 * Date: 13. 10. 6.
 * Time: 오후 4:03
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
