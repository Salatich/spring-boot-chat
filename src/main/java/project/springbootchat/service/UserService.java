package project.springbootchat.service;

import project.springbootchat.model.User;

public interface UserService {

    public void createUser(User user);

    public User getUserByLogin(String login);

    public void saveUser(User user);
}
