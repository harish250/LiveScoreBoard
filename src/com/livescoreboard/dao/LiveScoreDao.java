package com.livescoreboard.dao;
import com.livescoreboard.util.*;
import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.livescoreboard.model.Match;
public class LiveScoreDao {
	
	 public LiveScoreDao() {
		// TODO Auto-generated constructor stub
	}
		static final Logger LOGGER = Logger.getLogger(LiveScoreDao.class);

	 public static List<Match> getMatches(String sportype) throws ClassNotFoundException, SQLException
	 {
		 ArrayList<Match> matches = new ArrayList<Match>();
		 
		 String query = "select t1.team_name,m.first_team_score,t1.ranking,t2.team_name,m.second_team_score,t2.ranking,m.year,t1.image_url,t2.image_url from matches m,team t1,team t2 where m.sportstype=? and m.year = current_date() and m.first_team_id =t1.team_id and m.second_team_id = t2.team_id;";
		 
		 
		 Connection con = DBConnection.getConnection();
		 PreparedStatement stmt = con.prepareStatement(query);
		 stmt.setString(1,sportype);
		 
		 ResultSet set = stmt.executeQuery();
		 
		 while(set.next())
		 {
			 String first_team_name = set.getString(1);
			 int first_team_score = set.getInt(2);
			 int first_ranking = set.getInt(3);
        	 String second_team_name = set.getString(4);
			 int second_team_score = set.getInt(5);
			 int second_ranking = set.getInt(6);
			 String year = set.getString(7);
	         String first_image_url = set.getString(8);
	         String second_image_url =set.getString(9);
			 Match match = new Match(first_team_name,first_team_score,first_ranking,second_team_name,second_team_score,second_ranking,year,first_image_url,second_image_url);
			 matches.add(match);
		 }
		 LOGGER.info("Getting Live Matches");
		 return matches;
	 }
	 public static List<Match>  getupcomingmatches(String sportstype) throws ClassNotFoundException, SQLException
	 {
		 ArrayList<Match> upcoming = new ArrayList<Match>();
		 String query = "select t1.team_name,m.first_team_score,t1.ranking,t2.team_name,m.second_team_score,t2.ranking,m.year,t1.image_url,t2.image_url from matches m,team t1,team t2 where m.sportstype=? and m.year > current_date() and m.first_team_id =t1.team_id and m.second_team_id = t2.team_id;";
		 
		 
		 Connection con = DBConnection.getConnection();
		 PreparedStatement stmt = con.prepareStatement(query);
		 stmt.setString(1,sportstype);
		 
		 ResultSet set = stmt.executeQuery();
		 
		 while(set.next())
		 {
			 String first_team_name = set.getString(1);
			 int first_team_score = set.getInt(2);
			 int first_ranking = set.getInt(3);
        	 String second_team_name = set.getString(4);
			 int second_team_score = set.getInt(5);
			 int second_ranking = set.getInt(6);
			 String year = set.getString(7);
	         String first_image_url = set.getString(8);
	         String second_image_url =set.getString(9);
			 Match match = new Match(first_team_name,first_team_score,first_ranking,second_team_name,second_team_score,second_ranking,year,first_image_url,second_image_url);
			 upcoming.add(match);
		 }
		 
		 LOGGER.info("Getting UpComing Live Matches");
		 return upcoming;
	 }
}
