package me.blog.youreme.payback.repository;

import me.blog.youreme.payback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * User: youreme
 * Date: 13. 10. 6.
 * Time: 오후 6:06
 */
public interface UserRepository extends JpaRepository<User, String> {
}
