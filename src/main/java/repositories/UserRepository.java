package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import models.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query(value = "select * FROM users where msisdn = ?1", nativeQuery = true)
	Optional<User> findByMsisdn(String msisdn);
	
	@Query(value = "select * FROM users where email_address = ?1", nativeQuery = true)
	Optional<User> findByEmail(String email);
}
