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
 * Servlet implementation class PostStatisticsServlet
 */
@WebServlet("/PostStatisticsServlet")
public class PostStatisticsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger LOGGER = Logger.getLogger(PostStatisticsServlet.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostStatisticsServlet() {
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

       String action = request.getParameter("type");
       switch(action)
       {
       case "post_stats_basketball":
    	    post_basketball(request,response);
    	   break;
       case "post_stats_football":
    	   post_football(request,response);
    	   break;
       case "post_stats_cricket":
    	   post_cricket(request,response);
    	   break;
    	default:
    		System.out.println("wrong post action");
    		LOGGER.error("Wrong option");
    		break;
   
    	   
       }
		
	}

	private static void post_cricket(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String respo = "Success Fully Submitted";
	    int team_id= Integer.parseInt(request.getParameter("cteam_id"));
	    int n_odi= Integer.parseInt(request.getParameter("cn_odi_won"));
	    int n_test_won= Integer.parseInt(request.getParameter("cn_test_won"));
	    int n_t20_won = Integer.parseInt(request.getParameter("cn_t20_won"));
	    int drawed = Integer.parseInt(request.getParameter("cn_drawed"));
	    int year = Integer.parseInt(request.getParameter("cyear"));
	    
	    
	    
	   try {
		Connection con = DBConnection.getConnection();
		String query = "insert into cricketstats(team_id,n_odi,n_t20,n_test,draws,year) values(?,?,?,?,?,?)";
		PreparedStatement prep = con.prepareStatement(query);
		prep.setInt(1,team_id);
		prep.setInt(2,n_odi);
		prep.setInt(3, n_t20_won);
		prep.setInt(4, n_test_won);
		prep.setInt(5, drawed);
		prep.setInt(6, year);
	
		
		prep.executeUpdate();
		response.getWriter().write(respo);
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		LOGGER.error("Error Posting Cricket stats");
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		LOGGER.error("Error Posting Cricket stats");
		e.printStackTrace();
	}
	    LOGGER.info("Posting Cricket stats");
	}

	private static void post_football(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		 String respo = "Success Fully Submitted";
		    int team_id= Integer.parseInt(request.getParameter("fteam_id"));
		    int n_goals= Integer.parseInt(request.getParameter("fn_goals"));
		    int n_won= Integer.parseInt(request.getParameter("fn_won"));
		    int n_loss = Integer.parseInt(request.getParameter("fn_loss"));
		    int n_tie = Integer.parseInt(request.getParameter("fn_tie"));
		    int year = Integer.parseInt(request.getParameter("fyear"));
		    
		    
		    
		   try {
			Connection con = DBConnection.getConnection();
			String query = "insert into footballstats(team_id,goals,n_won,n_loss,n_tie,year) values(?,?,?,?,?,?)";
			PreparedStatement prep = con.prepareStatement(query);
			prep.setInt(1,team_id);
			prep.setInt(2,n_goals);
			prep.setInt(3, n_won);
			prep.setInt(4, n_loss);
			prep.setInt(5, n_tie);
			prep.setInt(6, year);
		
			
			prep.executeUpdate();
			response.getWriter().write(respo);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Posting Football stats Failed");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Posting Football stats Failed");
			e.printStackTrace();
		}
		    
		   LOGGER.info("Posting Football stats");
	}

	private static  void  post_basketball(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		 String respo = "Success Fully Submitted";
		    int team_id= Integer.parseInt(request.getParameter("bteam_id"));
		    int n_won= Integer.parseInt(request.getParameter("bn_won"));
		    int n_loss= Integer.parseInt(request.getParameter("bn_loss"));
		    int year = Integer.parseInt(request.getParameter("byear"));
		    
		    
		    
		   try {
			Connection con = DBConnection.getConnection();
			String query = "insert into basketballstats(team_id,n_won,n_loss,year) values(?,?,?,?)";
			PreparedStatement prep = con.prepareStatement(query);
			prep.setInt(1,team_id);
			prep.setInt(2,n_won);
			prep.setInt(3, n_loss);
			prep.setInt(4, year);
		
			
			prep.executeUpdate();
			response.getWriter().write(respo);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    
	}

}
