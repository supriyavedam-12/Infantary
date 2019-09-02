package com.insta.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.insta.entity.InstaEmployee;
import com.insta.service.InstaService;
import com.insta.service.InstaServiceInterface;

/**
 * Servlet implementation class GlobalServlet
 */
public class GlobalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		
		String option = request.getParameter("ac");
		if(option.equals("register"))
		{
		
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		InstaEmployee ie=new InstaEmployee();
		ie.setName(name);
		ie.setPass(pass);
		ie.setEmail(email);
		ie.setAddress(address);
		InstaServiceInterface is=InstaService.createServiceObject();
		int i=is.createProfile(ie);
		if(i>0)
		{
			out.println("profile created");
		}
		else
		{
			out.println("could not create profile");
		}
		
		
	}
	if(option.equals("login"))
	{
		
	}
	if(option.equals("time")) {
	}
	out.println("</html></body>");
}
}
		
		
		
		
