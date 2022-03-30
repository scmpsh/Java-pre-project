package web.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.app.model.User;
import web.app.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String getUserPage() {
        return "user";
    }

    @GetMapping("/users/all")
    public List<User> getAllUsers() {
        return userService.readUsers();
    }
}