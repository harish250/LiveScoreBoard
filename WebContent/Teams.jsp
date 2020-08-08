<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Teams</title>
	<link href="https://fonts.googleapis.com/css2?family=Montserrat&family=Roboto&display=swap" rel="stylesheet"> 
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="bootstrap-4.5.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="team-container">
  <div class="row">
  <c:if test="${teams.size()>0}">
  <c:forEach items="${teams}" var="team">
  <div class="col-12 col-md-3 mb-5 team-item">
  <a href="PlayersInfo.jsp?team_id=${team.team_id}&sportstype=${team.sportstype}">
	  <div class="team-content">
	  <img src="${team.image_url}">
	  <h1>${team.team_name}</h1>
	  <p>Ranking: ${team.ranking}</p>
	  <p>Coach: ${team.coach_name}</p>
	  </div>
  </a>
  </div>
  
  
  </c:forEach>
  </c:if>
  <c:if test="${teams.size()==0}">
  <h1 class="text-center text-danger">No data to display please feed the Database</h1>
  </c:if>
    </div>
</div>

</body>
</html>