package me.blog.youreme.payback.dao;

import me.blog.youreme.payback.model.User;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: youreme
 * Date: 13. 9. 27.
 * Time: 오전 1:35
 * To change this template use File | Settings | File Templates.
 */
@Component
public class UserDAO extends BaseDAO {
    private static final String NAMESPACE = UserDAO.class.getName();

    public User selectUser(String userId) {
        return (User)getSqlSessionTemplate().selectOne(NAMESPACE + ".selectUser", userId);
    }

    public int insertUser(User user) {
        return getSqlSessionTemplate().insert(NAMESPACE + ".insertUser", user);
    }

    public int deleteUser(String userId) {
        return getSqlSessionTemplate().delete(NAMESPACE + ".deleteUser", userId);
    }

}
