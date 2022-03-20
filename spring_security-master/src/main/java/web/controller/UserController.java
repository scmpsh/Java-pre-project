package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class UserController {

	private final UserService userService;
	private final RoleService roleService;

	public UserController(UserService userService, RoleService roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}

    @GetMapping("login")
    public String loginPage() {
        return "pages/login";
    }

	@GetMapping("user")
	public String userPage(Principal principal, Model model) {
		model.addAttribute("user", userService.getUserByName(principal.getName()));
		return "pages/user";
	}

	@GetMapping("admin")
	public String adminPage(Model model) {
		model.addAttribute("users", userService.readUsers());
		return "pages/admin";
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