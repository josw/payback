package me.blog.youreme.payback.repository;

import java.util.List;

import me.blog.youreme.payback.model.DebtDependency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * User: youreme
 * Date: 13. 10. 6.
 * Time: 오후 10:55
 */
public interface DebtDependencyRepository extends JpaRepository<DebtDependency, String> {
//    @Query("SELECT dependency FROM DebtDependency dependency WHERE creditor = :creditor AND debtor = :debtor")
//    public DebtDependency selectDebtDependency(String creditor, String debtor);
//
//    @Query("SELECT count(crditor) FROM DebtDependency WHERE creditor = :creditor AND debtor = :debtor")
//    public int selectDebtDependencyCount(String creditor, String debtor);

    @Query("SELECT dependency FROM DebtDependency dependency WHERE debtor = :debtor")
    public List<DebtDependency> selectDebtList(@Param("debtor") String debtor);

    @Query("SELECT dependency FROM DebtDependency dependency WHERE creditor = :creditor")
    public List<DebtDependency> selectReceivableList(@Param("creditor")String creditor);

    DebtDependency findDebtDependencyByCreditorAndDebtor(@Param("creditor") String creditor, @Param("debtor") String debtor);
}
