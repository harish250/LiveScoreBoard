function checkForAdmin()
{
	var form = document.getElementById("form-group");
	
	$.ajax({
		type: "post",
		url:"controller?action=admin_login",
		data:$("#form-group").serialize(),
		success:function(response)
		{
			replyFromServer(response);
		}
	});
}
function replyFromServer(response)
{
     if(response != "false")
    	 {
    	    window.location.href=response;  	
    	 }
     else
    	 {
    	 var alert_msg=document.getElementById("alert-msg").classList.remove("d-none");
    	 
    	 }
     
}

function setup(options)
{
	switch(options)
	{
	case "get_teams":
		get_teams(options);
		break;
	case "get_players":
		get_players(options);
		break;
	case "get_matches":
		get_matches(options);
		break;
	case "get_counts":
		get_counts(options);
		break;
	case "get_stats":
		get_stats(options);
		break;
	default:
		console.log("wrong option");
	    break;
	}
}

function get_stats(options)
{
	$.get(`controller?action=${options}_basketball`,function(data,status)
	   		 {
	   	          create_basketball_table(data);
		      console.log(data);
	   		 });
	$.get(`controller?action=${options}_cricket`,function(data,status)
	   		 {
	   	          create_cricket_table(data);
		console.log(data);
	   		 });
	$.get(`controller?action=${options}_football`,function(data,status)
	   		 {
	   	          create_football_table(data);
		console.log(data);
	   		 });
}

function post_players_data()
{
	var form =document.getElementById("player-form");
	$.ajax({
		type: "post",
		url:"controller?action=post_players_data",
		encType : "multipart/form-data",
		contentType :false,
        cache : false,
        processData : false,
		data:new FormData(form),
		success:function(response)
		{
			if(response.length>0)
				{
				$("#players-success-msg").text(response);
				 $("#players-success-msg").removeClass("d-none");
				}
			else
				{
				$("#players-failed-msg").text("Failed to Post");
				$("#players-failed-msg").removeClass("d-none");
				}
		}
	});
}

function post_matches_data()
{
	var form =document.getElementById("match-form");
	$.ajax({
		type: "post",
		url:"controller?action=post_matches_data",
		encType : "multipart/form-data",
		contentType :false,
        cache : false,
        processData : false,
		data:new FormData(form),
		success:function(response)
		{
			if(response.length>0)
				{
				$("#matches-success-msg").text(response);
				 $("#matches-success-msg").removeClass("d-none");
				}
			else
				{
				$("#matches-failed-msg").text("Failed to Post");
				$("#matches-failed-msg").removeClass("d-none");
				}
		}
	});

}
function post_basketball_data()
{
	var form =document.getElementById("basketballstats-form");
	$.ajax({
		type: "post",
		url:"controller?action=post_stats_data&type=post_stats_basketball",
		encType : "multipart/form-data",
		contentType :false,
        cache : false,
        processData : false,
		data:new FormData(form),
		success:function(response)
		{
			if(response.length>0)
				{
				$("#basketballstats-success-msg").text(response);
				 $("#basketballstats-success-msg").removeClass("d-none");
				}
			else
				{
				$("#basketballstats-failed-msg").text("Failed to Post");
				$("#basketballstats-failed-msg").removeClass("d-none");
				}
		}
	});

}
function post_cricket_data()
{
	var form =document.getElementById("cricketstats-form");
	$.ajax({
		type: "post",
		url:"controller?action=post_stats_data&type=post_stats_cricket",
		encType : "multipart/form-data",
		contentType :false,
        cache : false,
        processData : false,
		data:new FormData(form),
		success:function(response)
		{
			if(response.length>0)
				{
				$("#cricketstats-success-msg").text(response);
				 $("#cricketstats-success-msg").removeClass("d-none");
				}
			else
				{
				$("#cricketstats-failed-msg").text("Failed to Post");
				$("#cricketstats-failed-msg").removeClass("d-none");
				}
		}
	});

}


