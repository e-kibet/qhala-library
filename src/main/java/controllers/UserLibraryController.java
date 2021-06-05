package controllers;
import java.util.HashMap;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import models.UserLibrary;
import responses.ApiResponse;
import services.UserLibraryService;

@RestController
@RequestMapping("/api/v1")
public class UserLibraryController {
	
	@Autowired
	private ApiResponse apiResponse;
	@Autowired
	private UserLibraryService userLibraryService;
	
	@PostMapping("/userlibrary")
	public HashMap<String, Object> createBook(@Valid @RequestBody  UserLibrary userLibrary) {
		userLibraryService.saveUserLibrary(userLibrary);
		return apiResponse.apiResponse(true, 200, "user library has been created");
	}

}
