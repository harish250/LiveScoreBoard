<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<link href="https://fonts.googleapis.com/css2?family=Montserrat&family=Roboto&display=swap" rel="stylesheet"> 
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="bootstrap-4.5.0-dist/css/bootstrap.min.css">
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
	<script src="js/momentum.min.js"></script>
    <script src="js/Chart.min.js"></script>
    <script src="js/Chart.js"></script>
<title>Statistics</title>
</head>
<body style="background:white;">
<div class="wrapper-stats">
       <div class="show-msg d-none">
       <h1 class="text-center text-danger">No Data To Display please feed the database</h1>
       </div>
   <div class="img-container">
     <div class="img-item">
     <h2 class="text-align-center">Cricket</h2>
     <a onclick="getData('Cricket')"><img alt="" class="sport-images" src="img/Home run-pana.svg"></a>
     </div>
     <div class="img-item">
     <h2 class="text-align-center">Football</h2>
     <a onclick="getData('FootBall')"><img alt="" class="sport-images" src="img/Football Goal-pana.svg"></a>
     </div>
     <div class="img-item">
     <h2 class="text-align-center">Basketball</h2>
     <a onclick="getData('BasketBall')"><img alt="" class="sport-images" src="img/Basketball-pana.svg"></a>
     </div>
     </div>
</div>

	<script src="js/statistics.js"></script>
</body>
</html>