<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Home</title>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat&family=Roboto&display=swap" rel="stylesheet"> 
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="bootstrap-4.5.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="js/admin.js"></script>
<title>Teams</title>
</head>
<body onload="setup('get_players');">
<% if(request.getSession(false).getAttribute("username")==null)
	{
	response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    
	   response.sendRedirect("/LiveScoreBoard/adminLogin.html");
	}
	
	%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#"><img src="img/logo.png" width="70px" height="70px" alt=""></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item">
        <a class="admin-link nav-link" href="AdminDashBoard.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="admin-nav nav-item">
        <a class="admin-link nav-link" href="controller?action=admin_teams">Teams</a>
      </li>
      <li class="admin-nav nav-item active">
            <a class="admin-link nav-link" href="controller?action=admin_players">Players</a>
      </li>
      <li class="admin-nav nav-item">
        <a class="admin-link nav-link " href="controller?action=admin_stats">Statistics</a>
      </li>
      <li class="admin-nav nav-item">
        <a class="admin-link nav-link " href="controller?action=admin_matches">Matches</a>
      </li>
      <li class="admin-nav nav-item">
      <a class="btn btn-primary" href="controller?action=log_out">sign out</a>
      </li>
    </ul>
  </div>
</nav>

<div class="admin-team-container container">
      <form class="form-group" id="player-form">
      <div class="row">
          <div class="col-md-2 pb-3">
          <label for="Player_name">Player Name</label>
          </div>
          <div class="col-md-10 pb-3">
          <input type="text" class="form-control" name="player_name" id="player_name" placeholder="Player Name">
          </div>
          <div class="col-md-2 pb-3">
          <label for="sports_type">Sport</label>
          </div>
          <div class="col-md-10 pb-3">
          <input type="text" class="form-control" placeholder="Cricket/BasketBall/FootBall" name="sports_type" id="sports_type">
          </div>
          <div class="col-md-2 pb-3">
          <label for="team_id">Team Id</label>
          </div>
          <div class="col-md-10 pb-3">
          <input type="number" class="form-control" name="team_id" class="team_id" placeholder="Team Id">
          </div>
          <div class="col-md-2 pb-3">
          <label for="age">Age</label>
          </div>
          <div class="col-md-10 pb-3">
          <input type="number" class="form-control" name="age" id="age" placeholder="Age">
          </div>
          <div class="col-md-2 pb-3">
          <label for="description">Description</label>
          </div>
          <div class="col-md-10 pb-3">
          <input type="text" class="form-control" name="description" id="description" placeholder="Description About Player">
          </div>
          <div class="col-md-2 pb-3">
          <label for="player_file">Player Image</label>
          </div>
          <div class="col-md-10 pb-3">
          <input type="file" name="player_file" id="player_file">
          </div>
          	
          <input type="button" onclick="post_players_data();"class="btn btn-primary mx-auto" value="Submit">
          
          
      </div>
            <div class="alert alert-success align-center d-none pt-3" role="alert" id="players-success-msg">
             
			</div>
			<div class="alert alert-danger align-center d-none pt-3" role="alert" id="players-failed-msg">
  
			</div>
      </form>

</div>
<div class="container mt-5">
<div class="table-responsive">

   <table class="table table-hover bg-white">
  <thead>
    <tr>
      <th scope="col">Player id</th>
      <th scope="col">Player name</th>
      <th scope="col">Sports Type</th>
      <th scope="col">Team Id</th>
      <th scope="col">Age</th>
      <th scope="col">Description</th>
      <th scope="col">Image URL</th>
      
      
    </tr>
  </thead>
  <tbody class="players-tbody">
    
    
  </tbody>
</table>
</div>
</div>

























    <script src="bootstrap-4.5.0-dist/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="bootstrap-4.5.0-dist/js/bootstrap.min.js"></script>
</body>
</html>