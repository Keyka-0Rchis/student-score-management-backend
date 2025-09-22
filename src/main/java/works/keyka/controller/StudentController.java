package works.keyka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class StudentController {
	
	@PostMapping("/register")
	public String registerStudent(@RequestBody InputedUserParam body) {
		
	}
}
