package project.springbootchat.dao.impl;

import org.springframework.stereotype.Repository;
import project.springbootchat.dao.UserDao;
import project.springbootchat.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void createUser(User user){
        entityManager.persist(user);
    }

    public User getUserByLogin(String login){
        return entityManager.find(User.class,login);
    }

    @Transactional
    public void saveUser(User user){
        entityManager.merge(user);
    }



}
