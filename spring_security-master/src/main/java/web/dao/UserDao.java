package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    User getUserByName(String name);
    void createUser(User user);
    List<User> readUsers();
    User getUserById(Long id);
    void updateUser(Long id, User user);
    void deleteUser(Long id);
}
