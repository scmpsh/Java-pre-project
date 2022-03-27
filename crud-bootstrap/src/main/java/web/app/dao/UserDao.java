package web.app.dao;

import web.app.model.Role;
import web.app.model.User;

import java.util.List;

public interface UserDao {

    User getUserByEmail(String name);

    User getUserById(Long id);

    void createUser(User user);

    List<User> readUsers();

    void updateUser(String name, User user);

    void deleteUser(String name);

    List<Role> readAllRoles();
}
