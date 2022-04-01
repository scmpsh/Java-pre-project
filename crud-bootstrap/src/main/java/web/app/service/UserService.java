package web.app.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import web.app.model.Role;
import web.app.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    User getUserByEmail(String email);

    User getUserById(Long id);

    void createUser(User user);

    List<User> readUsers();

    void updateUser(Long id, User user);

    void deleteUser(String name);

    void deleteUserById(Long id);

    List<Role> readAllRoles();

    void addDiscordIdToUserByEmail(String email, String id);

    void sendRequestToAdmins(Long userId);

    List<User> getUsersWithRequest();

    void approveAdminRole(Long id);
}
