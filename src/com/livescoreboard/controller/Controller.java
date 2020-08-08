package com.livescoreboard.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.livescoreboard.dao.*;
import com.livescoreboard.model.Match;
import com.livescoreboard.model.Player;
import com.livescoreboard.model.Team;
import com.livescoreboard.util.DBConnection;
/**
 * Servlet implementation class Controller
 */
@MultipartConfig(fileSizeThreshold=1024*1024*2, 
maxFileSize=1024*1024*10, 
maxRequestSize=1024*1024*50)
public class Controller extends HttpServlet{
	private static final long serialVersionUID = 1L;
     private RequestDispatcher requestDispatcher;
    /**
     * @see HttpServlet#HttpServlet()
     */
 	static final Logger LOGGER = Logger.getLogger(Controller.class);

    public Controller() {
        super();
        // TODO Auto-generated constructor stub

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		String sportstype = request.getParameter("sport");
		
		
		switch(action)
		{
		case"live_score":
			requestDispatcher = request.getRequestDispatcher("/LiveSports.jsp");
			List<Match> match;
			List<Match> upcomingmatches;
			try {
				match = LiveScoreDao.getMatches(sportstype);
				upcomingmatches = LiveScoreDao.getupcomingmatches(sportstype);
				System.out.println(match);
				request.setAttribute("matches", match);
				request.setAttribute("upcoming", upcomingmatches);
				requestDispatcher.forward(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				LOGGER.error("Error Occured Due to Live Score");
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LOGGER.error("Error Occured Due to Live Score");
				e.printStackTrace();
			}
			 
			break;
		case "statistics":
			requestDispatcher = request.getRequestDispatcher("/StatisticsDao");
			requestDispatcher.forward(request, response);
			break;
		case "playersInfo":
			requestDispatcher = request.getRequestDispatcher("/Teams.jsp");
			try {
				ArrayList<Team> teams = PlayersInfoDao.getTeams(sportstype);
				request.setAttribute("teams", teams);
				requestDispatcher.forward(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				LOGGER.error("Error Occured Due to Players Information");
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		case "admin_login":
			requestDispatcher = request.getRequestDispatcher("/LoginServlet");
			requestDispatcher.forward(request, response);
			break;
		case "admin_teams":
			requestDispatcher = request.getRequestDispatcher("/AdminTeams.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "admin_players":
			requestDispatcher = request.getRequestDispatcher("/AdminPlayers.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "admin_stats":
			requestDispatcher = request.getRequestDispatcher("/AdminStats.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "admin_matches":
			requestDispatcher = request.getRequestDispatcher("/AdminMatches.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "log_out":
			requestDispatcher = request.getRequestDispatcher("/LogOutServlet");
			requestDispatcher.forward(request, response);
			break;
		case "get_teams":
			String json;
			try {
				json = AdminDao.getTeams();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				LOGGER.error("Error Due to Retrival of Teams Info");
				e.printStackTrace();
			}
			break;
		case "get_players":
			String data;
			try {
				data= AdminDao.getPlayers();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(data);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				LOGGER.error("Error Due to Retrival of Players Info");
				e.printStackTrace();
			}
			break;
		case "get_matches":
			String matches="";
			
			try {
				matches = AdminDao.getMatches();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(matches);
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				LOGGER.error("Error Due to Retrival of Matches Info");
				e.printStackTrace();
			}
			break;
		case "get_counts":
			String counts="";
			try {
				counts = AdminDao.get_counts();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(counts);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				LOGGER.error("Error Due to Retrival of Getting Counts");
				e.printStackTrace();
			}
			break;
		case "get_stats_basketball":
			String stats_basketball="";
			try {
				stats_basketball = AdminDao.get_basketball_stats();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(stats_basketball);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				LOGGER.error("Error Due to Retrival of Getting basketball stats");
				e.printStackTrace();
			}
			break;
		case "get_stats_cricket":
			String stats_cricket="";
			try {
				stats_cricket = AdminDao.get_cricket_stats();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(stats_cricket);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				LOGGER.error("Error Due to Retrival of Getting Cricket stats");
			}
			break;
		case "get_stats_football":
			String stats_football="";
			try {
				stats_football= AdminDao.get_football_stats();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(stats_football);
			} 
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				LOGGER.error("Error Due to Retrival of Getting Football stats");
				e.printStackTrace();
			}
			break;
		case "post_teams_data":
			requestDispatcher = request.getRequestDispatcher("/PostTeamServlet");
			requestDispatcher.forward(request, response);
			break;	
		case "post_players_data":
			requestDispatcher = request.getRequestDispatcher("/PostPlayerServlet");
			requestDispatcher.forward(request, response);
			break;
		case "post_matches_data":
			requestDispatcher = request.getRequestDispatcher("/PostMatchServlet");
			requestDispatcher.forward(request, response);
			break;
		case "post_stats_data":
			requestDispatcher = request.getRequestDispatcher("/PostStatisticsServlet");
			requestDispatcher.forward(request, response);
			break;
		case "delete_operation":
			requestDispatcher = request.getRequestDispatcher("/Delete DataServlet");
			requestDispatcher.forward(request, response);
			break;
		default:
			LOGGER.fatal("Not Accessible Page");
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
