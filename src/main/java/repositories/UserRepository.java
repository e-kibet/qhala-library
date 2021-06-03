package repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query
	User findUserByEmail(String email);
	
	@Query(value = "select * FROM users where msisdn = ?1", nativeQuery = true)
	Optional<User> findByMsisdn(String msisdn);
	
	@Query(value = "select * FROM users where email = ?1", nativeQuery = true)
	Optional<User> findByEmail(String email);
	
	
}
