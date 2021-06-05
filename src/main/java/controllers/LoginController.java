package controllers;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import models.UserLogin;
import services.UserService;

@RestController
@RequestMapping("/api/v1")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public  HashMap<String, Object> loginUser(@RequestBody UserLogin userLogin, HttpServletResponse res) {
	  return userService.loginUser(userLogin.getEmail_address(), userLogin.getPassword());
	}

}
