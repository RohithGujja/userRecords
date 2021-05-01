package com.userRecords.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.userRecords.exception.NotFoundException;
import com.userRecords.entity.User;
import com.userRecords.service.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userRepository.findAll();
        if(userList.size() > 0) {
        	return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
        } else {
        	throw new NotFoundException("Oops!!! No Users found");
        }
    }
	
    public ResponseEntity<User> gerUserById(Integer id) {
    	User user = userRepository.findById(id)
				  		.orElseThrow(() -> new NotFoundException("Oops!!! No User details not found with user id: "+id));
        return new ResponseEntity<User>(user,HttpStatus.OK);
    } 
    
    public ResponseEntity<User> createUser(User user) {
        User userEntity = userRepository.save(user);
        return new ResponseEntity<User>(userEntity,HttpStatus.CREATED);
    }

    public ResponseEntity<User> updateUser(User userEntity,Integer id) {
    	User user = userRepository.findById(id)
				  		.orElseThrow(() -> new NotFoundException("Oops!!! No User details not found with user id: "+id));
        user.setUser_name(userEntity.getUser_name());
        user.setAge(userEntity.getAge());
        user.setGender(userEntity.getGender());
        user.setAddress(userEntity.getAddress());
        user = userRepository.save(user);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    } 
    
    public ResponseEntity<User> deleteUserById(Integer id) {
        User user = userRepository.findById(id)
        				.orElseThrow(() -> new NotFoundException("Oops!!! No User details not found with user id: "+id));
        userRepository.deleteById(id);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
}
