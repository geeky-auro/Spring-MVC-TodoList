package com.in_28mins.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// This will handle all the web request ;)

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String handleLogin() {
		return "login";
	}
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String showLoginPage(@RequestParam String kname,
			@RequestParam String pwd,
			ModelMap model) {
		model.put("kname", kname);
		model.put("pwd", pwd);
		System.out.println(kname);
		return "Welcome";
	}
}
