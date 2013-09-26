package me.blog.youreme.payback.dao;

import me.blog.youreme.payback.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: youreme
 * Date: 13. 9. 27.
 * Time: 오전 2:14
 * To change this template use File | Settings | File Templates.
 */
public class UserDAOTest extends BaseDAOTest {
    @Autowired
    UserDAO userDAO;

    @Test
    public void testInsertUser() {

    }

    @Test
    public void testSelectUser() {
        String userId = "hunky";
        User user = userDAO.selectUser(userId);
        System.out.println(user.getPassword());

    }



}
