package web.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.app.model.Role;

import java.util.List;

@Repository
public class RoleDaoImp implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createRole(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Role> readAllRole() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Role")
                .getResultList();
    }
}
