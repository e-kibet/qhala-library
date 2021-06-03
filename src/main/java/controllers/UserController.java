package controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import config.Status;
import models.User;
import repositories.UserRepository;
import services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/api/v1/users")
	public Status registerUser(@Valid @RequestBody  User user) {
		List<User> users = (List<User>) userRepository.findAll();
		System.out.println("New user: " + user.toString());
		for(User existingUser : users) {
			if(existingUser.equals(user)) {
				 System.out.println("User Already exists!");
				return Status.USER_ALREADY_EXISTS;
			}
		}
		userRepository.save(user);
        return Status.SUCCESS;
	}
			
}
