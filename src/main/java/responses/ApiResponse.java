package responses;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.stereotype.Component;

import models.User;

@Component
public class ApiResponse {
	public HashMap<String, Object> apiResponse(Boolean status, int code, String message){
		 HashMap<String, Object> map = new HashMap<>();
		map.put("status", status);
	    map.put("code", code);
	    map.put("message", message);
	    return map;
	}
	
	public HashMap<String, Object> apiLoginResponse(Boolean status, int code, String message,  Optional<User> user, String token){
		 HashMap<String, Object> map = new HashMap<>();
		map.put("status", status);
	    map.put("code", code);
	    map.put("message", message);
	    map.put("user", user);
	    map.put("token", token);
	    return map;
	}

	
}
