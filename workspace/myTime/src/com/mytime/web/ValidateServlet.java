package com.mytime.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mytime.db.UserDB;

/**
 * Servlet implementation class ValidateServlet
 */
@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		UserDB users = new UserDB();
		if(users.openDB() == true) {		
			String userid = request.getParameter("username");
			String pwd = request.getParameter("password");
			String validuser = users.getUserName(userid, pwd);
			
			if(validuser != "") {
				// Retrieved a valid user
				request.setAttribute("validuser", validuser);
				request.getRequestDispatcher("/WEB-INF/showUserPage.jsp").forward(request,response);
			} else {
				request.setAttribute("errmsg", "Unknown user or password");
				request.getRequestDispatcher("/WEB-INF/showError.jsp").forward(request,response);
			}
			users.closeDB();
		} else {
			System.out.println("Error accessing database.");
			request.setAttribute("errmsg", "Error accessing database.");
			request.getRequestDispatcher("/WEB-INF/showError.jsp").forward(request,response);
		}
	}	
	

}
