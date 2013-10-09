package me.blog.youreme.payback.service;

import me.blog.youreme.payback.model.User;
import me.blog.youreme.payback.repository.UserRepository;
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
public class LoginService {
    @Autowired
    UserRepository userRepository;

    public User getUser(String userId) {
           return userRepository.findOne(userId);
    }
}
