package controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {
	
	@GetMapping("/")
	public ModelAndView firstPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");             
		return modelAndView;
	}

}
