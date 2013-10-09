package me.blog.youreme.payback.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * User: youreme
 * Date: 13. 9. 27.
 * Time: 오전 1:58
 */
@Data
@Entity
@Table(name = "DebtDependency")
public class DebtDependency {
    @Id
    private String creditor;
    private String debtor;
    private int amount;
}
