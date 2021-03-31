package com.codefest.noizies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codefest.noizies.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
}
