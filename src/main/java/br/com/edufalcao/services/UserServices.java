package br.com.edufalcao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.edufalcao.data.model.User;
import br.com.edufalcao.repository.UserRepository;

@Service
public class UserServices implements UserDetailsService{

	@Autowired
	UserRepository repository;
	
	public UserServices(UserRepository repository) {
		this.repository = repository;
	}	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = repository.findByUsername(username);
		if(u!=null)
			return u;
		else
			throw new UsernameNotFoundException("Username "+username+" not found!");
	}
	
}
