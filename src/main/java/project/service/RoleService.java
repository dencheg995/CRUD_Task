package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.RoleDAO;
import project.module.Role;
import project.module.User;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleDAO daoRole;

    public RoleService() {
    }


    @Transactional
    public void addRole(User user, Role role) {
        role.setUser(user);
        daoRole.save(role);
    }

    @Transactional
    public List<String> getRoles(String login) {
        return daoRole.getRoles(login);
    }

    @Transactional
    public Role findRole(int id) {
        return daoRole.getOne((long) id);
    }

    @Transactional
    public void removeRole(long id) {
        Role role = daoRole.getOne(id);
        daoRole.delete(role);
    }

    @Transactional
    public void registRole(User user, String  userRole) {
        Role role = new Role();
        role.setNameRole(userRole);
        role.setUser(user);
        role.setUser(user);
        daoRole.save(role);
    }
}
