package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.*;

@Repository
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User getUserByName(String name) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("from User user where user.name=:name")
                .setParameter("name", name)
                .uniqueResult();
    }

    @Override
    public void createUser(User user) {
        sessionFactory.getCurrentSession()
                .save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> readUsers() {
        return sessionFactory.getCurrentSession()
                .createQuery("from User")
                .getResultList();
    }

    @Override
    public void updateUser(User updatedUser) {
        User userToBeUpdate = getUserByName(updatedUser.getName());

        userToBeUpdate.setName(updatedUser.getName());
        userToBeUpdate.setPassword(updatedUser.getPassword());
        userToBeUpdate.setRoles(updatedUser.getRoles());

        sessionFactory.getCurrentSession().update(userToBeUpdate);
    }

    @Override
    public void deleteUser(String name) {
        sessionFactory.getCurrentSession().createQuery("delete User user where user.name=:name")
                .setParameter("name", name)
                .executeUpdate();
//        sessionFactory.getCurrentSession().delete(String.valueOf(id), User.class);
    }
}

