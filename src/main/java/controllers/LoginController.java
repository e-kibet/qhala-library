package controllers;
import java.util.HashMap;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import models.UserLogin;
import services.UserService;

@RestController
@RequestMapping("/api/v1")
public class LoginController {
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public  HashMap<String, Object> loginUser(@RequestBody UserLogin userLogin, HttpServletResponse res) {
	  return userService.loginUser(userLogin.getEmail_address(), userLogin.getPassword());
	}

}
