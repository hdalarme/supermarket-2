package xyz.helbertt.supermarket.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import xyz.helbertt.supermarket.exception.SupermarketNotFoundException;
import xyz.helbertt.supermarket.model.User;
import xyz.helbertt.supermarket.repository.UserRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthServiceImpl implements AuthService {
	
	private PasswordEncoder encoder;
	
	private final UserRepository repository;
	
	@Override
	public ResponseEntity<Boolean> login(String email, String password) throws SupermarketNotFoundException {
	
		Optional<User> optUser = Optional.ofNullable(repository.findByEmail(email)
				.orElseThrow(() -> new SupermarketNotFoundException ("User", "E-mail", email)));
		
		User user = optUser.get();
		boolean valid = encoder.matches(password, user.getPassword()); 
		
		HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
		return ResponseEntity.status(status).body(valid);
	}

}
