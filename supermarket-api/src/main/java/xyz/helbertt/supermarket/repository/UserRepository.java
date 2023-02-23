package xyz.helbertt.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.helbertt.supermarket.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