function post_football_data()
{
	var form =document.getElementById("footballstats-form");
	$.ajax({
		type: "post",
		url:"controller?action=post_stats_data&type=post_stats_football",
		encType : "multipart/form-data",
		contentType :false,
        cache : false,
        processData : false,
		data:new FormData(form),
		success:function(response)
		{
			if(response.length>0)
				{
				$("#footballstats-success-msg").text(response);
				 $("#footballstats-success-msg").removeClass("d-none");
				}
			else
				{
				$("#footballstats-failed-msg").text("Failed to Post");
				$("#footballstats-failed-msg").removeClass("d-none");
				}
		}
	});

}

function create_basketball_table(data)
{
	var tbody = document.getElementById("basketballstats-tbody");
	 var elements = (tagname)=>
	   {
		   return document.createElement(tagname);
	   }
	for(basketball in data)
		{
		       var tr = elements("tr");
		       tr.setAttribute("id",`${data[basketball].team_id}${basketball}`);
		       var team_id = elements("td");
		       var n_won = elements("td");
		       var n_loss = elements("td");
		       var year = elements("td");
		       year.setAttribute("data-basketball-year",data[basketball].year);
		       var btn_td=elements("td");
		       var btn = elements("a");
		       btn.innerText="Delete";
		       btn.setAttribute("class","btn btn-danger text-white");
		       btn.setAttribute("onclick",`delete_basketball(${data[basketball].team_id}${basketball}\,${data[basketball].year});`);
		       btn_td.appendChild(btn);
		       team_id.innerText=data[basketball].team_id;
		       n_won.innerText = data[basketball].number_won;
		       n_loss.innerText = data[basketball].number_loss;
		       year.innerText = data[basketball].year;
		       
		       tr.appendChild(team_id);
		       tr.appendChild(n_won);
		       tr.appendChild(n_loss);
		       tr.appendChild(year);
		       tr.appendChild(btn_td);
		       
		       tbody.appendChild(tr);
		       
		}
	
}
function delete_basketball(id,year)
{
 
   var trelement = document.getElementById(id);
  trelement.remove();
  $.get(`controller?action=delete_operation&type=stats&sports_type=basketball&id=${id}&year=${year}`,function(data,status)
 		 {
 	          console.log(data);
 		 });

}

function create_football_table(data)
{
	var tbody = document.getElementById("footballstats-tbody");
	 var elements = (tagname)=>
	   {
		   return document.createElement(tagname);
	   }
	for(football in data)
		{
		       var tr = elements("tr");
		       tr.setAttribute("id",`${data[football].team_id}${football}`);
		       var team_id = elements("td");
		       var n_goals = elements("td");
		       var n_won = elements("td");
		       var n_loss = elements("td");
		       var n_tie = elements("td");
		       var year = elements("td");
		       var btn_td=elements("td");
		       var btn = elements("a");
		       btn.innerText="Delete";
		       btn.setAttribute("class","btn btn-danger text-white");
		       btn.setAttribute("onclick",`delete_football(${data[football].team_id}${football}\,${data[football].year});`);
		       btn_td.appendChild(btn);
		       team_id.innerText=data[football].team_id;
		       n_won.innerText = data[football].number_won;
		       n_loss.innerText = data[football].number_loss;
		       n_goals.innerText = data[football].number_goals;
		       n_tie.innerText = data[football].number_tie;
		       year.innerText = data[football].year;
		       
		       tr.appendChild(team_id);
		       tr.appendChild(n_goals);
		       tr.appendChild(n_won);
		       tr.appendChild(n_loss);
		       tr.appendChild(n_tie); 
		       tr.appendChild(year);
		       tr.appendChild(btn_td);
		       
		       tbody.appendChild(tr);
		       
		}
	
}
function delete_football(id,year)
{
	   var trelement = document.getElementById(id);
	   trelement.remove();
	   $.get(`controller?action=delete_operation&type=stats&sports_type=football&id=${id}&year=${year}`,function(data,status)
		 		 {
		 	          console.log(data);
		 		 });
}

