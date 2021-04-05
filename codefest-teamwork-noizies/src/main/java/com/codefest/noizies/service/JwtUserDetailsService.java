package com.codefest.noizies.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.codefest.noizies.model.JwtRequest;
import com.codefest.noizies.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("working in service");
		if ("ravinath".equals(username)) {
			System.out.println("match user");
			
//			return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>());
			String pwd = BCrypt.hashpw("123", BCrypt.gensalt());
			return new User("ravinath", pwd,
				new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
	
	public UserDetails loadUser(JwtRequest user)throws Exception {
		System.out.println("in loadUser");
		com.codefest.noizies.entity.User u1 = repo.findUserByAuth(user.getUsername(), user.getPassword());
		System.out.println("read auth user");
		if(u1 != null) {
			System.out.println("in if");
			String pwd = BCrypt.hashpw(u1.getPassword(), BCrypt.gensalt());
			return new User(u1.getEmail(), pwd,
					new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("User not found with username: ");
		}
	}
	
	public UserDetails loadUserByUserEmail(String user)throws Exception {
		System.out.println("in loadUser");
		com.codefest.noizies.entity.User u1 = repo.findUserByEmail(user);
		System.out.println("read auth user");
		if(u1 != null) {
			System.out.println("in if");
			String pwd = BCrypt.hashpw(u1.getPassword(), BCrypt.gensalt());
			return new User(u1.getEmail(), pwd,
					new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("User not found with username: ");
		}
	}

}