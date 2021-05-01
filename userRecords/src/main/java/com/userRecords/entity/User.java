package com.userRecords.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.userRecords.util.Gender;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer user_id;
	
	@NotBlank(message = "Name is Mandatory")
	private String user_name;

	@Positive(message = "Age should be Positive")
	@NotNull(message = "Age is Mandatory")
	private Integer age;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Gender is Mandatory")
    private Gender gender;
	
	@NotBlank(message = "Address is Mandatory")
	private String address;

	public User(Integer user_id, @NotBlank(message = "Name is mandatory") String user_name,
			@Positive(message = "Age should be Positive") Integer age, Gender gender, String address) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}
	
	public User() {
		super();
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", age=" + age + ", gender=" + gender
				+ ", address=" + address + "]";
	}

}
