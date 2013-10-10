package me.blog.youreme.payback.repository;

import me.blog.youreme.payback.model.DebtHistory;
import me.blog.youreme.payback.model.User;
import me.blog.youreme.payback.spring.PaybackConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * User: youreme
 * Date: 13. 10. 10.
 * Time: 오전 1:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PaybackConfiguration.class})
public class DebtHistoryRepositoryTest {
    @Autowired
    DebtHistoryRepository debtHistoryRepository;

    @Test
    public void test() {
        List<DebtHistory> debtHistoryList = debtHistoryRepository.selectDebtHistoryList("hunky");
        System.out.println((DebtHistory)debtHistoryList.get(0));
    }
}
