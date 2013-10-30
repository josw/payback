package me.blog.youreme.payback.controller;

import me.blog.youreme.payback.model.User;
import me.blog.youreme.payback.security.PaybackContext;

/**
 * User: youreme
 * Date: 13. 10. 20.
 * Time: 오전 2:45
 */
public class BaseController {
    public User getUser() {
        return PaybackContext.getUser();
    }

    public String getUserId() {
        return getUser().getEmail();
    }
}
