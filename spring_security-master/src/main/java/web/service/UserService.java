package web.service;


import web.model.User;

import java.util.List;

public interface UserService {
    User getUserByName(String name);

    void createUser(User user);

    List<User> readUsers();

    void updateUser(User user);

    void deleteUser(String name);
}
