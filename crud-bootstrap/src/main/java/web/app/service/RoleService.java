package web.app.service;


import web.app.model.Role;

import java.util.List;

public interface RoleService {
    void createRole(Role role);

    List<Role> readAllRole();
}
