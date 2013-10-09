package me.blog.youreme.payback.service;

import me.blog.youreme.payback.model.DebtHistory;
import me.blog.youreme.payback.spring.PaybackConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * User: youreme
 * Date: 13. 9. 27.
 * Time: 오후 5:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PaybackConfiguration.class})
public class DebtServiceTest {
    @Autowired
    DebtService debtService;

//    @Mock
//    DebtHistoryDAO debtHistoryRepository;
//
//    @Mock
//    DebtDependencyDAO debtDependencyRepository;

    @Test
    public void testInsertDebt() {
        DebtHistory debtHistory = new DebtHistory();
        debtHistory.setCreditor("rouka");
        debtHistory.setDebtor("hunky");
        debtHistory.setAmount(2000);
        debtHistory.setReason("점심값");
        debtHistory.setComplete(false);
        debtHistory.setRegdate(new Date());
        debtService.insertDebt(debtHistory);

        debtHistory.setCreditor("hunky");
        debtHistory.setDebtor("ari");
        debtHistory.setAmount(3000);
        debtHistory.setReason("점심값");
        debtHistory.setComplete(false);
        debtHistory.setRegdate(new Date());
        debtService.insertDebt(debtHistory);

        debtHistory.setCreditor("jayjay");
        debtHistory.setDebtor("ari");
        debtHistory.setAmount(4000);
        debtHistory.setReason("점심값");
        debtHistory.setComplete(false);
        debtHistory.setRegdate(new Date());
        debtService.insertDebt(debtHistory);

        debtHistory.setCreditor("hunky");
        debtHistory.setDebtor("jayjay");
        debtHistory.setAmount(5000);
        debtHistory.setReason("점심값");
        debtHistory.setComplete(false);
        debtHistory.setRegdate(new Date());
        debtService.insertDebt(debtHistory);

        debtHistory.setCreditor("kal");
        debtHistory.setDebtor("ari");
        debtHistory.setAmount(6000);
        debtHistory.setReason("점심값");
        debtHistory.setComplete(false);
        debtHistory.setRegdate(new Date());
        debtService.insertDebt(debtHistory);

        debtHistory.setCreditor("hunky");
        debtHistory.setDebtor("kal");
        debtHistory.setAmount(7000);
        debtHistory.setReason("점심값");
        debtHistory.setComplete(false);
        debtHistory.setRegdate(new Date());
        debtService.insertDebt(debtHistory);

        debtHistory.setCreditor("pang");
        debtHistory.setDebtor("ari");
        debtHistory.setAmount(8000);
        debtHistory.setReason("점심값");
        debtHistory.setComplete(false);
        debtHistory.setRegdate(new Date());
        debtService.insertDebt(debtHistory);

        debtHistory.setCreditor("pang");
        debtHistory.setDebtor("hunky");
        debtHistory.setAmount(9000);
        debtHistory.setReason("점심값");
        debtHistory.setComplete(false);
        debtHistory.setRegdate(new Date());
        debtService.insertDebt(debtHistory);

        debtHistory.setCreditor("hunky");
        debtHistory.setDebtor("mathew");
        debtHistory.setAmount(10000);
        debtHistory.setReason("점심값");
        debtHistory.setComplete(false);
        debtHistory.setRegdate(new Date());
        debtService.insertDebt(debtHistory);

        debtHistory.setCreditor("hunky");
        debtHistory.setDebtor("quick");
        debtHistory.setAmount(2000);
        debtHistory.setReason("점심값");
        debtHistory.setComplete(false);
        debtHistory.setRegdate(new Date());
        debtService.insertDebt(debtHistory);

        debtHistory.setCreditor("pooh");
        debtHistory.setDebtor("hunky");
        debtHistory.setAmount(2000);
        debtHistory.setReason("점심값");
        debtHistory.setComplete(false);
        debtHistory.setRegdate(new Date());
        debtService.insertDebt(debtHistory);

        debtHistory.setCreditor("hunky");
        debtHistory.setDebtor("sipo");
        debtHistory.setAmount(2000);
        debtHistory.setReason("점심값");
        debtHistory.setComplete(false);
        debtHistory.setRegdate(new Date());
        debtService.insertDebt(debtHistory);
    }
}
