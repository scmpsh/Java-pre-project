package com.example.crudbootstrap.service;


import com.example.crudbootstrap.model.Role;
import com.example.crudbootstrap.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    com.example.crudbootstrap.model.User getUserByName(String name);

    com.example.crudbootstrap.model.User getUserById(Long id);

    void createUser(User user);

    List<com.example.crudbootstrap.model.User> readUsers();

    void updateUser(String name, User user);

    void deleteUser(String name);

    List<Role> readAllRoles();
}
