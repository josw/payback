package me.blog.youreme.payback.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: youreme
 * Date: 13. 9. 27.
 * Time: 오전 1:56
 * To change this template use File | Settings | File Templates.
 */
public class DebtHistory extends BaseObject {
    private String creditor;
    private String debtor;
    private int amount;
    private String reason;
    private boolean completed;

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    private Date regdate;

    public String getCreditor() {
        return creditor;
    }

    public void setCreditor(String creditor) {
        this.creditor = creditor;
    }

    public String getDebtor() {
        return debtor;
    }

    public void setDebtor(String debtor) {
        this.debtor = debtor;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setDate(Date regdate) {
        this.regdate = regdate;
    }
}
