package com.zsgs.mailmaster.features.registration;

import com.zsgs.mailmaster.data.dto.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RegistrationModel
{
	private List<User> users = new ArrayList<>();
	private int nextId = 1;

	public User registerUser(String username, String password, String email, int age, String phone) {
		User user = new User(nextId++, username, password, email, age, phone);
		users.add(user);
		return user;
	}

	public Optional<User> getUserByUsername(String username) {
		return users.stream().filter(u -> u.getUsername().equals(username)).findFirst();
	}

	public Optional<User> authenticateUser(String email, String password) {
		return users.stream().filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password)).findFirst();
	}

	public Optional<User> getUserById(int id) {
		return users.stream().filter(u -> u.getId() == id).findFirst();
	}

	public List<User> getAllUsers() {
		return new ArrayList<>(users);
	}
}
