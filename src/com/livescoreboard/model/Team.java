package com.livescoreboard.model;

public class Team {
	private int team_id;
	private String team_name;
	private String sportstype;
	private int ranking;
	private String coach_name;
	private String established_year;
	private String image_url;
	
	public Team(int team_id, String team_name, String sportstype, int ranking, String coach_name, String established_year,
			String image_url) {
		super();
		this.team_id = team_id;
		this.team_name = team_name;
		this.sportstype = sportstype;
		this.ranking = ranking;
		this.coach_name = coach_name;
		this.established_year = established_year;
		this.image_url = image_url;
	}
	
	
	public int getTeam_id() {
		return team_id;
	}


	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}


	public String getTeam_name() {
		return team_name;
	}


	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}


	public String getSportstype() {
		return sportstype;
	}


	public void setSportstype(String sportstype) {
		this.sportstype = sportstype;
	}


	public int getRanking() {
		return ranking;
	}


	public void setRanking(int ranking) {
		this.ranking = ranking;
	}


	public String getCoach_name() {
		return coach_name;
	}


	public void setCoach_name(String coach_name) {
		this.coach_name = coach_name;
	}


	public String getEstablished_year() {
		return established_year;
	}


	public void setEstablished_year(String established_year) {
		this.established_year = established_year;
	}


	public String getImage_url() {
		return image_url;
	}


	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}


	@Override
	public String toString() {
		return "Team [team_id=" + team_id + ", team_name=" + team_name + ", sportstype=" + sportstype + ", ranking="
				+ ranking + ", coach_name=" + coach_name + ", established_year=" + established_year + ", image_url="
				+ image_url + "]";
	}
}
