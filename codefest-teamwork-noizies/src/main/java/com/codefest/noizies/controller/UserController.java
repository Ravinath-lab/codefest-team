package com.codefest.noizies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codefest.noizies.dto.UserDTO;
import com.codefest.noizies.entity.User;
import com.codefest.noizies.service.UserService;

@RestController
@RequestMapping(path = "/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/getAll")
	public List<UserDTO> getAll(){
		return userService.getAllUsers();
	}
	
	@GetMapping(path = "/get/{id}")
	public UserDTO getUser(@PathVariable int id){
		return userService.getUserById(id);
	}
	
	@PostMapping(path = "/save")
	public UserDTO saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@PutMapping(path = "/update")
	public UserDTO updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}
}
