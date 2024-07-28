package com.in_28mins.todo;

import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.Size;

//import javax.xml.crypto.Data;


public class Todo {
	private int id;
	private String user;
	@Size(min = 6, message = "Enter a Minimum of 6 Characters")
	private String desc;
	private Date date;
	private boolean isDone;
	
	
	public Todo() {
		
	}
	
	
	
	public Todo(int id, String user, String desc, Date date, boolean isDone) {
		super();
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.date = date;
		this.isDone = isDone;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	@Override
	public String toString() {
		return " ToString - Todo [id=" + id + ", user=" + user + ", desc=" + desc + ", date=" + date + ", isDone=" + isDone + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		return id == other.id;
	}
	
	
	
}
