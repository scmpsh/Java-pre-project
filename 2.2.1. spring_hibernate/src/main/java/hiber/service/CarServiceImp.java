package hiber.service;

import hiber.config.Prop;
import hiber.dao.CarDao;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImp implements CarService {

    @Value("${car.limit}")
    private Integer limitCars;

    @Autowired
    private Prop prop;

    private final CarDao carDao;

    public CarServiceImp(CarDao carDao) {
        this.carDao = carDao;
    }

    @Transactional
    @Override
    public void add(Car car) {
        carDao.add(car);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> listCars() {
        return carDao.listCars();
    }

    @Override
    public List<Car> listCarsWithLimit(Integer count) {
        if (count == null || count >= prop.getLimit()) {
            return listCars();
        } else {
            return carDao.listCarsWithLimit(count);
        }
    }
}
