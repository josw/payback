package me.blog.youreme.payback.bo;

import me.blog.youreme.payback.dao.UserDAO;
import me.blog.youreme.payback.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: youreme
 * Date: 13. 9. 28.
 * Time: 오후 11:29
 * To change this template use File | Settings | File Templates.
 */
@Service
public class LoginBO {
    @Autowired
    UserDAO userDAO;

    public User getUser(String userId) {
           return userDAO.selectUser(userId);
    }
}
