package com.livescoreboard.model;

public class Player {
      private int player_id;
      private String player_name;
      private String sportstype;
      private int team_id;
      private int age;
      private String description;
      private String image_url;
      
      
	
      
      
      
      
    public Player(int player_id, String player_name, String sportstype, int team_id, int age, String description,
			String image_url) {
		super();
		this.player_id = player_id;
		this.player_name = player_name;
		this.sportstype = sportstype;
		this.team_id = team_id;
		this.age = age;
		this.description = description;
		this.image_url = image_url;
	}





	@Override
	public String toString() {
		return "Player [player_id=" + player_id + ", player_name=" + player_name + ", sportstype=" + sportstype
				+ ", team_id=" + team_id + ", age=" + age + ", description=" + description + ", image_url=" + image_url
				+ "]";
	}





	public int getPlayer_id() {
		return player_id;
	}





	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}





	public String getPlayer_name() {
		return player_name;
	}





	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}





	public String getSportstype() {
		return sportstype;
	}





	public void setSportstype(String sportstype) {
		this.sportstype = sportstype;
	}





	public int getTeam_id() {
		return team_id;
	}





	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}





	public int getAge() {
		return age;
	}





	public void setAge(int age) {
		this.age = age;
	}





	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}





	





	public String getImage_url() {
		return image_url;
	}





	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
      
}
