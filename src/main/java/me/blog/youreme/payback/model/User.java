package me.blog.youreme.payback.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * User: youreme
 * Date: 13. 9. 27.
 * Time: 오전 1:39
 */

@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    private String userId;
    private String password;
    private Date regdate;
}
