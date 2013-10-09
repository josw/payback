package me.blog.youreme.payback.dao;

import me.blog.youreme.payback.model.User;
import me.blog.youreme.payback.repository.UserRepository;
import me.blog.youreme.payback.spring.PaybackConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * User: youreme
 * Date: 13. 10. 6.
 * Time: 오후 10:48
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PaybackConfiguration.class})
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void test() {
        User user = userRepository.findOne("hunky");
        System.out.println(user.toString());
    }


}
