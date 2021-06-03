package services;

import java.util.HashMap;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import config.JwtTokenProvider;
import models.User;
import repositories.UserRepository;
import responses.ApiResponse;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	 @Autowired
	 private AuthenticationManager authenticationManager;
	 
	 @Autowired
	 private ApiResponse apiResponse;
	
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
		user.setEmail(email_id);
		user.setMsisdn(phoneNumber);
		user.setPassword(bcPassword);
		userRepository.save(user);
	}
	
	public HashMap<String, Object> loginUser(String email, String password) {
		Optional<User> user = userRepository.findByEmail(email);
		if(user.isPresent()) {
			String pass = user.get().getPassword();
			if(bCryptPasswordEncoder.matches(password, pass)) {
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
				String tokenString  = jwtTokenProvider.createToken(email, userRepository.findByEmail(email).get().getRoles());
				System.out.println("token details:::"+tokenString);
				return apiResponse.apiLoginResponse(true, 200, "login success", user, tokenString);
			}else {
				return apiResponse.apiResponse(false, 404, "Login failed");
			}
		}else {
			return apiResponse.apiResponse(false, 404, "Login failed");
		}
	}
}
