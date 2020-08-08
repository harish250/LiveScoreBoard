package com.livescoreboard.dao;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import com.livescoreboard.util.DBConnection;

/**
 * Servlet implementation class PostMatchServlet
 */
@WebServlet("/PostMatchServlet")
public class PostMatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger LOGGER = Logger.getLogger(PostMatchServlet.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostMatchServlet() {
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
		 String respo = "Success Fully Submitted";
		    int  first_team_id= Integer.parseInt(request.getParameter("first_team_id"));
		    int  first_team_score = Integer.parseInt(request.getParameter("first_team_score"));
		    int second_team_id =  Integer.parseInt(request.getParameter("second_team_id"));
		    int second_team_score =  Integer.parseInt(request.getParameter("second_team_score"));
		    String date  = request.getParameter("year");
		    String sportstype = request.getParameter("sportstype");
		    		   
		   try {
			Connection con = DBConnection.getConnection();
			String query = "insert into matches(first_team_id,first_team_score,second_team_id,second_team_score,year,sportstype) values(?,?,?,?,?,?)";
			PreparedStatement prep = con.prepareStatement(query);
			prep.setInt(1,first_team_id);
			prep.setInt(2,first_team_score);
			prep.setInt(3, second_team_id);
			prep.setInt(4, second_team_score);
			prep.setString(5, date);
			prep.setString(6, sportstype);
			
			
			prep.executeUpdate();
			response.getWriter().write(respo);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Cannot post match details");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Cannot post match details");
			e.printStackTrace();
		}
		    
		   LOGGER.info("posting match details");
	}

}
