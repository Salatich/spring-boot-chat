package project.springbootchat.dao;

import project.springbootchat.model.User;

public interface UserDao {

    public void createUser(User user);

    public User getUserByLogin(String login);

    public void saveUser(User user);
}
