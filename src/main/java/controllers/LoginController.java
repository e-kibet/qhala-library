package controllers;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import config.ApiResponse;
import models.UserLogin;
import services.UserService;

@RestController
@RequestMapping("/api/v1")
public class LoginController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ApiResponse apiResponse;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public  HashMap<String, Object> loginUser(@RequestBody UserLogin userLogin) {
		Boolean data = userService.loginUser(userLogin.getEmail_address(), userLogin.getPassword());
		if(data) {
			return apiResponse.apiResponse(true, 200, "login success");
		}else {
			return apiResponse.apiResponse(false, 404, "login failed");
		}
		
	}

}
