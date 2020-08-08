package com.livescoreboard.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import com.livescoreboard.util.DBConnection;

/**
 * Servlet implementation class PostTeamServlet
 */
@MultipartConfig(fileSizeThreshold=1024*1024*2, 
maxFileSize=1024*1024*10, 
maxRequestSize=1024*1024*50)
@WebServlet("/PostTeamServlet")
public class PostTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger LOGGER = Logger.getLogger(PostTeamServlet.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostTeamServlet() {
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
	    String respo = "Success Fully Submitted";
	    Part part = request.getPart("team_file");
	    String team_name = request.getParameter("team_name");
	    String sportstype  = request.getParameter("sports_type");
	    int ranking = Integer.parseInt(request.getParameter("ranking"));
	    String coach_name = request.getParameter("coach_name");
	    int est_year = Integer.parseInt(request.getParameter("year"));
	    String image_url = "C:\\Users\\harish\\eclipse-workspace\\LiveScoreBoard\\WebContent\\img"+File.separator+part.getSubmittedFileName();
	    String image_ur="img"+File.separator+part.getSubmittedFileName();
	    part.write(image_url);
	   
	   try {
		Connection con = DBConnection.getConnection();
		String query = "insert into team(team_name,sportstype,ranking,coach_name,established_year,image_url) values(?,?,?,?,?,?)";
		PreparedStatement prep = con.prepareStatement(query);
		prep.setString(1,team_name);
		prep.setString(2,sportstype);
		prep.setInt(3, ranking);
		prep.setString(4, coach_name);
		prep.setInt(5, est_year);
		prep.setString(6, image_ur);
		
		prep.executeUpdate();
		response.getWriter().write(respo);
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		LOGGER.error("Posting Teams Details Failed");
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		LOGGER.error("Posting Teams Details Failed");
		e.printStackTrace();
	}
	    
	    LOGGER.info("Posting Teams Details");
	}

}
