package com.niit.hackathon.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher;
	Connection con=CreateConn.createConnection();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/":
			dispatcher = request.getRequestDispatcher("WEB-INF/index.html");
			dispatcher.forward(request, response);
			break;
		case "register":
			System.out.println("Register");
			registerUser(request, response);
			break;
		case "login":
			System.out.println("Login");
			loginUser(request, response);
			break;
		case "recoverPwd":
			recoverPwd(request, response);
			break;

		}
	}
	
	public void registerUser(HttpServletRequest request, HttpServletResponse response) {
		
		String url="insert into customerTable values(?,?,?,?)";
		PreparedStatement statement=con.prepareStatement(url);
		statement.setString(1, request.getParameter("userName"));
		statement.setString(2, request.getParameter("customerPassword"));
		statement.setString(3, request.getParameter("customerName"));
		statement.setString(4, request.getParameter("customerEmail"));
		int count=statement.executeUpdate();
		if (count) {
			dispatcher=request.getRequestDispatcher("WEB-INF/index.html");
		}
		else
		{
			dispatcher=request.getRequestDispatcher("register.html");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
