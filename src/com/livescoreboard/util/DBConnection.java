package com.livescoreboard.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.mysql.jdbc.*;

public class DBConnection {
	
	static final Logger LOGGER = Logger.getLogger(DBConnection.class);
	      public DBConnection() {
			// TODO Auto-generated constructor stub
	    	  
		}
	      public static Connection getConnection() throws ClassNotFoundException, SQLException
	      {
	    	  Class.forName("com.mysql.jdbc.Driver");
	    	  Connection con=null;
	    	  try {	    		  
	    		  con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/livetournament?characterEncoding=utf8","root","admin");
	    		  LOGGER.info("Connected SuccessFully to Database");
	    	  }
	    	  catch (Exception e) {
				LOGGER.error("Error While Connecting Database");
			}
	    	  return con;
	      }
}
