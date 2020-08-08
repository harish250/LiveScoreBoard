package com.livescoreboard.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.livescoreboard.model.*;
import com.livescoreboard.util.DBConnection;
import com.google.gson.Gson;
/**
 * Servlet implementation class StatisticsDao
 */
@WebServlet("/StatisticsDao")
public class StatisticsDao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger LOGGER = Logger.getLogger(StatisticsDao.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatisticsDao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String sportstype = request.getParameter("sportstype");
		String json="";
		switch(sportstype)
		{
		case "BasketBall":
			ArrayList<ArrayList<BasketBallStats>> basketballstats;
			try {
				basketballstats = getBasketBallStats("basketballstats");
				json = new Gson().toJson(basketballstats);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				LOGGER.error("Cannot show Basketball stats");
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LOGGER.error("Cannot show Basketball stats");
				e.printStackTrace();
			}
		    break;
		case "FootBall":
			ArrayList<ArrayList<FootBallStats>> footballstats;
			try {
				footballstats = getFootBallStats("footballstats");
				json = new Gson().toJson(footballstats);
				response.setContentType("application/json");
				response.getWriter().write(json);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				LOGGER.error("Cannot show Football stats");
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				LOGGER.error("Cannot show Football stats");
				e1.printStackTrace();
			}
			break;
		case "Cricket":
			ArrayList<ArrayList<CricketStats>> cricketstats;
			try {
				cricketstats = getCricketStats("cricketstats");
				json = new Gson().toJson(cricketstats);
				response.setContentType("application/json");
				response.getWriter().write(json);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				LOGGER.error("Cannot show Cricket stats");
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LOGGER.error("Cannot show Cricket stats");
				e.printStackTrace();
			}
			break;
		default:
			LOGGER.error("Wrong  Options stats");
               break;			
			
			
		}
		
	}

	private ArrayList<ArrayList<CricketStats>> getCricketStats(String string) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<CricketStats>> cricketstats = new ArrayList<ArrayList<CricketStats>>();
		
		Connection con = DBConnection.getConnection();
		
		String query = "select c.team_id,t.team_name,c.n_odi,c.n_t20,c.n_test,c.draws,c.year from cricketstats c,team t where c.team_id=t.team_id;";
		Statement stmt = con.createStatement();
		ResultSet resSet = stmt.executeQuery(query);
		HashMap<Integer,ArrayList<CricketStats>> hashmap = new HashMap<Integer,ArrayList<CricketStats>>();
		
		while(resSet.next())	
		{
			int team_id = resSet.getInt(1);
			String team_name = resSet.getString(2);
			int n_odi = resSet.getInt(3);
			int n_t20 = resSet.getInt(4);
			int n_test = resSet.getInt(5);
			int n_draws = resSet.getInt(6);
			String year = resSet.getString(7);
			
			CricketStats cs = new CricketStats(team_id, team_name, n_odi, n_test, n_t20, n_draws, year);
			if(!hashmap.containsKey(team_id))
			{
				ArrayList<CricketStats> al = new ArrayList<CricketStats>();
				al.add(cs);
				hashmap.put(team_id,al);
			}
			else
			{
				ArrayList<CricketStats> temp = hashmap.get(team_id);
				temp.add(cs);
				hashmap.put(team_id,temp);
			}
		}
		for(Map.Entry elements: hashmap.entrySet())
		{
			cricketstats.add((ArrayList<CricketStats>)elements.getValue());
		}
		LOGGER.info("Cricket Stats Retrived");
		return cricketstats;
	}

	public ArrayList<ArrayList<BasketBallStats>> getBasketBallStats(String table) throws ClassNotFoundException, SQLException {
		
		ArrayList<ArrayList<BasketBallStats>> basketballstats = new ArrayList<ArrayList<BasketBallStats>>();
		HashMap<Integer,ArrayList<BasketBallStats>> hashmap = new HashMap<Integer,ArrayList<BasketBallStats>>();
		Connection con = DBConnection.getConnection();
		
		String query = "select s.team_id,t.team_name,s.n_won,s.n_loss,s.year from basketballstats s,team t where s.team_id=t.team_id;";
		Statement stmt = con.createStatement();
		ResultSet resSet = stmt.executeQuery(query);
		
		while(resSet.next())
		{
			int team_id = resSet.getInt(1);
			String team_name = resSet.getString(2);
			int n_won = resSet.getInt(3);
			int n_loss = resSet.getInt(4);
			String year = resSet.getString(5);
			
			BasketBallStats bs = new BasketBallStats(team_id, team_name, n_loss, n_won, year);
			
			if(!hashmap.containsKey(team_id))
			{
			      ArrayList<BasketBallStats> al = new ArrayList<BasketBallStats>();
			      al.add(bs);
			      hashmap.put(team_id,al);
			}
			else
			{
				ArrayList<BasketBallStats> temp = hashmap.get(team_id);
				temp.add(bs);
				hashmap.put(team_id, temp);
			}
		}
		for(Map.Entry elements: hashmap.entrySet())
		{
			basketballstats.add((ArrayList<BasketBallStats>) elements.getValue());
		}
		
		
		LOGGER.info("Basketball Stats Retrived");
		return basketballstats;
	}

	public ArrayList<ArrayList<FootBallStats>> getFootBallStats(String table) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<FootBallStats>> footballstats = new ArrayList<ArrayList<FootBallStats>>();
		HashMap<Integer,ArrayList<FootBallStats>> hashmap = new HashMap<Integer,ArrayList<FootBallStats>>();

		Connection con = DBConnection.getConnection();
		
		String query = "select f.team_id,t.team_name,f.goals,f.n_won,f.n_loss,f.n_tie,f.year from footballstats f,team t where t.team_id=f.team_id;";
		Statement stmt = con.createStatement();
		ResultSet resSet = stmt.executeQuery(query);
		
		while(resSet.next())
		{
			int team_id = resSet.getInt(1);
			String team_name  = resSet.getString(2);
			int n_goals = resSet.getInt(3);
			int n_won = resSet.getInt(4);
			int n_loss = resSet.getInt(5);
			int n_ties = resSet.getInt(6);
			String year = resSet.getString(7);
			
			FootBallStats fs = new FootBallStats(team_id, team_name, n_goals, n_won, n_loss, n_ties, year);
			if(!hashmap.containsKey(team_id))
			{
				ArrayList<FootBallStats> al = new ArrayList<FootBallStats>();
				al.add(fs);
				hashmap.put(team_id,al);
			}
			else
			{
				ArrayList<FootBallStats> temp = hashmap.get(team_id);
				temp.add(fs);
			    hashmap.put(team_id,temp);
			}
			
		
		}
		
		for(Map.Entry elements:hashmap.entrySet())
		{
			footballstats.add((ArrayList<FootBallStats>) elements.getValue());
		}
		LOGGER.info("Football Stats Retrived");
		return footballstats;
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
