package web.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import web.app.service.UserService;

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/becomeAnAdmin/{id}")
    public void becomeAnAdmin(@PathVariable("id") Long id) {
        userService.sendRequestToAdmins(id);
    }
}
