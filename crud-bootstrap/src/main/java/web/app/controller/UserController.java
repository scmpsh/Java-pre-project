package web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.app.service.UserService;
import java.security.Principal;

@Controller
@RequestMapping("/")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("user")
	public String userPage(Principal principal, Model model) {
		model.addAttribute("user", userService.getUserByName(principal.getName()));
		return "user";
	}
}