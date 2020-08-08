<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<title>Live Score</title>
	<link href="https://fonts.googleapis.com/css2?family=Montserrat&family=Roboto&display=swap" rel="stylesheet"> 
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="bootstrap-4.5.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="match-container">
 <c:if test="${matches.size()==0}">
   <div class="no-data-match">
   <h1 class="text-center text-danger">No matches to display</h1>
   </div>
 </c:if>
<c:if test="${matches.size()>0}">

 <c:forEach items="${matches}" var="match">
    <h1 class="text-center pt-5">Todays Matches</h1>
 
 <div class="row match-container-row">
  <div class="col-md-6 match-item">
     <img alt="" src="${match.first_team_image_url}">
     <div class="match-content">
     <h3 class="team-name">${match.first_team_name}</h3>
     <h1 class="team-score">${match.first_team_score}</h1>	
     <p class="team-ranking">Ranking: ${match.first_ranking}</p>
     <p class="date">${match.year}</p>    
     </div>
     </div>
     <div class="col-md-6 match-item">
     <img alt="" src="${match.second_team_image_url}">
     <div class="match-content">
     <h3 class="team-name">${match.second_team_name}</h3>
     <h1 class="team-score">${match.second_team_score}</h1>	
     <p class="team-ranking">Ranking: ${match.second_ranking}</p>
     <p class="date">${match.year}</p>   
     </div>
     </div>
 </div>
 </c:forEach>
 </c:if>
    
</div>


<div class="match-container">
<c:if test="${matches.size()==0}">
   <div class="no-data-match">
   <h1 class="text-center text-danger">No matches to display</h1>
   </div>
 </c:if>
 <c:if test="${matches.size()>0}">
 
   <c:forEach items="${upcoming}" var="match">
   <h1 class="text-center pt-5">Upcoming Matches</h1>
 <div class="row match-container-row">
  <div class="col-md-6 match-item">
     <img alt="" src="${match.first_team_image_url}">
     <div class="match-content">
     <h3 class="team-name">${match.first_team_name}</h3>
     <h1 class="team-score">${match.first_team_score}</h1>	
     <p class="team-ranking">Ranking: ${match.first_ranking}</p>
     <p class="date">${match.year}</p>    
     </div>
     </div>
     <div class="col-md-6 match-item">
     <img alt="" src="${match.second_team_image_url}">
     <div class="match-content">
     <h3 class="team-name">${match.second_team_name}</h3>
     <h1 class="team-score">${match.second_team_score}</h1>	
     <p class="team-ranking">Ranking: ${match.second_ranking}</p>
     <p class="date">${match.year}</p>   
     </div>
     </div>
 </div>
 </c:forEach>
 </c:if>
    
</div>

</body>
</html>