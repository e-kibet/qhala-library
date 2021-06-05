package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import models.User;
import responses.ApiResponse;
import services.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ApiResponse apiResponse;
	
	@GetMapping("/users")
	public ResponseEntity<Map<String, Object>> getUsers(HttpServletResponse res, @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "10") int size){
		res.setStatus(HttpServletResponse.SC_ACCEPTED);
		return userService.getUsers(page, size);
	}
	
	@PostMapping("/users")
	public HashMap<String, Object> registerUser(@Valid @RequestBody  User user) {
		Optional<User> data=userService.checkIfPhoneExist(user.getMsisdn());
		if(data.isPresent()) {
			return apiResponse.apiResponse(false, 404, "Phone number is already taken");
		}else {
			Optional<User> emailOptional =userService.checkIfEmailIsTaken(user.getEmail());
			if(emailOptional.isPresent()) {
				return apiResponse.apiResponse(false, 404, "Email addesss is already taken");
			}else {
				userService.registerUser(user.getFirst_name(),user.getLast_name(),user.getEmail(),user.getMsisdn(),user.getPassword()); 
				return apiResponse.apiResponse(true, 200, "success");
			}
		}
	}
	@GetMapping("/users/{id}")
    public ResponseEntity<User> getUserEntity936ById(@PathVariable(value = "id") int id) {
        User user = userService
                  .findById(id)
                  .orElseThrow();
        return ResponseEntity.ok().body(user);
    }
			
}
