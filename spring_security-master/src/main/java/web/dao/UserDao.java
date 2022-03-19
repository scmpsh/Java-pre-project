package web.dao;

import web.model.Role;
import web.model.User;

import java.util.List;

public interface UserDao {
    User getUserByName(String name);

    void createUser(User user);

    List<User> readUsers();

    void updateUser(User user);

    void deleteUser(String name);

    List<Role> readAllRoles();
}
