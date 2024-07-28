package com.in_28mins.springmvc;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in_28mins.login.UserValidationService;
import com.in_28mins.todo.Todo;
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
	public String listTodos(ModelMap model) {
		model.addAttribute("todos",todoService.retrieveTodos("in28Mins"));
		return "list-todos";
	}
	
	@RequestMapping(value = "/add-todo",method = RequestMethod.GET)
	public String showTodos(ModelMap model) {	
		model.addAttribute("todo",new Todo());
		return "todo";
	}
	
	@RequestMapping(value = "/add-todo",method = RequestMethod.POST)
	public String addTodos(ModelMap model, @Valid Todo todo, BindingResult result) {	
		if(result.hasErrors()) {
			return "todo";
		}
		todoService.addTodo((String) model.get("name"), todo.getDesc(), new Date(),
				false);
		model.clear();
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String handleLogin() {
		return "login";
	}
	
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String updateTodo(ModelMap model, @RequestParam int id) {
		
		model.addAttribute("todo", todoService.retrieveTodo(id));
		return "todo";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model,@Valid Todo todo, BindingResult result) {
		// Update Todo
		
		if(result.hasErrors()) {
			return "todo";
		}
		todo.setUser("in28Minutes"); //TODO:Remove Hardcoding Later

		todoService.updateTodo(todo);
		model.clear();// to prevent request parameter "name" to be passed

		// This return statement defines where do we want to redirect user ;)
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(ModelMap model, @RequestParam int id) {
		todoService.deleteTodo(id);
		model.clear();
		return "redirect:/list-todos";
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
