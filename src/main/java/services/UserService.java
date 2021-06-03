package services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import models.User;
import repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public Optional<User> checkIfPhoneExist(String msisdn) {
		return userRepository.findByMsisdn(msisdn);
		
	}
	
	public Optional<User> checkIfEmailIsTaken(String email) {
		return userRepository.findByEmail(email);		
	}


	public void registerUser(String firstName, String lastName,String email_id, String phoneNumber, String password) {
		User user=new User();
		String bcPassword=bCryptPasswordEncoder.encode(password);
		user.setFirst_name(firstName);
		user.setLast_name(lastName);
		user.setEmail_address(email_id);
		user.setMsisdn(phoneNumber);
		user.setPassword(bcPassword);
		userRepository.save(user);
	}
	
	public boolean loginUser(String email, String password) {
		Optional<User> user = userRepository.findByEmail(email);
		System.out.println("user password details"+ user.toString());
		if(user.isPresent()) {
			String pass = user.get().getPassword();
			if(bCryptPasswordEncoder.matches(password, pass)) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
}
