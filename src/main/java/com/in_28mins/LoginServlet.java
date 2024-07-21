package com.in_28mins;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException {
		
		String name=(request.getParameter("name"));
		request.setAttribute("name", name);
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, respone);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException {
		String uname=request.getParameter("kname");
		String pwd=request.getParameter("pwd");
		request.setAttribute("errorMessage", "");
		boolean checkCredentials = UserValidationService.checkCredentials(uname, pwd);
		System.out.println(request.getParameter("kname"));
		if(checkCredentials) {
			request.setAttribute("name", uname);
			request.getRequestDispatcher("/WEB-INF/views/Welcome.jsp").forward(request, respone);
		}else {
			if(request.getParameter("kname")=="Auro") {
				request.setAttribute("errorMessage", "Invalid Credentials");
			}else {				
				request.setAttribute("errorMessage", "Invalid Credentials");
			}
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, respone);
		}		
	}
}
