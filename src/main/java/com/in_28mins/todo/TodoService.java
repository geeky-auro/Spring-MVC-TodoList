package com.in_28mins.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class TodoService {
	private static List<Todo> todos= new ArrayList<Todo>();
	private static int todoCount=4;
	
	static {
		todos.add(new Todo(1,"in28Mins","Learn SpringMVC",new Date(),false));
		todos.add(new Todo(2,"in28Mins","Learn Springboot",new Date(),false));
		todos.add(new Todo(3,"in28Mins","Learn Cloud Essentials",new Date(),false));
		todos.add(new Todo(4,"in28Mins","Learn SpringMVC & HibernateJPA",new Date(),false));
	}
	
	public void addTodo(String name,String desc,Date date,boolean isDone) {
		todoCount++;
		todos.add(new Todo(todoCount, name, desc, date, isDone));
	}
	
	public void deleteTodo(int id) {
		Iterator<Todo> iterator =todos.iterator();
		while(iterator.hasNext()) {
			Todo todo= iterator.next();
			if(todo.getId()==id) {
				iterator.remove();
			}
		}
	}
	
	public List<Todo> retrieveTodos(String user){
		List<Todo> filteredTodos= new ArrayList<Todo>();
		for(Todo todo:todos) {
			if(todo.getUser().equals(user)) {
				filteredTodos.add(todo);
			}
		}
		
		return filteredTodos;
	}

}
