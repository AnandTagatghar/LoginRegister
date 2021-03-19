package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;
import com.example.demo.service.UsersServiceImpl;

@Controller
public class MainController {

	@Autowired
	private UsersServiceImpl service;

	@Autowired
	private UsersRepository repo;

	@RequestMapping("/")
	public String index(Model model) {
		List<Users> urs = service.findAll();
		model.addAttribute("users", urs);
		return "index";
	}

	@RequestMapping("/register")
	public String register(Model model) {
		Users user = new Users();
		model.addAttribute("register", user);
		return "Register";
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("register") Users user, Model model) {
		String pwd = user.getPassword();
		String cpwd = user.getConfirmpassword();

		if (pwd.equals(cpwd)) {
			Users existUser = repo.findByemailIgnoreCase(user.getEmail());
			if (existUser != null) {
				model.addAttribute("user", "exist");
				return "success";
			} else {
				service.save(user);
				model.addAttribute("user", "successRegister");
				return "success";
			}
		}
		model.addAttribute("user", "mismatch");
		return "success";
	}

	@RequestMapping("/login")
	public String login(Model model) {
		Users user = new Users();
		model.addAttribute("login", user);
		return "login";
	}

	@PostMapping("/loginUser")
	public String loginUser(Users user, Model model) {
		Users userpwd = repo.findBypassword(user.getEmail(), user.getPassword());
		if (userpwd != null) {
			model.addAttribute("user", "success");
			return "success";
		} else {
			model.addAttribute("user", "failed");
			return "success";
		}

	}

}
