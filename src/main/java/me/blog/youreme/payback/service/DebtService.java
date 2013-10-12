package me.blog.youreme.payback.service;

import java.util.List;

import me.blog.youreme.payback.model.DebtDependency;
import me.blog.youreme.payback.model.DebtHistory;
import me.blog.youreme.payback.repository.DebtDependencyRepository;
import me.blog.youreme.payback.repository.DebtHistoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: youreme
 * Date: 13. 9. 27.
 * Time: 오전 9:48
 */
@Service
public class DebtService {
    @Autowired
    DebtHistoryRepository debtHistoryRepository;

    @Autowired
    DebtDependencyRepository debtDependencyRepository;

    /**
     * 1. 빌려준 돈 히스토리 저장.
     * 2. 빌린 돈이 있는지 확인.
     * 3. 빌린 돈이 없으면 바로 저장. 없으면 계산해서 최종 버전 등록.
     *
     * @param debtHistory
     */
    public void insertDebt(DebtHistory debtHistory) {
        debtHistoryRepository.save(debtHistory);
//        debtHistoryRepository.insertDebtHistory(debtHistory);

        DebtDependency debtCondition = new DebtDependency();
        debtCondition.setCreditor(debtHistory.getDebtor());
        debtCondition.setDebtor(debtHistory.getCreditor());
        //DebtDependency debt = debtDependencyRepository.selectDebtDependency(debtCondition.getCreditor(), debtCondition.getDebtor());
        DebtDependency debt = debtDependencyRepository.findDebtDependencyByCreditorAndDebtor(debtCondition.getCreditor(), debtCondition.getDebtor());

        if (debt != null) {
            // 빌린돈이 있다 => 받을돈이 없거나 0원이다.
            int debtMoney = debt.getAmount();
            int receivableMoney = debtHistory.getAmount();

            int balance = receivableMoney - debtMoney;
            if (balance > 0) {
                insertDebtDependency(debt.getDebtor(), debt.getCreditor(), balance);
                insertDebtDependency(debt.getCreditor(), debt.getDebtor(), 0);
            } else {
                insertDebtDependency(debt.getDebtor(), debt.getCreditor(), 0);
                insertDebtDependency(debt.getCreditor(), debt.getDebtor(), balance);
            }
        } else {
            // 빌린 돈이 없다면.
            DebtDependency receivableCondition = new DebtDependency();
            receivableCondition.setCreditor(debtHistory.getCreditor());
            receivableCondition.setDebtor(debtHistory.getDebtor());
            //DebtDependency receivable = debtDependencyRepository.selectDebtDependency(receivableCondition.getCreditor(), receivableCondition.getDebtor());
            DebtDependency receivable = debtDependencyRepository.findDebtDependencyByCreditorAndDebtor(receivableCondition.getCreditor(), receivableCondition.getDebtor());

            if (receivable != null) {
                // 받을 돈이 있을 경우 더해준다.
                insertDebtDependency(debtHistory.getCreditor(), debtHistory.getDebtor(), debtHistory.getAmount() + receivable.getAmount());
            } else {
                insertDebtDependency(debtHistory.getCreditor(), debtHistory.getDebtor(), debtHistory.getAmount());
            }
        }

    }

    protected void insertDebtDependency(String creditor, String debtor, int amount) {
        DebtDependency debtDependency = new DebtDependency();
        debtDependency.setCreditor(creditor);
        debtDependency.setDebtor(debtor);
        debtDependency.setAmount(amount);

        debtDependencyRepository.save(debtDependency);
    }

    public List<DebtDependency> selectDebtList(String debtor) {
        return debtDependencyRepository.selectDebtList(debtor);
    }
    public List<DebtDependency> selectReceivableList(String creditor) {
        return debtDependencyRepository.selectReceivableList(creditor);
    }

    public List<DebtHistory> selectDebtHistoryList(String debtor) {
        return debtHistoryRepository.selectDebtHistoryList(debtor);
    }

    public List<DebtHistory> selectReceivableHistoryList(String creditor) {
        return debtHistoryRepository.selectReceivableHistoryList(creditor);
    }
}
