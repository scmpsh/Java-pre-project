package crud.app.dao;

import crud.app.model.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private final SessionFactory sessionFactory;

    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
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
    public User getUserById(Long id) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("from User user where user.id=:id")
                .setParameter("id", id)
                .uniqueResult();
//        return (User) sessionFactory.getCurrentSession().get(String.valueOf(id), User.class);
    }

    @Override
    public void updateUser(Long id, User updatedUser) {
        User userToBeUpdate = getUserById(id);

        userToBeUpdate.setName(updatedUser.getName());
        userToBeUpdate.setSurname(updatedUser.getSurname());
        userToBeUpdate.setEmail(updatedUser.getEmail());

        sessionFactory.getCurrentSession().update(userToBeUpdate);
    }

    @Override
    public void deleteUser(Long id) {
        sessionFactory.getCurrentSession().createQuery("delete User user where user.id=:id")
                .setParameter("id", id)
                .executeUpdate();
//        sessionFactory.getCurrentSession().delete(String.valueOf(id), User.class);
    }
}
