package xyz.helbertt.supermarket.service;

import java.util.Optional;

import org.hibernate.annotations.Comment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import xyz.helbertt.supermarket.data.UserDetailsData;
import xyz.helbertt.supermarket.model.User;
import xyz.helbertt.supermarket.repository.UserRepository;

@Comment(value = "")
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository repository;
	
	public UserDetailsServiceImpl(UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = repository.findByEmail(username);
		if (user.isEmpty()) {
			throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado");
		}
		return new UserDetailsData(user);
	}

}
