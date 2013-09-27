package me.blog.youreme.payback.bo;

import me.blog.youreme.payback.dao.DebtDependencyDAO;
import me.blog.youreme.payback.dao.DebtHistoryDAO;
import me.blog.youreme.payback.model.DebtHistory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * User: youreme
 * Date: 13. 9. 27.
 * Time: 오후 5:51
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class DebtBOTest {
    @Autowired
    DebtBO debtBO;

//    @Mock
//    DebtHistoryDAO debtHistoryDAO;
//
//    @Mock
//    DebtDependencyDAO debtDependencyDAO;

    @Test
    public void testInsertDebt() {
        DebtHistory debtHistory = new DebtHistory();
        debtHistory.setCreditor("jayjay");
        debtHistory.setDebtor("hunky");
        debtHistory.setAmount(3000);
        debtHistory.setReason("test1");
        debtBO.insertDebt(debtHistory);
    }
}
