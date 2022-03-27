package web.app.dao;


import web.app.model.Role;

import java.util.List;

public interface RoleDao {

    void createRole(Role role);

    List<Role> readAllRole();
}
