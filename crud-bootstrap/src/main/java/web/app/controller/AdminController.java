package web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.app.model.Role;
import web.app.model.User;
import web.app.service.RoleService;
import web.app.service.UserService;
import java.security.Principal;

@Controller
@RequestMapping("/")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("admin")
    public String adminPage(Model model, Principal principal) {
        model.addAttribute("users", userService.readUsers());
        model.addAttribute("user", userService.getUserByName(principal.getName()));
        model.addAttribute("roles", roleService.readAllRole());
        return "admin";
    }

    @GetMapping("admin/new-user")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "pages/newUser";
    }

    @PostMapping("admin/new-user")
    public String createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/admin";
    }

    @GetMapping("admin/new-role")
    public String addRole(Model model) {
        model.addAttribute("role", new Role());
        return "pages/newRole";
    }

    @PostMapping("admin/new-role")
    public String createRole(@ModelAttribute("role") Role role) {
        roleService.createRole(role);
        return "redirect:/admin";
    }

    @GetMapping("admin/edit/{name}")
    public String editUser(@PathVariable("name") String name, Model model) {
        model.addAttribute("user", userService.getUserByName(name));
        model.addAttribute("roleList", roleService.readAllRole());
        return "pages/edit";
    }

    @PatchMapping("admin/edit/{name}")
    public String updateUser(@PathVariable("name") String name, @ModelAttribute("user") User user) {
        userService.updateUser(name, user);
        return "redirect:/admin";
    }

    @DeleteMapping("admin/delete/{name}")
    public String deleteUser(@PathVariable("name") String name) {
        userService.deleteUser(name);
        return "redirect:/admin";
    }
}
