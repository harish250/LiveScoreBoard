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
<title>Admin Statistics</title>
</head>
<body onload="setup('get_stats')">

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
      <li class="admin-nav nav-item">
            <a class="admin-link nav-link" href="controller?action=admin_players">Players</a>
      </li>
      <li class="admin-nav nav-item active">
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
      
      <form class="form-group" id="basketballstats-form">
         <h2 class="text-center pb-3">BasketBall Statistics</h2>
      <div class="row">
          <div class="col-md-2 pb-3">
          <label for="bteam_id">Team Id</label>
          </div>
          <div class="col-md-10 pb-3">
          <input type="number" class="form-control" name="bteam_id" id="bteam_id" placeholder="Team ID">
          </div>
          <div class="col-md-2 pb-3">
          <label for="bn_won">Number of matches won</label>
          </div>
          <div class="col-md-10 pb-3">
          <input type="number" class="form-control" placeholder="Number of matches won" name="bn_won" id="bn_won">
          </div>
          <div class="col-md-2 pb-3">
          <label for="bn_loss">Number of matches lost</label>
          </div>
          <div class="col-md-10 pb-3">
          <input type="number" class="form-control" name="bn_loss" id="bn_loss" placeholder="Number of matches Lost">
          </div>
          <div class="col-md-2 pb-3">
          <label for="byear">Year</label>
          </div>
          <div class="col-md-10 pb-3">
          <input type="number" class="form-control" name="byear" id="byear" placeholder="Year">
          </div>
          
          <input type="button" onclick="post_basketball_data();"class="btn btn-primary mx-auto" value="Submit">   
      </div>
        <div class="alert alert-success align-center d-none pt-3" role="alert" id="basketballstats-success-msg">
             
		</div>
		<div class="alert alert-danger align-center d-none pt-3" role="alert" id="basketballstats-failed-msg">
	  
		</div>
      </form>
</div>

<div class="container mt-5">
<div class="table-responsive">

   <table class="table table-hover bg-white">
  <thead>
    <tr>
      <th scope="col">Team Id</th>
      <th scope="col">Number of matches won</th>
      <th scope="col">Number of matches lost</th>
      <th scope="col">Year</th>
      
    </tr>
  </thead>
  <tbody id="basketballstats-tbody">
    
    
  </tbody>
</table>
</div>
</div>


<div class="admin-team-container container">
      <form class="form-group" id="cricketstats-form">	
      <h2 class="text-center pb-3">Cricket Statistics</h2>
      <div class="row">
          <div class="col-md-2 pb-3">
          <label for="cteam_id">Team Id</label>
          </div>
          <div class="col-md-10 pb-3">
          <input type="text" class="form-control" name="cteam_id" id="cteam_id" placeholder="Team ID">
          </div>
          <div class="col-md-2 pb-3">
          <label for="cn_odi_won">Number of ODI matches won</label>
          </div>
          <div class="col-md-10 pb-3">
          <input type="text" class="form-control" placeholder="Number of ODI matches won" name="cn_odi_won" id="cn_odi_won">
          </div>
          <div class="col-md-2 pb-3">
          <label for="bn_loss">Number of T20 matches won</label>
          </div>
          <div class="col-md-10 pb-3">
          <input type="text" class="form-control" name="cn_t20_won" id="cn_t20_won" placeholder="Number of T20 matches won">
          </div>
          <div class="col-md-2 pb-3">
          <label for="bn_loss">Number of Test matches won</label>
          </div>
          <div class="col-md-10 pb-3">
          <input type="text" class="form-control" name="cn_test_won" id="cn_test_loss" placeholder="Number of Test matches won">
          </div>
          <div class="col-md-2 pb-3">
          <label for="cn_drawed">Number of  matches drawed</label>
          </div>
          <div class="col-md-10 pb-3">
          <input type="text" class="form-control" name="cn_drawed" id="cn_drawed" placeholder="Number of matches drawed">
          </div>
          <div class="col-md-2 pb-3">
          <label for="cyear">Year</label>
          </div>
          <div class="col-md-10 pb-3">
          <input type="text" class="form-control" name="cyear" id="cyear" placeholder="Year">
          </div>
          
          	
          <input type="button" onclick="post_cricket_data();" class="btn btn-primary mx-auto" value="Submit">   
      </div>
        <div class="alert alert-success align-center d-none pt-3" role="alert" id="cricketstats-success-msg">
             
		</div>
		<div class="alert alert-danger align-center d-none pt-3" role="alert" id="cricketstats-failed-msg">
	  
		</div>
      </form>
