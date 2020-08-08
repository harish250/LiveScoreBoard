<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<title>sports</title>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat&family=Roboto&display=swap" rel="stylesheet"> 
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="bootstrap-4.5.0-dist/css/bootstrap.min.css">
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
   <div class="wrapper">
   <div class="img-container">
     <div class="img-item">
     <h2 class="text-align-center">Cricket</h2>
     <a href="controller?action=<%= request.getParameter("action")%>&sport=Cricket"><img alt="" class="sport-images" src="img/Home run-pana.svg"></a>
     </div>
     <div class="img-item">
     <h2 class="text-align-center">Football</h2>
     <a href="controller?action=<%= request.getParameter("action")%>&sport=FootBall"><img alt="" class="sport-images" src="img/Football Goal-pana.svg"></a>
     </div>
     <div class="img-item">
     <h2 class="text-align-center">Basketball</h2>
     <a href="controller?action=<%= request.getParameter("action")%>&sport=BasketBall"><img alt="" class="sport-images" src="img/Basketball-pana.svg"></a>
     </div>
     </div>
   </div>
   
   
</body>
</html>