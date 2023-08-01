package com.divya.servlets;

import java.io.IOException;

import javax.inject.Singleton;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Singleton
public class RegisterServlet extends HttpServlet {


	private static final long serialVersionUID = 8603771173750554610L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Pages/Register.jsp");
		requestDispatcher.forward(req, resp);
	}


}
