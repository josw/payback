package me.blog.youreme.payback.dao;

import me.blog.youreme.payback.model.DebtDependency;
import me.blog.youreme.payback.model.DebtHistory;
import org.springframework.stereotype.Component;

import java.util.List;
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

    public List<DebtHistory> selectDebtHistoryList(String debtor) {
        return getSqlSessionTemplate().selectList(NAMESPACE + ".selectDebtHistoryList", debtor);
    }

    public List<DebtHistory> selectReceivableHistoryList(String creditor) {
        return getSqlSessionTemplate().selectList(NAMESPACE + ".selectReceivableHistoryList", creditor);
    }

}
