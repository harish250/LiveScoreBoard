package com.livescoreboard.dao;
import com.livescoreboard.model.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.livescoreboard.model.Player;
import com.livescoreboard.util.*;


public class PlayersInfoDao {
	
	static final Logger LOGGER = Logger.getLogger(PlayersInfoDao.class);

	public static ArrayList<Team> getTeams(String sportstype) throws ClassNotFoundException, SQLException
	{
		Connection con = DBConnection.getConnection();
		ArrayList<Team> teams = new ArrayList<Team>();
		String query = "select * from team where sportstype=?";
		
		PreparedStatement prepStatement =  con.prepareStatement(query);
		prepStatement.setString(1, sportstype);
		ResultSet set = prepStatement.executeQuery();
		
		while(set.next())
		{
			int team_id = set.getInt(1);
			String team_name = set.getString(2);
			String sporttype=set.getString(3);
			int ranking = set.getInt(4);
			String coach_name = set.getString(5);
			String established = set.getString(6);
			String image_url = set.getString(7);
			
			Team team = new Team(team_id,team_name,sporttype,ranking,coach_name,established,image_url);
			
			teams.add(team);
		
		}
		
		con.close();
		LOGGER.info("Getting Teams");
		return teams;
		
	}
	
	public static ArrayList<Player> getPlayers(int team_id,String sportstype) throws ClassNotFoundException, SQLException
	{
		
		Connection con = DBConnection.getConnection();
		ArrayList<Player> players = new ArrayList<Player>();
		
		String query = "select * from player where team_id=? and sportstype=?";
		
		PreparedStatement prepStatement = con.prepareStatement(query);
		prepStatement.setInt(1, team_id);
		prepStatement.setString(2, sportstype);
		
		ResultSet resultSet = prepStatement.executeQuery();
		
		while(resultSet.next())
		{
			int player_id = resultSet.getInt(1);
			String player_name= resultSet.getString(2);
			String sporttype = resultSet.getString(3);
			int id = resultSet.getInt(4);
			int age = resultSet.getInt(5);
			String image_url= resultSet.getString(6);
			String desc = resultSet.getString(7);
			
			Player player = new Player(player_id,player_name,sportstype,id,age,desc,image_url);
			
			players.add(player);
			
		}
		
		
		
		con.close();
		LOGGER.info("Getting Players");
		
		return players;
		
	}


}
