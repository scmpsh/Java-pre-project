package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Val", "Valya", (byte) 18);
        userService.saveUser("Pupkin", "Upkin", (byte) 34);
        userService.saveUser("Dim", "Dimich", (byte) 43);
        userService.saveUser("Gnom", "Gnomich", (byte) 34);
        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
