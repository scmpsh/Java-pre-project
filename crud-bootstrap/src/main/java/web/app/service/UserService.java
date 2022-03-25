package web.app.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import web.app.model.Role;
import web.app.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    User getUserByName(String name);

    User getUserById(Long id);

    void createUser(User user);

    List<User> readUsers();

    void updateUser(String name, User user);

    void deleteUser(String name);

    List<Role> readAllRoles();
}