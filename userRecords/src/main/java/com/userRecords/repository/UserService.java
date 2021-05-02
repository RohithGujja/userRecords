package com.userRecords.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userRecords.exception.NotFoundException;
import com.userRecords.entity.User;
import com.userRecords.service.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList;
    }
	
    public User getUserById(Integer id) {
    	User user = userRepository.findById(id)
				  		.orElseThrow(() -> new NotFoundException("Oops!!! No User details not found with user id: "+id));
        return user;
    }
    
    public void createUser(User user) {
        userRepository.save(user);
    }
    
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }
}
