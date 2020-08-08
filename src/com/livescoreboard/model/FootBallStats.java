package com.livescoreboard.model;

public class FootBallStats {
    private int team_id;
    private String team_name;
    private int number_goals;
    private int number_won;
    private int number_loss;
    private int number_tie;
    private String year;
    
    
	public FootBallStats(int team_id, String team_name, int number_goals, int number_won, int number_loss,
			int number_tie, String year) {
		super();
		this.team_id = team_id;
		this.team_name = team_name;
		this.number_goals = number_goals;
		this.number_won = number_won;
		this.number_loss = number_loss;
		this.number_tie = number_tie;
		this.year = year;
	}







	public FootBallStats(int team_id2, int goals, int n_won, int n_loss, int n_tie, String year2) {
		// TODO Auto-generated constructor stub
		this.team_id=team_id2;
		this.number_goals=goals;
		this.number_won=n_won;
		this.number_loss=n_loss;
		this.number_tie=n_tie;
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







	public int getNumber_goals() {
		return number_goals;
	}







	public void setNumber_goals(int number_goals) {
		this.number_goals = number_goals;
	}







	public int getNumber_won() {
		return number_won;
	}







	public void setNumber_won(int number_won) {
		this.number_won = number_won;
	}







	public int getNumber_loss() {
		return number_loss;
	}







	public void setNumber_loss(int number_loss) {
		this.number_loss = number_loss;
	}







	public int getNumber_tie() {
		return number_tie;
	}







	public void setNumber_tie(int number_tie) {
		this.number_tie = number_tie;
	}







	public String getYear() {
		return year;
	}







	public void setYear(String year) {
		this.year = year;
	}







	@Override
	public String toString() {
		return "FootBallStats [team_id=" + team_id + ", number_goals=" + number_goals + ", number_won=" + number_won
				+ ", number_loss=" + number_loss + ", number_tie=" + number_tie + ", year=" + year + "]";
	}
    
    
    
    
}
