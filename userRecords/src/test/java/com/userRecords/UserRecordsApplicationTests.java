package com.userRecords;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.userRecords.entity.User;
import com.userRecords.repository.UserService;
import com.userRecords.service.UserRepository;
import com.userRecords.util.Gender;

@SpringBootTest
class UserRecordsApplicationTests {
	
	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepository userRepository;
	
	@Test
	public void getAllUsersTest() {
		when(userRepository.findAll()).thenReturn(Stream.of(new User(70,"Raj",56,Gender.MALE,"Hyderabad"),
				new User(89,"Siri",32,Gender.FEMALE,"Warangal")).collect(Collectors.toList()));
		assertEquals(2,userService.getAllUsers().size());
	}
	
	@Test
	public void getUserTest() {
		User user = new User(56,"Raju",45,Gender.MALE,"NewYork");
		when(userRepository.findById(56)).thenReturn(Optional.of(user));
		assertThat(userService.getUserById(56)).isEqualTo(user);
	}
	
	@Test
	public void saveUserTest() {
		User user = new User(36,"Lara",25,Gender.FEMALE,"LosVegas");
		when(userRepository.save(user)).thenReturn(user);
		userService.createUser(user);
		verify(userRepository,times(1)).save(user);
	}
	
	@Test
	public void deleteUserTest() {
		userService.deleteUserById(36);
		verify(userRepository,times(1)).deleteById(36);
	}
	
}
