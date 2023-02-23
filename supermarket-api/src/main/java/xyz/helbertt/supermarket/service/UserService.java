package xyz.helbertt.supermarket.service;

import java.util.List;

import xyz.helbertt.supermarket.model.User;

public interface UserService {

	List<User> getAll();
	
	User create(User user);
	
	User update(Long id, User user);
	
	void delete(Long id);
	
	User getById(Long id);
	
}