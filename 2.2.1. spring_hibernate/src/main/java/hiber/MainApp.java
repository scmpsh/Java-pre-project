package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

//@SpringBootApplication
public class MainApp {
    public static void main(String[] args) {
//        SpringApplication.run(MainApp.class, args);
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car car = new Car("car1", 11);
        Car car1 = new Car("car2", 12);
        Car car2 = new Car("car3", 13);
        Car car3 = new Car("car4", 14);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru", car));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", car1));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", car2));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", car3));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }

        System.out.println(userService.getUserByModelAndSeriesCar("car1", 11));

        context.close();
    }
}
