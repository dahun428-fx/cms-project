package kr.co.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {

	@GetMapping("/signin.do")
	public String signinView() {
		
		return "/user/signinForm.page";
	}
	
	
}
