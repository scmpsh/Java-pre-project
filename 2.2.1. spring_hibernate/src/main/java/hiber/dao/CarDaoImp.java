package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

    private final SessionFactory sessionFactory;

    public CarDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> listCars() {
        return sessionFactory.getCurrentSession().createQuery("from Car")
                .getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> listCarsWithLimit(Integer count) {
        return sessionFactory.getCurrentSession().createQuery("from Car")
                .setMaxResults(count)
                .getResultList();
    }
}
