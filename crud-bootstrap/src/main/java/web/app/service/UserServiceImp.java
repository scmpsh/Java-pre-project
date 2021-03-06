package web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.app.dao.UserDao;
import web.app.model.Role;
import web.app.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public List<User> readUsers() {
        return userDao.readUsers();
    }

    @Override
    public void updateUser(Long id, User user) {
        userDao.updateUser(id, user);
    }

    @Override
    public void deleteUser(String name) {
        userDao.deleteUser(name);
    }

    @Override
    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }

    @Override
    public List<Role> readAllRoles() {
        return userDao.readAllRoles();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.getUserByEmail(username);
    }

    @Override
    public void addDiscordIdToUserByEmail(String email, String id) {
        userDao.addDiscordIdToUserByEmail(email, id);
    }

    @Override
    public void sendRequestToAdmins(Long userId) {
        userDao.sendRequestToAdmins(userId);
    }

    @Override
    public List<User> getUsersWithRequest() {
        return userDao.getUsersWithRequest();
    }

    @Override
    public void approveAdminRole(Long id) {
        userDao.approveAdminRole(id);
    }
}
