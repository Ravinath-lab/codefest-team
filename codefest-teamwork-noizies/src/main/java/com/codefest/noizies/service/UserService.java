package com.codefest.noizies.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codefest.noizies.dto.UserDTO;
import com.codefest.noizies.entity.User;
import com.codefest.noizies.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public List<UserDTO> getAllUsers() {
		List<User> list = userRepo.findAll();
		List<UserDTO> users = new ArrayList<UserDTO>();
		for(User u : list) {
			UserDTO uDto = new UserDTO();
			uDto.setId(u.getUserId());
			uDto.setName(u.getName());
			uDto.setEmail(u.getEmail());
			uDto.setMobile(u.getMobile());
			uDto.setAge(u.getAge());
			users.add(uDto);
		}
		return users;
	}

	public UserDTO saveUser(User user) {
		User u = userRepo.save(user);
		UserDTO uDto = convertUserToDTO(u);
		return uDto;
	}
	
	public UserDTO updateUser(User u) {
		User avbUser = userRepo.findUserByUserId(u.getUserId());
		if(avbUser != null) {
			if(u.getAge() > 0) {
				avbUser.setAge(u.getAge());
			}
			if(u.getName() != null && !u.getName().trim().isEmpty()) {
				avbUser.setName(u.getName());
			}
			if(u.getEmail() != null && !u.getEmail().trim().isEmpty()) {
				avbUser.setEmail(u.getEmail());
			}
			if(u.getPassword() != null && !u.getPassword().trim().isEmpty()) {
				avbUser.setPassword(u.getPassword());
			}
			if(u.getMobile() != null && !u.getMobile().trim().isEmpty()) {
				avbUser.setMobile(u.getMobile());
			}
			User saveUser = userRepo.save(avbUser);
			return convertUserToDTO(saveUser);
		}else {
			return null;
		}
	}
	
	private UserDTO convertUserToDTO(User u) {
		UserDTO uDto = new UserDTO();
		uDto.setId(u.getUserId());
		uDto.setName(u.getName());
		uDto.setEmail(u.getEmail());
		uDto.setMobile(u.getMobile());
		uDto.setAge(u.getAge());
		return uDto;
	}

	public void deleteUser(int id) {
		userRepo.deleteById(id);
	}
}
