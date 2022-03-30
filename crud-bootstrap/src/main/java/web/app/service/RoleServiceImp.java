package web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.app.dao.RoleDao;
import web.app.model.Role;

import javax.persistence.Access;
import java.util.List;

@Service
@Transactional
public class RoleServiceImp implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public void createRole(Role role) {
        roleDao.createRole(role);
    }

    @Override
    public List<Role> readAllRole() {
        return roleDao.readAllRole();
    }
}
