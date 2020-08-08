<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<%@page import="com.livescoreboard.dao.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Players Information</title>
<link href="https://fonts.googleapis.com/css2?family=Montserrat&family=Roboto&display=swap" rel="stylesheet"> 
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="bootstrap-4.5.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>


<c:set var="team_id" value="${param.team_id}">
</c:set>


<c:set var="sportstype" value="${param.sportstype}"></c:set>
<jsp:useBean id="players" class="com.livescoreboard.dao.PlayersInfoDao"></jsp:useBean>
  <div class="info-container">	
     <div class="row row-container">
      <c:if test="${players.getPlayers(team_id,sportstype).size()==0}">
     <h1 class="text-center text-danger">No Data to Display please feed the Database</h1>
  </c:if>
  <c:forEach items="${players.getPlayers(team_id,sportstype)}" var="player">
  <c:if test="${players.getPlayers(team_id,sportstype).size()>0}">
   <div class="col-12 col-md-3 pb-5">
	<div class="player-card card h-100">
  	<img class="card-img-top" style="border-radius: 50%;" src="${player.image_url}" alt="Card image cap">
  	<div class="card-body">
    	<h5 class="card-title">${player.player_name}</h5>
    	<p class="card-text">Age ${player.age}</p>
    	<p class="card-text">${player.description}</p>
  	</div>
	</div>
     </div>  
  </c:if>
  </c:forEach>
  </div>
 

  </div>
</body>
</html>