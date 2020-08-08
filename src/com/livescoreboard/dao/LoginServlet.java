package com.livescoreboard.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.livescoreboard.util.DBConnection;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger LOGGER = Logger.getLogger(LoginServlet.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username=request.getParameter("username");
		String password = request.getParameter("password");
		boolean userauthenticated;
		try {
			userauthenticated = AdminDao.authenticateAdmin(username, password);
			if(userauthenticated)
			{
	
				response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
		        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		        response.setDateHeader("Expires", 0);
				HttpSession session = request.getSession();
				session.setAttribute("username",username);
				String Url = request.getRequestURL().toString();
				int i=Url.length()-1;
				for(i=Url.length()-1;i>=0;i--)
				{
					if(Url.charAt(i)=='/')
						break;
				}
				response.getWriter().write(Url.substring(0, i+1)+"AdminDashBoard.jsp");
 			}
			else
			{
				response.getWriter().write("false");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error authenticating user"+username);
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error authenticating user"+username);
			e.printStackTrace();
		}
	}

}
