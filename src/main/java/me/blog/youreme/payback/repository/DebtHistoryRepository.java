package me.blog.youreme.payback.repository;

import me.blog.youreme.payback.model.DebtHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * User: youreme
 * Date: 13. 10. 6.
 * Time: 오후 10:56
 */
public interface DebtHistoryRepository extends JpaRepository<DebtHistory, String> {

    @Query("SELECT creditor, debtor, amount, reason, complete, regdate FROM DebtHistory WHERE debtor = :debtor AND complete = false")
    public List<DebtHistory> selectDebtHistoryList(String debtor);


    @Query("SELECT creditor, debtor, amount, reason, complete, regdate FROM DebtHistory WHERE creditor = :creditor AND complete = 0")
    public List<DebtHistory> selectReceivableHistoryList(String creditor);

}
