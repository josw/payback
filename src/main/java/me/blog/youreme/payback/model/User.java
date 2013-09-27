package me.blog.youreme.payback.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: youreme
 * Date: 13. 9. 27.
 * Time: 오전 1:39
 * To change this template use File | Settings | File Templates.
 */
public class User extends BaseObject {
    private String userId;
    private String password;
    private Date regdate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }


}
