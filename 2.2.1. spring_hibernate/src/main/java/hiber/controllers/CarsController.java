package hiber.controllers;

import hiber.dao.CarDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cars")
public class CarsController {

    private final CarDao carDao;

    public CarsController(CarDao carDao) {
        this.carDao = carDao;
    }

    @GetMapping()
    public String getCars(Model model) {
        model.addAttribute("cars", carDao.listCars());
        return "cars";
    }
}
