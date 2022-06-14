package com.loginlogout.assessment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		if (email.equals("abc@gmail.com") && pass.equals("abc")) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("Welcome");
		} else {
			// Set the content type of response to "text/html"
			response.setContentType("text/html");

			// Get the print writer object to write into the response
			PrintWriter out = response.getWriter();
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			out.println("<font color=red>Password is wrong.</font>");
			rd.include(request, response);
		}
	}

}
