package com.in_28mins.springmvc;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in_28mins.login.UserValidationService;
import com.in_28mins.todo.TodoService;

// This will handle all the web request ;)

@Controller
@SessionAttributes("kname")
public class LoginController {
	
	@Autowired
	UserValidationService userValidationService=new UserValidationService();
	
	@Autowired
	TodoService todoService;
	
	
	
	@RequestMapping(value = "/list-todos",method = RequestMethod.GET)
	public String showTodos(ModelMap model) {
		model.addAttribute("todos",todoService.retrieveTodos("in28Mins"));
		return "list-todos";
	}
	
	@RequestMapping(value = "/add-todo",method = RequestMethod.GET)
	public String showTodos() {	
		return "todo";
	}
	
	@RequestMapping(value = "/add-todo",method = RequestMethod.POST)
	public String addTodos(ModelMap model, @RequestParam String desc) {	
		todoService.addTodo("in28Mins", desc, new Date(), false);
		model.clear();
		return "redirect:list-todos";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String handleLogin() {
		return "login";
	}
	
	@RequestMapping(value="/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(ModelMap model, @RequestParam int id) {
		todoService.deleteTodo(id);
		model.clear();
		return "redirect:list-todos";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String showLoginPage(@RequestParam String kname,
			@RequestParam String pwd,
			ModelMap model) {
		if(userValidationService.checkCredentials(kname, pwd)) {
			model.put("kname", kname);
			model.put("pwd", pwd);
			return "Welcome";
		}else {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
	}
	
}
