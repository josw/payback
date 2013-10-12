package me.blog.youreme.payback.repository;

import me.blog.youreme.payback.spring.PaybackConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * User: youreme
 * Date: 13. 10. 10.
 * Time: 오전 2:24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PaybackConfiguration.class})
public class DebtDependencyRepositoryTest {
}
