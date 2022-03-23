package web.app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.app.dao.RoleDao;
import web.app.model.Role;

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
