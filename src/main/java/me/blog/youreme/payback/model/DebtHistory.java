package me.blog.youreme.payback.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: youreme
 * Date: 13. 9. 27.
 * Time: 오전 1:56
 * To change this template use File | Settings | File Templates.
 */
@Data
@Entity
@Table(name = "DebtHistory")
public class DebtHistory {
    @Id
    private String creditor;
    private String debtor;
    private int amount;
    private String reason;
    private boolean complete;
    private Date regdate;
}
