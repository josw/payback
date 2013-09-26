package me.blog.youreme.payback.dao;

import me.blog.youreme.payback.model.DebtHistory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: youreme
 * Date: 13. 9. 27.
 * Time: 오전 2:00
 * To change this template use File | Settings | File Templates.
 */
@Component
public class DebtHistoryDAO extends BaseDAO {

    private static final String NAMESPACE = DebtHistoryDAO.class.getName();

    public int insertDebtHistory(DebtHistory debtHistory) {
        return getSqlSessionTemplate().insert(NAMESPACE + ".insertDebtHistory", debtHistory);
    }
}
