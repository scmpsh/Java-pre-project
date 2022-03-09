package crud.app.dao;

import crud.app.model.User;

import java.util.List;

public interface UserDao {
    void createUser(User user);
    List<User> readUsers();
    User getUserById(Long id);
    void updateUser(Long id, User user);
    void deleteUser(Long id);
}