</div>

<div class="container mt-5">
<div class="table-responsive">

   <table class="table table-hover bg-white">
  <thead>
    <tr>
      <th scope="col">Team Id</th>
      <th scope="col">Number of ODI won</th>
      <th scope="col">Number of T20 won</th>
      <th scope="col">Number of Test won</th>
      <th scope="col">Number of matches drawn</th>
      <th scope="col">Year</th>
      
    </tr>
  </thead>
  <tbody id="cricketstats-tbody">
    
    
  </tbody>
</table>
</div>
</div>



<div class="admin-team-container container">
      <form class="form-group" id="footballstats-form">
      <h2 class="text-center pb-3">FootBall Statistics</h2>
      <div class="row">
          <div class="col-md-2 pb-3">
          <label for="fteam_id">Team Id</label>
          </div>
          <div class="col-md-10 pb-3">
          <input type="text" class="form-control" name="fteam_id" id="fteam_id" placeholder="Team ID">
          </div>
          <div class="col-md-2 pb-3">
          <label for="fn_goals">Number of goals scored</label>
          </div>
          <div class="col-md-10 pb-3">
          <input type="text" class="form-control" placeholder="Number of Goals Scored" name="fn_goals" id="fn_goals">
          </div>
          <div class="col-md-2 pb-3">
          <label for="fn_won">Number of games won</label>
          </div>
          <div class="col-md-10 pb-3">
          <input type="text" class="form-control" name="fn_won" id="fn_won" placeholder="Number of matches won">
          </div>
          <div class="col-md-2 pb-3">
          <label for="fn_loss">Number of matches lost</label>
          </div>
          <div class="col-md-10 pb-3">
          <input type="text" class="form-control" name="fn_loss" id="fn_loss" placeholder="Number of matches lost">
          </div>
          <div class="col-md-2 pb-3">
          <label for="fn_tie">Number of  matches Tied</label>
          </div>
          <div class="col-md-10 pb-3">
          <input type="text" class="form-control" name="fn_tie" id="fn_tie" placeholder="Number of matches Tied">
          </div>
          <div class="col-md-2 pb-3">
          <label for="fyear">Year</label>
          </div>
          <div class="col-md-10 pb-3">
          <input type="text" class="form-control" name="fyear" id="fyear" placeholder="Year">
          </div>
          
          	
          <input type="button" onclick="post_football_data();" class="btn btn-primary mx-auto" value="Submit">   
      </div>
        <div class="alert alert-success align-center d-none pt-3" role="alert" id="footballstats-success-msg">
             
		</div>
		<div class="alert alert-danger align-center d-none pt-3" role="alert" id="footballstats-failed-msg">
	  
		</div>
      </form>
</div>

<div class="container mt-5">
<div class="table-responsive">

   <table class="table table-hover bg-white">
  <thead>
    <tr>
      <th scope="col">Team Id</th>
      <th scope="col">Number of goals scored</th>
      <th scope="col">Number of matches won</th>
      <th scope="col">Number of matches lost</th>
      <th scope="col">Number of matches tied</th>
      <th scope="col">Year</th>
      
    </tr>
  </thead>
  <tbody id="footballstats-tbody">
    
    
  </tbody>
</table>
</div>
</div>







































    <script src="bootstrap-4.5.0-dist/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="bootstrap-4.5.0-dist/js/bootstrap.min.js"></script>
</body>
</html>