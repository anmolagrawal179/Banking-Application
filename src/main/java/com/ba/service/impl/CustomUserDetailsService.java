package com.ba.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ba.exception.UserNotFoundException;
import com.ba.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<com.ba.entity.User> user = userRepository.findByUsername(username);
		if (user.isPresent()) {
			return User.builder().username(username).password(user.get().getPassword()).roles(user.get().getRole())
					.build();
		}

		else {
			throw new UserNotFoundException("User not found with username: " + username);
		}
	}

}
