package web.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.app.model.Role;
import web.app.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUserByEmail(String email) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("select user from User user where user.email=:email")
                .setParameter("email", email)
                .uniqueResult();
    }

    @Override
    public User getUserById(Long id) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("select user from User user where user.id=:id")
                .setParameter("id", id)
                .uniqueResult();
//        return (User) sessionFactory.getCurrentSession().get(String.valueOf(id), User.class);
    }

    @Override
    public void createUser(User user) {
        Set<Role> roleSet = new HashSet<>();

        for (Role role : user.getRoles()) {
            roleSet.add((Role) sessionFactory.getCurrentSession()
                    .createQuery("select role from Role role where role.name=:name")
                    .setParameter("name", role.getName())
                    .uniqueResult());
        }
        user.setRoles(roleSet);
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> readUsers() {
        return sessionFactory.getCurrentSession()
                .createQuery("from User")
                .getResultList();
    }

    @Override
    public void updateUser(Long id, User updatedUser) {
        User userToBeUpdate = getUserById(id);
        Set<Role> roleSet = new HashSet<>();

        userToBeUpdate.setFirstName(updatedUser.getFirstName());
        userToBeUpdate.setLastName(updatedUser.getLastName());
        userToBeUpdate.setAge(updatedUser.getAge());
        userToBeUpdate.setEmail(updatedUser.getEmail());
        userToBeUpdate.setPassword(updatedUser.getPassword());

        if (!updatedUser.getRoles().isEmpty()) {
            for (Role role : updatedUser.getRoles()) {
                roleSet.add((Role) sessionFactory.getCurrentSession()
                        .createQuery("select role from Role role where role.name=:name")
                        .setParameter("name", role.getName())
                        .uniqueResult());
            }
            userToBeUpdate.setRoles(roleSet);
        }

        sessionFactory.getCurrentSession().update(userToBeUpdate);
    }

    @Override
    public void deleteUser(String name) {
        sessionFactory.getCurrentSession().createQuery("delete User user where user.email=:name")
                .setParameter("name", name)
                .executeUpdate();
//        sessionFactory.getCurrentSession().delete(String.valueOf(id), User.class);
    }

    @Override
    public void deleteUserById(Long id) {
        sessionFactory.getCurrentSession().createQuery("delete User user where user.id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Role> readAllRoles() {
        return sessionFactory.getCurrentSession()
                .createQuery("select distinct role from Role role")
                .getResultList();
    }
}

