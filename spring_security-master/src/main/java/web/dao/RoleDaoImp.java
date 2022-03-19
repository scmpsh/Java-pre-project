package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import web.model.Role;

@Repository
public class RoleDaoImp implements RoleDao {

    private final SessionFactory sessionFactory;

    public RoleDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createRole(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }
}
