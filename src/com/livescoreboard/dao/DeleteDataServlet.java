package com.livescoreboard.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.livescoreboard.util.DBConnection;

/**
 * Servlet implementation class DeleteDataServlet
 */
@WebServlet("/DeleteDataServlet")
public class DeleteDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger LOGGER = Logger.getLogger(DeleteDataServlet.class);

    /**
     * @see HttpServlet#HttpServlet()
     */	
    public DeleteDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type=request.getParameter("type");
		
		switch(type)
		{
		case "team":
			String id=request.getParameter("id");
			try {
				String s=delete_team(id);
				response.getWriter().write(s);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				LOGGER.error("Exception ocurred deleting teams");
			}
			break;
		case "player":
			String player_id=request.getParameter("id");
			try {
				String res = delete_player(player_id);
				response.getWriter().write(res);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				LOGGER.error("Exception ocurred deleting player");
			}
			
			break;
		case "matches":
			String match_id = request.getParameter("id");
			try {
				String match_resp = delete_match(match_id);
				response.getWriter().write(match_resp);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				LOGGER.error("Exception ocurred deleting matches");
				e.printStackTrace();
			}
			
			break;
		case "stats":
			String sportstype=request.getParameter("sports_type");
			String stats_id = request.getParameter("id");
			String year = request.getParameter("year");
			try {
				delete_stats(request,response,sportstype,stats_id,year);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				LOGGER.error("Exception ocurred deleting stats");
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}

	public static String delete_team(String id) throws ClassNotFoundException, SQLException
	{
		Connection con = DBConnection.getConnection();
		String query="delete from team where team_id=?";
		PreparedStatement prep = con.prepareStatement(query);
		prep.setString(1, id);
		int n =prep.executeUpdate();
		con.close();
		return n==0? "Not SuccessFull":"SuccessFull";
	}
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public static String delete_player(String id) throws SQLException, ClassNotFoundException
	{
		Connection con = DBConnection.getConnection();
		String query="delete from player where player_id=?";
		PreparedStatement prep = con.prepareStatement(query);
		prep.setString(1, id);
		int n =prep.executeUpdate();
		con.close();
		return n==0? "Not SuccessFull":"SuccessFull";
		
	}
	public static String delete_match(String id) throws SQLException, ClassNotFoundException
	{
		Connection con = DBConnection.getConnection();
		String query="delete from matches where match_id=?";
		PreparedStatement prep = con.prepareStatement(query);
		prep.setString(1, id);
		int n =prep.executeUpdate();
		con.close();
		return n==0? "Not SuccessFull":"SuccessFull";
	}
	public static void delete_stats(HttpServletRequest request,HttpServletResponse response,String sports_type,String id,String year) throws ClassNotFoundException, SQLException
	{
		switch(sports_type)
		{
		case "basketball":
			String bres = delete_basketball_stats(id,year);
			try {
				response.getWriter().write(bres);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				LOGGER.error("Exception ocurred deleting basketball stats");
				e.printStackTrace();
			}
			break;
		case "football":
			String fres = delete_football_stats(id,year);
			try {
				response.getWriter().write(fres);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				LOGGER.error("Exception ocurred deleting football stats");
				e.printStackTrace();
			}
			break;
		case "cricket":
			String cres = delete_cricket_stats(id,year);
			try {
				response.getWriter().write(cres);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				LOGGER.error("Exception ocurred deleting cricket stats");
				e.printStackTrace();
			}
			
			break;
		default:
			break;
			
		}
	}
	public static String delete_basketball_stats(String id,String year) throws SQLException, ClassNotFoundException
	{
		Connection con = DBConnection.getConnection();
		String query="delete from basketballstats where team_id=? and year=?";
		PreparedStatement prep = con.prepareStatement(query);
		prep.setString(1, id.charAt(0)+"");
		prep.setString(2,year);
		
		int n = prep.executeUpdate();
		System.out.println(id+" "+year);
		con.close();
		return n==0? "Not successfull":"successfull";
			
	}
	
	public static String  delete_football_stats(String id,String year) throws ClassNotFoundException, SQLException
	{
		Connection con = DBConnection.getConnection();
		String query="delete from footballstats where team_id=? and year=?";
		PreparedStatement prep = con.prepareStatement(query);
		prep.setString(1, id.charAt(0)+"");
		prep.setString(2,year);
		
		
		int n = prep.executeUpdate();
		con.close();
		return n==0?"Not successfull":"successfull";
		
	}
	public static String delete_cricket_stats(String id,String year) throws ClassNotFoundException, SQLException
	{
		Connection con = DBConnection.getConnection();
		String query="delete from cricketstats where team_id=? and year=?";
		PreparedStatement prep = con.prepareStatement(query);
		prep.setString(1, id.charAt(0)+"");
		prep.setString(2,year);
		
		int n = prep.executeUpdate();
		con.close();
		return n==0?"Not successfull":"successfull";
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
