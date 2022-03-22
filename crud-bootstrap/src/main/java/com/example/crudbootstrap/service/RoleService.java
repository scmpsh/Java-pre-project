package com.example.crudbootstrap.service;

import com.example.crudbootstrap.model.Role;

import java.util.List;

public interface RoleService {
    void createRole(Role role);

    List<Role> readAllRole();
}
