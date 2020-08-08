package com.livescoreboard.model;

public class Match {
	private int match_id;
	private int first_team_id;
	private int second_team_id;
	public int getMatch_id() {
		return match_id;
	}
	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}
	public int getFirst_team_id() {
		return first_team_id;
	}
	public void setFirst_team_id(int first_team_id) {
		this.first_team_id = first_team_id;
	}
	public int getSecond_team_id() {
		return second_team_id;
	}
	public void setSecond_team_id(int second_team_id) {
		this.second_team_id = second_team_id;
	}
	public String getSportstype() {
		return sportstype;
	}
	public void setSportstype(String sportstype) {
		this.sportstype = sportstype;
	}
	public void setFirst_team_image_url(String first_team_image_url) {
		this.first_team_image_url = first_team_image_url;
	}
	public void setSecond_team_image_url(String second_team_image_url) {
		this.second_team_image_url = second_team_image_url;
	}

	private String sportstype;
	private String first_team_name;
	private String second_team_name;
	private int first_team_score;
	private int second_team_score;
	private String year;
	private String date;
	private int first_ranking;
	private int second_ranking;
	private String first_team_image_url;
	private String second_team_image_url;
	public Match(String first_team_name,int first_team_score,int first_team_ranking,String second_team_name,int second_team_score,int second_team_ranking,String year,String first_image_url,String second_image_url)
	{
		this.first_team_name=first_team_name;
		this.second_team_name =second_team_name;
		this.first_team_score=first_team_score;
		this.second_team_score = second_team_score;
		this.first_ranking=first_team_ranking;
		this.second_ranking=second_team_ranking;
		this.year=year;
		this.first_team_image_url = first_image_url;
		this.second_team_image_url = second_image_url;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Match(int match_id, int first_team_id, int second_team_id, int first_team_score2, int second_team_score2,
			String date, String sportstype) {
		this.match_id=match_id;
		this.first_team_id=first_team_id;
		this.second_team_id=second_team_id;
		this.first_team_score=first_team_score2;
		this.second_team_score=second_team_score2;
		this.date=date;
		this.sportstype=sportstype;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Match [first_team_name=" + first_team_name + ", second_team_name=" + second_team_name
				+ ", first_team_score=" + first_team_score + ", second_team_score=" + second_team_score + ", year="
				+ year + ", first_ranking=" + first_ranking + ", second_ranking=" + second_ranking + "]";
	}
	
	public String getFirst_team_name() {
		return first_team_name;
	}
	public String getFirst_team_image_url()
	{
		return first_team_image_url;
	}
	public String getSecond_team_image_url()
	{
		return second_team_image_url;
	}
	
	public void setFirst_team_name(String first_team_name) {
		this.first_team_name = first_team_name;
	}
	
	public String getSecond_team_name() {
		return second_team_name;
	}
	
	public void setSecond_team_name(String second_team_name) {
		this.second_team_name = second_team_name;
	}
	
	public int getFirst_team_score() {
		return first_team_score;
	}
	
	public void setFirst_team_score(int first_team_score) {
		this.first_team_score = first_team_score;
	}
	
	public int getSecond_team_score() {
		return second_team_score;
	}
	
	public void setSecond_team_score(int second_team_score) {
		this.second_team_score = second_team_score;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public int getFirst_ranking() {
		return first_ranking;
	}
	
	public void setFirst_ranking(int first_ranking) {
		this.first_ranking = first_ranking;
	}
	
	public int getSecond_ranking() {
		return second_ranking;
	}
	
	public void setSecond_ranking(int second_ranking) {
		this.second_ranking = second_ranking;
	}
	
	
	
	
	
	
}
