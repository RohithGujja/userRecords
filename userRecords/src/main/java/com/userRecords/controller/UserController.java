package com.userRecords.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.userRecords.entity.User;
import com.userRecords.repository.UserService;
import com.userRecords.util.Gender;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(path = "/")
    public String start(Model model) {
		return "redirect:/getAllUsers";
    }
	
	@RequestMapping(path = "/getAllUsers")
    public String getAllUsers(Model model) {
		List<User> userList = userService.getAllUsers();
		Collections.sort(userList);
		model.addAttribute("userList", userList);
		return "index";
    }
	
	@RequestMapping(path = "/getUser/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }
	
	@RequestMapping(path = "/addUser")
    public String addUser(Model model) {
		model.addAttribute("userDetails", new User());
		model.addAttribute("genderList", Gender.values());
		return "createUser";
    }
	
	@PostMapping(path = "/saveUser")
    public String saveUser(@ModelAttribute("userDetails") User user) {
        userService.createUser(user);
        return "redirect:/getAllUsers";
    }
	
	@RequestMapping("/editUserDetails/{id}")
	public ModelAndView updateTutorial(@PathVariable("id") Integer id) {
		ModelAndView view = new ModelAndView("editUser");
		view.addObject("userDetails", userService.getUserById(id));
		view.addObject("genderList", Gender.values());
		return view;
	}
	
	@RequestMapping("/deleteUser/{id}")
    public String deleteEmployeeById(@PathVariable("id") Integer id) {
        userService.deleteUserById(id);
        return "redirect:/getAllUsers";
    }

}
