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
 * Servlet implementation class PostPlayerServlet
 */
@WebServlet("/PostPlayerServlet")
public class PostPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger LOGGER = Logger.getLogger(PostPlayerServlet.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostPlayerServlet() {
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
		    Part part = request.getPart("player_file");
		    String player_name = request.getParameter("player_name");
		    String sportstype  = request.getParameter("sports_type");
		    int team_id = Integer.parseInt(request.getParameter("team_id"));
		    int age = Integer.parseInt(request.getParameter("age"));
		    String desc = request.getParameter("description");
		    String image_url = "C:\\Users\\harish\\eclipse-workspace\\LiveScoreBoard\\WebContent\\img"+File.separator+part.getSubmittedFileName();
		    
		    String img_url="img"+File.separator+part.getSubmittedFileName();
		
		    part.write(image_url);
		   
		   try {
			Connection con = DBConnection.getConnection();
			String query = "insert into player(player_name,sportstype,team_id,age,image_url,description) values(?,?,?,?,?,?)";
			PreparedStatement prep = con.prepareStatement(query);
			prep.setString(1,player_name);
			prep.setString(2,sportstype);
			prep.setInt(3, team_id);
			prep.setInt(4, age);
			prep.setString(5, img_url);
			prep.setString(6, desc);
			
			prep.executeUpdate();
			response.getWriter().write(respo);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Posting Players details");   
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Posting Players details");   
			e.printStackTrace();
		}
		 LOGGER.info("Posting Players details");   
	}

}
