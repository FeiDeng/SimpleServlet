package com.fei.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fei.beans.User;
import com.fei.services.HelloService;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HelloService hs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
        if (hs==null) {
			hs = new HelloService();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = parse(request);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(hs.sayHello1(user));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = parse(request);
		String url = "/result.jsp";
		request.setAttribute("userInfo", hs.process(user));
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private User parse(HttpServletRequest request) {
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setAge(Integer.parseInt(request.getParameter("age")));
		return user;
	}
}
