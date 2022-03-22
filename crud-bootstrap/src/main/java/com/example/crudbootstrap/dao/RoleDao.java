package com.example.crudbootstrap.dao;

import com.example.crudbootstrap.model.Role;

import java.util.List;

public interface RoleDao {
    void createRole(Role role);

    List<Role> readAllRole();
}
