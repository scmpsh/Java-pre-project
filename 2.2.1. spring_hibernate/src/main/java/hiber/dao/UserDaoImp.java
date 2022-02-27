package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

@Repository
public class UserDaoImp implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getUserByModelAndSeriesCar(String model, int series) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("from User where car.model=:model and car.series=:series")
                .setParameter("model", model)
                .setParameter("series", series)
                .uniqueResult();
    }

    @Override
    public Car getCarById(Long id) {
        return (Car) sessionFactory.getCurrentSession().get(String.valueOf(id), Car.class);
    }
}
