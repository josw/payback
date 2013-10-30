package me.blog.youreme.payback.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * User: youreme
 * Date: 13. 9. 27.
 * Time: 오전 1:39
 */

@Data
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties(value = { "password" })
@Entity
@Table(name = "user")
public class User extends DTO{
	private static final long serialVersionUID = 1379968932268564915L;

	@Id @GeneratedValue
	private long userId;
    private String email;
    private String password;
    private String name;
    private String phoneNo;
}
