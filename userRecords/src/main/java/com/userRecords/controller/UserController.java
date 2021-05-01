package com.userRecords.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userRecords.entity.User;
import com.userRecords.repository.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(path = "/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        return userService.getAllUsers();
    }
	
	@GetMapping(path = "/getUser/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {
        return userService.gerUserById(id);
    }
	
	@PostMapping(path = "/addUser")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateTutorial(@PathVariable("id") Integer id,@RequestBody User user) {
		return userService.updateUser(user, id);
	}
	
	@DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<User> deleteEmployeeById(@PathVariable("id") Integer id) {
        return userService.deleteUserById(id);
    }

}
