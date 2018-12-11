package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.module.Role;

import java.util.List;


@Repository
@Transactional
public interface RoleDAO extends JpaRepository<Role, Long> {

    @Query("select role.nameRole from Role role")
    List<String> getRoles(String login);

    @Query("select role from Role role where role.userId = :userId")
    Role getOne(@Param("userId") long id);

}
