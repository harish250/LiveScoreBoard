package com.livescoreboard.model;

public class CricketStats {
	private int team_id;
	private String team_name;
	private int number_odi;
	private int number_test;
	private int number_t20;
	private int draws;
	private String year;
	
	public CricketStats(int team_id, String team_name, int number_odi, int number_test, int number_t20, int draws,
			String year) {
		super();
		this.team_id = team_id;
		this.team_name = team_name;
		this.number_odi = number_odi;
		this.number_test = number_test;
		this.number_t20 = number_t20;
		this.draws = draws;
		this.year = year;
	}

	public CricketStats(int team_id2, int n_odi, int n_t20, int n_test, int draws2, String valueOf) {
		// TODO Auto-generated constructor stub
		this.team_id=team_id2;
		this.number_odi=n_odi;
		this.number_t20=n_t20;
		this.draws=draws2;
		this.year=valueOf;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	
	
	public int getTeam_id() {
		return team_id;
	}




	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}




	public int getNumber_odi() {
		return number_odi;
	}




	public void setNumber_odi(int number_odi) {
		this.number_odi = number_odi;
	}




	public int getNumber_test() {
		return number_test;
	}




	public void setNumber_test(int number_test) {
		this.number_test = number_test;
	}




	public int getNumber_t20() {
		return number_t20;
	}




	public void setNumber_t20(int number_t20) {
		this.number_t20 = number_t20;
	}




	public int getDraws() {
		return draws;
	}




	public void setDraws(int draws) {
		this.draws = draws;
	}




	public String getYear() {
		return year;
	}




	public void setYear(String year) {
		this.year = year;
	}




	@Override
	public String toString() {
		return "CricketStats [team_id=" + team_id + ", number_odi=" + number_odi + ", number_test=" + number_test
				+ ", number_t20=" + number_t20 + ", draws=" + draws + ", year=" + year + "]";
	}
	

}
