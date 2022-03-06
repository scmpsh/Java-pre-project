package crud.app.dao;

import crud.app.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
}
