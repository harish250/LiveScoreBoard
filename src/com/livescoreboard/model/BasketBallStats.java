package com.livescoreboard.model;

public class BasketBallStats {
	private int team_id;
	private String team_name;
	private int number_loss;
	private int number_won;
	private String year;
	
	
	public BasketBallStats(int team_id, String team_name, int number_loss, int number_won, String year) {
		super();
		this.team_id = team_id;
		this.team_name = team_name;
		this.number_loss = number_loss;
		this.number_won = number_won;
		this.year = year;
	}

	public BasketBallStats(int team_id2, int n_won, int n_loss, String year2) {
		this.team_id=team_id2;
		this.number_won=n_won;
		this.number_loss=n_loss;
		this.year=year2;
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

	public int getNumber_loss() {
		return number_loss;
	}

	public void setNumber_loss(int number_loss) {
		this.number_loss = number_loss;
	}

	public int getNumber_won() {
		return number_won;
	}

	public void setNumber_won(int number_won) {
		this.number_won = number_won;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "BasketBallStats [team_id=" + team_id + ", number_loss=" + number_loss + ", number_won=" + number_won
				+ ", year=" + year + "]";
	}
	
    
}
