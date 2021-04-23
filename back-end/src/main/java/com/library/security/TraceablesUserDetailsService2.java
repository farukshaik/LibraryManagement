package com.library.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.library.entity.Signupentityclass;
import com.library.model.TraceablesUser;
import com.library.repository.Signuprepoclass;

@Service("prospectUserDetailsService2")
public class TraceablesUserDetailsService2 implements UserDetailsService {

	@Autowired
	private Signuprepoclass userRepository;



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String details[] = username.split("\\$");
		Signupentityclass user = userRepository.findByRollNoAndRole(details[0],details[1]);

		if (user == null) {
			String message = "Username not found" + username;
			throw new UsernameNotFoundException(message);
		}

		List<GrantedAuthority> authorities = new ArrayList<>();

		

		return new TraceablesUser(username, user.getPassword(), authorities);
	}

}