function create_cricket_table(data)
{
	var tbody = document.getElementById("cricketstats-tbody");
	 var elements = (tagname)=>
	   {
		   return document.createElement(tagname);
	   }
	for(cricket in data)
		{
		       var tr = elements("tr");
		       tr.setAttribute("id",`${data[cricket].team_id}${cricket}`);
		       var team_id = elements("td");
		       var n_odi = elements("td");
		       var n_test = elements("td");
		       var n_t20 = elements("td");
		       var draws = elements("td");
		       var year = elements("td");
		       var btn_td=elements("td");
		       var btn = elements("a");
		       btn.innerText="Delete";
		       btn.setAttribute("class","btn btn-danger");
		       btn.setAttribute("onclick",`delete_cricket(${data[cricket].team_id})${cricket}\,${data[cricket].year}`);
		       btn_td.appendChild(btn);
		       team_id.innerText=cricket.team_id;
		       n_odi.innerText = cricket.number_odi;
		       n_test.innerText = cricket.number_test;
		       n_t20.innerText = cricket.number_t20;
		       draws.innerText = cricket.draws;
		       year.innerText = cricket.year;
		       
		       tr.appendChild(team_id);
		       tr.appendChild(n_odi);
		       tr.appendChild(n_test);
		       tr.appendChild(n_t20);
		       tr.appendChild(draws); 
		       tr.appendChild(year);
		       tr.appendChild(btn_td);
		       
		       tbody.appendChild(tr);
		       
		}
}
function delete_cricket(id,year)
{
	   var trelement = document.getElementById(id);
	   trelement.remove();
	   $.get(`controller?action=delete_operation&type=stats&sports_type=cricket&id=${id}&year=${year}`,function(data,status)
		 		 {
		 	          console.log(data);
		 		 });
}
function get_counts(options)
{
	$.get(`controller?action=${options}`,function(data,status)
   		 {
   	          append_data(data);
   		 });
}
function append_data(data)
{
		var teams = document.getElementById("teams_count");
		var players = document.getElementById("players_count");
		var matches = document.getElementById("matches_count");
		teams.textContent = data[0];
		players.textContent = data[1];
		matches.textContent = data[2];
		console.log(data[0]);
		console.log(teams.textContent);
		 $('#players_count').counterUp({
		        delay: 5,
		        time: 1000
		    });
		    $('#teams_count').counterUp({
		        delay: 5,
		        time: 1000
		    });
		    $('#matches_count').counterUp({
		        delay: 5,
		        time: 1000
		    });
}
function get_teams(options)
{
     $.get(`controller?action=${options}`,function(data,status)
    		 {
    	          create_table_team(data);
    		 });
}
function create_table_team(data)
{
   var tbody = document.getElementsByClassName("teams-tbody")[0];
   var elements = (tagname)=>
   {
	   return document.createElement(tagname);
   }
   for(team of data)
	   {
	      var tr = elements("tr");
	      tr.setAttribute("data-team",team.team_id);
	      var team_id = elements("td");
	      var team_name= elements("td");
	      var sportstype = elements("td");
	      var ranking = elements("td");
	      var coach_name = elements("td");
	      var established_year = elements("td");
	      var image_url = elements("td");
	      
	      var btn_td=elements("td");
	       var btn = elements("a");
	       btn.innerText="Delete";
	       btn.setAttribute("class","btn btn-danger text-white");
	       btn.setAttribute("onclick",`delete_team(${team.team_id})`);
	       btn_td.appendChild(btn);
	      team_id.innerText=team.team_id;
	      team_name.innerText=team.team_name;
	      sportstype.innerText=team.sportstype;
	      ranking.innerText=team.ranking;
	      coach_name.innerText=team.coach_name;
	      established_year.innerText=team.established_year;
	      image_url.innerText=team.image_url;
	      
	      tr.appendChild(team_id);
	      tr.appendChild(team_name);
	      tr.appendChild(sportstype);
	      tr.appendChild(ranking);
	      tr.appendChild(coach_name);
	      tr.appendChild(established_year);
	      tr.appendChild(image_url);
	      tr.appendChild(btn_td);
	      tbody.appendChild(tr);   
	   }
}
function delete_team(id)
{
 	var team = document.querySelector(`tr[data-team='${id}']`);
 	team.remove();
 	 $.get(`controller?action=delete_operation&type=team&id=${id}`,function(data,status)
    		 {
    	          console.log(data);
    		 });

}
function get_players(options)
{
	$.get(`controller?action=${options}`,function(data,status)
   		 {
   	          create_table_player(data);
   		 });
}

