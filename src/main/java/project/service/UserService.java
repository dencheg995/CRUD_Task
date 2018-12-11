package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.UserDAOHibernate;
import project.module.User;

import java.util.List;


@Service
@Component
@Transactional
public class UserService {


    @Autowired
    private UserDAOHibernate dao;

    public UserService() {
    }



    public User addUser(User usersEntity) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        usersEntity.setPassword(bCryptPasswordEncoder.encode(usersEntity.getPassword()));
        return dao.save(usersEntity);
    }


    public User getUser(long id) {
        return dao.getOne(id);
    }


    public void removeUser(long id) {
        dao.deleteById(id);
    }


    public List<User> listUser() {
        return dao.findAll();
    }


    public void changeUser(User usersEntity) {
        User newUser = getUser(usersEntity.getId());
        newUser.setId(usersEntity.getId());
        newUser.setName(usersEntity.getName());
        newUser.setAge(usersEntity.getAge());
        newUser.setLogin(usersEntity.getLogin());
        newUser.setPassword(usersEntity.getPassword());
        dao.save(usersEntity);
    }


    public void registrUser(User usersEntity) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        usersEntity.setPassword(bCryptPasswordEncoder.encode(usersEntity.getPassword()));
        usersEntity.setEnabled(true);
        dao.save(usersEntity);
    }


    public User getUserLogin(String login) {
        return dao.getUserWithLogin(login);
    }
}
