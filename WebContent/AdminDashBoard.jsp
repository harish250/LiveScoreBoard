<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Admin DashBoard</title>
	<link href="https://fonts.googleapis.com/css2?family=Montserrat&family=Roboto&display=swap" rel="stylesheet"> 
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="bootstrap-4.5.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="js/admin.js"></script>
</head>
<body onload="setup('get_counts')">
<%  if(session.getAttribute("username")==null)
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
      <li class="nav-item active">
        <a class="admin-link nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="admin-nav nav-item">
        <a class="admin-link nav-link" href="controller?action=admin_teams">Teams</a>
      </li>
      <li class="admin-nav nav-item">
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

	
	
<div class="container admin-dashboard">
<div class="row">
    <div class="col-12 col-md-4">
    <div class="card" style="width: 18rem;">
  <div class="card-body">
  <div class="card-text">
  <h4 class="labels">Teams Registered</h4>
  </div>
   <h5 id="teams_count" class="counter"></h5>
  </div>
</div>
    </div>
    <div class="col-12 col-md-4">
    <div class="card" style="width: 18rem;">
  <div class="card-body">
  <div class="card-text">
  <h4 class="labels">Players Registered</h4>
  </div>
  <h5 id="players_count" class="counter"></h5>
  </div>
</div>
    </div>
     <div class="col-12 col-md-4">
    <div class="card" style="width: 18rem;">
  <div class="card-body">
  <div class="card-text">
  <h4 class="labels">Matches Registered</h4>
  </div>
  <h5 id="matches_count" class="counter"></h5>
  </div>
</div>
    </div>
   
</div>
<div class="row mt-5 mb-3">
  <div class="col-12 col-md-4">
  <div class="card" style="width: 18rem;">
  <div class="card-body">
  <div class="card-text">
  <i class="fa fa-users fa-3x"></i>
  <h4 class="pt-3 labels">Teams</h4>
  <a href="controller?action=admin_teams" class="btn btn-primary">visit <i class="fa fa-link"></i></a>
  </div>
  </div>
  </div>
  </div>
  <div class="col-12 col-md-4">
  <div class="card" style="width: 18rem;">
  <div class="card-body">
  <div class="card-text">
  <i class="fa fa-user fa-3x"></i>
  <h4 class="pt-3 labels">Players</h4>
  <a href="controller?action=admin_players" class="btn btn-primary">visit <i class="fa fa-link"></i></a>
  </div>
  </div>
  </div>
  </div>
  <div class="col-12 col-md-4">
  <div class="card" style="width: 18rem;">
  <div class="card-body">
  <div class="card-text">
 <i class="fa fa-signal fa-3x"></i>
  <h4 class="pt-3 labels">Stats</h4>
  <a href="controller?action=admin_stats" class="btn btn-primary">visit <i class="fa fa-link"></i></a>
  </div>
  </div>
  </div>
  </div>
    <div class="col-12 col-md-4 mt-3">
  <div class="card" style="width: 18rem;">
  <div class="card-body">
  <div class="card-text">
	<img class="match-icon" src="img/icons8-basketball-field-90.png"> 
  <h4 class="pt-3 labels">Matches</h4>
  <a href="controller?action=admin_matches" class="btn btn-primary">visit <i class="fa fa-link"></i></a>
  </div>
  </div>
  </div>
  </div>
</div>
</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
	<script src="bootstrap-4.5.0-dist/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="bootstrap-4.5.0-dist/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/waypoints/4.0.1/jquery.waypoints.min.js" integrity="sha512-CEiA+78TpP9KAIPzqBvxUv8hy41jyI3f2uHi7DGp/Y/Ka973qgSdybNegWFciqh6GrN2UePx2KkflnQUbUhNIA==" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Counter-Up/1.0.0/jquery.counterup.min.js" integrity="sha512-d8F1J2kyiRowBB/8/pAWsqUl0wSEOkG5KATkVV4slfblq9VRQ6MyDZVxWl2tWd+mPhuCbpTB4M7uU/x9FlgQ9Q==" crossorigin="anonymous"></script>
    
</body>
</html>