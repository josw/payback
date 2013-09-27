package me.blog.youreme.payback.dao;

import me.blog.youreme.payback.model.DebtDependency;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: youreme
 * Date: 13. 9. 27.
 * Time: 오전 2:04
 * To change this template use File | Settings | File Templates.
 */
@Component
public class DebtDependencyDAO extends BaseDAO {
    private static final String NAMESPACE = DebtDependencyDAO.class.getName();

    public int insertDebtDependency(DebtDependency debtDependency) {
        return getSqlSessionTemplate().insert(NAMESPACE + ".insertDebtDependency", debtDependency);
    }

    public DebtDependency selectDebtDependency(DebtDependency debtDependency) {
        return (DebtDependency)getSqlSessionTemplate().selectOne(NAMESPACE + ".selectDebtDependency", debtDependency);
    }

    public int selectDebtDependencyCount(DebtDependency debtDependency) {
        return (Integer)getSqlSessionTemplate().selectOne(NAMESPACE + ".selectDebtDependencyCount", debtDependency);
    }


    public int updateDebtDependency(DebtDependency debtDependency) {
        return getSqlSessionTemplate().update(NAMESPACE + ".updateDebtDependency", debtDependency);
    }

    public List<DebtDependency> selectDebtList(String debtor) {
        return getSqlSessionTemplate().selectList(NAMESPACE + ".selectDebtList", debtor);
    }

    public List<DebtDependency> selectReceivableList(String creditor) {
        return getSqlSessionTemplate().selectList(NAMESPACE + ".selectReceivableList", creditor);
    }
}
