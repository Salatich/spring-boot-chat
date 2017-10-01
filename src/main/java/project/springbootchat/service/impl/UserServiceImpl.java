package project.springbootchat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.springbootchat.dao.UserDao;
import project.springbootchat.model.User;
import project.springbootchat.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public void createUser(User user){
        userDao.createUser(user);
    }

    public User getUserByLogin(String login){
        return userDao.getUserByLogin(login);

    }

    public void saveUser(User user){
        userDao.saveUser(user);
    }


}
