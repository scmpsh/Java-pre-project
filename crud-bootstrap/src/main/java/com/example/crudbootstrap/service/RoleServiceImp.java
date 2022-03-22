package com.example.crudbootstrap.service;

import com.example.crudbootstrap.dao.RoleDao;
import com.example.crudbootstrap.model.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImp implements RoleService {

    private final RoleDao roleDao;

    public RoleServiceImp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void createRole(Role role) {
        roleDao.createRole(role);
    }

    @Override
    public List<Role> readAllRole() {
        return roleDao.readAllRole();
    }
}
