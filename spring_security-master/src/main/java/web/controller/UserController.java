package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

    @GetMapping("login")
    public String loginPage() {
        return "pages/login";
    }

	@GetMapping("user")
	public String userPage(Model model) {
		model.addAttribute("user", userService.getUserByName("admin"));
		return "pages/user";
	}

	@GetMapping("admin")
	public String adminPage(Model model) {
		model.addAttribute("user", userService.getUserByName("admin"));
		return "pages/admin";
	}

	@GetMapping("/admin/new")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "pages/new";
	}

	@PostMapping
	public String createUser(@ModelAttribute("user") User user) {
		userService.createUser(user);
		return "redirect:/admin";
	}

	@GetMapping("/admin/{id}/edit")
	public String editUser(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "user/edit";
	}

	@PatchMapping("/{id}")
	public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
		userService.updateUser(id, user);
		return "redirect:/admin";
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		return "redirect:/admin";
	}
}