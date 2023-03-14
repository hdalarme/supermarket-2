package xyz.helbertt.supermarket.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import xyz.helbertt.supermarket.model.Token;

public interface TokenRepository extends JpaRepository<Token, Long>{

	/*@Query("select t from Token t "
			+ "inner join User u on t.user_id = u.id "
			+ "where u.id = :userId "
			+ "and (t.expired = false or t.revoked = false)")*/
	@Query("select t from Token t "
			+ "inner join User u "
			+ "where u.id = :userId "
			+ "and (t.expired = false or t.revoked = false)")
	List<Token> findAllValidTokensByUser(Long userId);
	
	Optional<Token> findByToken(String token);
	
}
