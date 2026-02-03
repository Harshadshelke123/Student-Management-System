package com.cwm.demo.serviceimpl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cwm.demo.model.Users;
import com.cwm.demo.repository.UsersRepository;


public class UserServiceImpl implements UserDetailsService{

	private UsersRepository usersRepository;
	
	public UserServiceImpl(UsersRepository usersRepository) {
		
		this.usersRepository =usersRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users users = usersRepository.findByUsername(username)
				.orElseThrow(()->new UsernameNotFoundException("Invalid Username "));
		
		return User.withUsername(username)
				.password(users.getPassword())
				.disabled(!users.isActive())
				.build();
		
	}
	
	
	

}
