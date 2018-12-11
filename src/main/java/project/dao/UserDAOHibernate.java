package project.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.module.User;

import java.util.List;


@Repository
public interface UserDAOHibernate extends JpaRepository<User, Long> {

    @Query("select user from User user where user.login = :login")
    User getUserWithLogin(@Param("login") String login);

    @Query("select user from User user")
    List<User> findAll();

}