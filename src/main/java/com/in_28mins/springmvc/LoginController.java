package com.in_28mins.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// This will handle all the web request ;)

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login")
	@ResponseBody
	public String sayHello() {
		return "Hello World";
	}
}
