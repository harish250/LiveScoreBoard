package com.livescoreboard.dao;


import java.sql.*;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.livescoreboard.model.BasketBallStats;
import com.livescoreboard.model.CricketStats;
import com.livescoreboard.model.FootBallStats;
import com.livescoreboard.model.Match;
import com.livescoreboard.model.Player;
import com.livescoreboard.model.Team;
import com.livescoreboard.util.DBConnection;


public class AdminDao {

	static final Logger LOGGER = Logger.getLogger(AdminDao.class);

      public static boolean authenticateAdmin(String username,String password) throws ClassNotFoundException, SQLException
      {
    	  Connection con = DBConnection.getConnection();
    	  
    	  String query = "select * from admin where username=? and password=?";
    	 PreparedStatement prepStatement= con.prepareStatement(query);
    	 prepStatement.setString(1, username);
    	 prepStatement.setString(2, password);
    	  
    	 ResultSet resset=prepStatement.executeQuery();
        String tempUser = "";
        String tempPassword="";
        while(resset.next())
        {
        	tempUser = resset.getString(1);
        	tempPassword = resset.getString(2);
        }
        if(tempUser.equals(username) && password.equals(password))
        {
        	LOGGER.info("Authenticating admin");
        	return true;
        }
        return false;
    	  
      }
      public static String get_counts() throws ClassNotFoundException, SQLException
      {
    	  ArrayList<Integer> counts = new ArrayList<Integer>();
    	  Connection con = DBConnection.getConnection();
    	  String query = "select count(*) from team";
    	  Statement stmt = con.createStatement();
    	  ResultSet teams= stmt.executeQuery(query);
    	  while(teams.next())
    	  {
    		  counts.add(teams.getInt(1));
    	  }
    	  query = "select count(*) from player";
    	  ResultSet players = stmt.executeQuery(query);
    	  while(players.next())
    	  {
    		  counts.add(players.getInt(1));
    	  }
    	  query = "select count(*) from matches";
    	  ResultSet matches = stmt.executeQuery(query);
    	  while(matches.next())
    	  {
    		  counts.add(matches.getInt(1));
    	  }
    	  String json="";
  	    json = new Gson().toJson(counts);
			
  	  
    	  return json;
      }
      public static String getTeams() throws ClassNotFoundException, SQLException
      {
    	    Connection con = DBConnection.getConnection();
    	    String query = "select * from team";
    	    Statement stmt = con.createStatement();
    	    ResultSet set = stmt.executeQuery(query);
    	    ArrayList<Team> teams = new ArrayList<Team>();
    	    
    	    
    	    while(set.next())
    	    {int team_id = set.getInt(1);
			String team_name = set.getString(2);
			String sporttype=set.getString(3);
			int ranking = set.getInt(4);
			String coach_name = set.getString(5);
			String established = set.getString(6);
			String image_url = set.getString(7);
			
			Team team = new Team(team_id,team_name,sporttype,ranking,coach_name,established,image_url);
			
			teams.add(team);
    	    }
    	    String json="";
    	    json = new Gson().toJson(teams);
			LOGGER.info("Getting Teams Data");
    	    	return json;	
      }
      
      public static String getPlayers() throws ClassNotFoundException, SQLException
      {
    	    Connection con = DBConnection.getConnection();
    	    String query = "select * from player";
    	    Statement stmt = con.createStatement();
    	    ResultSet set = stmt.executeQuery(query);
    	    ArrayList<Player> teams = new ArrayList<Player>();
    	    
    	    
    	    while(set.next())
    	    {
    	    int player_id = set.getInt(1);
			String player_name = set.getString(2);
			String sporttype=set.getString(3);
			int team_id = set.getInt(4);
			int age= set.getInt(5);
			String image_url= set.getString(6);
			String description = set.getString(7);
			
			Player team = new Player(player_id,player_name,sporttype,team_id,age,description,image_url);
			
			teams.add(team);
    	    }
    	    String json="";
    	    json = new Gson().toJson(teams);
			LOGGER.info("Getting Players Data");
    	    	return json;	
      }
	public static String getMatches() throws SQLException, ClassNotFoundException {
		Connection con = DBConnection.getConnection();
	    String query = "select * from matches";
	    Statement stmt = con.createStatement();
	    ResultSet set = stmt.executeQuery(query);
	    ArrayList<Match> matches = new ArrayList<Match>();
	    
	    
	    while(set.next())
	    {
	    int match_id = set.getInt(1);
		int  first_team_id =  set.getInt(2);
		int second_team_id=set.getInt(3);
		int first_team_score= set.getInt(4);
		int second_team_score= set.getInt(5);
		String date= set.getString(6);
		String sportstype = set.getString(7);
		
		Match team = new Match(match_id,first_team_id,second_team_id,first_team_score,second_team_score,date,sportstype);
		
		matches.add(team);
	    }
	    String json="";
	    json = new Gson().toJson(matches);
		LOGGER.info("Getting matches data");
	    	return json;	
	}
	public static String get_basketball_stats() throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
	    String query = "select * from basketballstats";
	    Statement stmt = con.createStatement();
	    ResultSet set = stmt.executeQuery(query);
	    ArrayList<BasketBallStats> matches = new ArrayList<BasketBallStats>();
	    
	    
	    while(set.next())
	    {
	    int team_id = set.getInt(1);
		int  n_won=  set.getInt(2);
		int n_loss=set.getInt(3);
		int year= set.getInt(4);
		
		
		BasketBallStats basketballstats= new BasketBallStats(team_id,n_won,n_loss,String.valueOf(year));
		
		matches.add(basketballstats);
	    }
	    String json="";
	    json = new Gson().toJson(matches);
		LOGGER.info("Getting BasketBall Stats");
	    	return json;	
	}
	public static String get_cricket_stats() throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
	    String query = "select * from cricketstats";
	    Statement stmt = con.createStatement();
	    ResultSet set = stmt.executeQuery(query);
	    ArrayList<CricketStats> matches = new ArrayList<CricketStats>();
	    
	    
	    while(set.next())
	    {
	    int team_id = set.getInt(1);
		int  n_odi=  set.getInt(2);
		int n_t20=set.getInt(3);
		int n_test= set.getInt(4);
		int draws = set.getInt(5);
		int year = set.getInt(6);
		
		
		CricketStats basketballstats= new CricketStats(team_id,n_odi,n_t20,n_test,draws,String.valueOf(year));
		
		matches.add(basketballstats);
	    }
	    String json="";
	    json = new Gson().toJson(matches);
		
	    LOGGER.info("Getting Cricket Stats");
	    	return json;
	}
	public static String get_football_stats() throws ClassNotFoundException, SQLException {
		
		Connection con = DBConnection.getConnection();
	    String query = "select * from footballstats";
	    Statement stmt = con.createStatement();
	    ResultSet set = stmt.executeQuery(query);
	    ArrayList<FootBallStats> football = new ArrayList<FootBallStats>();
	    
	    
	    while(set.next())
	    {
	    int team_id = set.getInt(1);
		int  goals=  set.getInt(2);
		int n_won=set.getInt(3);
		int n_loss= set.getInt(4);
		int n_tie=set.getInt(5);
		int year = set.getInt(6);
		
		FootBallStats footballstats= new FootBallStats(team_id,goals,n_won,n_loss,n_tie,String.valueOf(year));
		
		football.add(footballstats);
	    }
	    String json="";
	    json = new Gson().toJson(football);
		
	    LOGGER.info("Getting Football Stats");
	    	return json;	
	}
	
	
      
}