function create_table_player(data)
{
	 var tbody = document.getElementsByClassName("players-tbody")[0];
	   var elements = (tagname)=>
	   {
		   return document.createElement(tagname);
	   }
	   for(player of data)
		   {
		      var tr = elements("tr");
		      tr.setAttribute("data-player",player.player_id);
		      var player_id = elements("td");
		      var player_name= elements("td");
		      var sportstype = elements("td");
		      var team_id = elements("td");
		      var age = elements("td");
		      var description= elements("td");
		      var image_url = elements("td");
		      var btn_td=elements("td");
		       var btn = elements("a");
		       btn.innerText="Delete";
		       btn.setAttribute("class","btn btn-danger text-white");
		       btn.setAttribute("onclick",`delete_player(${player.player_id})`);
		       btn_td.appendChild(btn);
		      player_id.innerText=player.player_id;
		      player_name.innerText=player.player_name;
		      sportstype.innerText=player.sportstype;
		      team_id.innerText=player.team_id;
		      age.innerText=player.age;
		      description.innerText=player.description;
		      image_url.innerText=player.image_url;
		      
		      tr.appendChild(player_id);
		      tr.appendChild(player_name);
		      tr.appendChild(sportstype);
		      tr.appendChild(team_id);
		      tr.appendChild(age);
		      tr.appendChild(description);
		      tr.appendChild(image_url);
		      tr.appendChild(btn_td);
		      tbody.appendChild(tr);   
		   }
}
function delete_player(id)
{
	var player = document.querySelector(`tr[data-player='${id}']`);
	player.remove();
	$.get(`controller?action=delete_operation&type=player&id=${id}`,function(data,status)
   		 {
   	          console.log(data);
   		 });

}
function get_matches(options)
{
	$.get(`controller?action=${options}`,function(data,status)
	   		 {
	   	          create_table_matches(data);
	   		 }); 	
}
function create_table_matches(data)
{
	 var tbody = document.getElementsByClassName("matches-tbody")[0];
	   var elements = (tagname)=>
	   {
		   return document.createElement(tagname);
	   }
	   for(player of data)
		   {
		      var tr = elements("tr");
		      tr.setAttribute("data-match",player.match_id);
		      var match_id = elements("td");
		      var first_team_id= elements("td");
		      var first_team_score = elements("td");
		      var second_team_id = elements("td");
		      var second_team_score= elements("td");
		      var date= elements("td");
		      var sportstype = elements("td");
		      
		       var btn_td=elements("td");
		       var btn = elements("a");
		       btn.innerText="Delete";
		       btn.setAttribute("class","btn btn-danger text-white");
		       btn.setAttribute("onclick",`delete_match(${player.match_id})`);
		       btn_td.appendChild(btn);
		      match_id.innerText=player.match_id;
		      first_team_id.innerText=player.first_team_id;
		      first_team_score.innerText=player.first_team_score;
		      second_team_id.innerText=player.second_team_id;
		      second_team_score.innerText=player.second_team_score;
		      date.innerText=player.date;
		      sportstype.innerText=player.sportstype;
		      
		      tr.appendChild(match_id);
		      tr.appendChild(first_team_id);
		      tr.appendChild(first_team_score);
		      tr.appendChild(second_team_id);
		      tr.appendChild(second_team_score);
		      tr.appendChild(date);
		      tr.appendChild(sportstype);
		      tr.appendChild(btn_td);
		      tbody.appendChild(tr);   
		   }
}
function delete_match(id)
{
	var match = document.querySelector(`tr[data-match='${id}']`);
 	match.remove();
 	$.get(`controller?action=delete_operation&type=match&id=${id}`,function(data,status)
   		 {
   	          console.log(data);
   		 });

}
function post_teams_data()
{
	var form =document.getElementById("team-form");
	$.ajax({
		type: "post",
		url:"controller?action=post_teams_data",
		encType : "multipart/form-data",
		contentType :false,
        cache : false,
        processData : false,
		data:new FormData(form),
		success:function(response)
		{
			if(response.length>0)
				{
				$("#teams-success-msg").text(response);
				 $("#teams-success-msg").removeClass("d-none");
				}
			else
				{
				$("#teams-failed-msg").text("Failed to Post");
				$("#teams-failed-msg").removeClass("d-none");
				}
		}
	});
}