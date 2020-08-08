function getData(sportstype)
{
       $.get(`controller?action=statistics&sportstype=${sportstype}`,function(response)
    		   {
                createStats(response,sportstype);
                if(response.length==0)
                	{
                	      var show_msg = document.getElementsByClassName("show-msg")[0];
                	      show_msg.classList.remove("d-none");
                	}
    		   });	
       
}
function createStats(response,sportstype)
{
    	switch (sportstype) {
		case "BasketBall":
			createBasketBallStats(response);
			break;
		case "FootBall":
			createFootBallStats(response);
			break;
		case "Cricket":
			createCricketStats(response);
			break;
		default:
			break;
		}
}
function createBasketBallStats(data)
{
	var image_container = document.getElementsByClassName('img-container')[0];
	image_container.style.display="none";
	for(var i = 0;i<data.length;i++)
		{
		  n_loss = new Array();
		  n_won = new Array();
		  year = new Array();
		  team = "";
		    for(var basketball of data[i])
		    	{
		    	   n_loss.push(basketball.number_loss);
		    	   n_won.push(basketball.number_won);
		    	   year.push(basketball.year);
		    	   team = basketball.team_name;
		    	}
		    var wrapper = document.getElementsByClassName('wrapper-stats')[0];
		    var canvas = document.createElement("CANVAS");
		    canvas.setAttribute('id',`myChart${i}`);
		    canvas.setAttribute('width',"600px");
		    canvas.setAttribute('height',"600px");
		    wrapper.appendChild(canvas);
		    var ctx = document.getElementById(`myChart${i}`).getContext('2d');
		    var myChart = new Chart(ctx, {
		        type: 'line',
		        data: {
		            labels: ['2015','2016','2017','2018','2019','2020'],
		            datasets: [{
		            	pointRadius:9,
		            	pointHoverRadius:9,
		            	pointBorderColor:'rgba(255, 99, 132, 1)',
		            	fill:false,
		            	pointHoverBackgroundColor:[
		                	'rgba(255, 99, 132, 1)',
		                    'rgba(54, 162, 235, 1)',
		                    'rgba(255, 206, 86, 1)',
		                    'rgba(75, 192, 192, 1)',
		                    'rgba(153, 102, 255, 1)',
		                    'rgba(255, 159, 64, 1)'
		                ],
		                label: `number of games lost ${team}`,
		                data: n_loss,
		                backgroundColor: [
		                	'rgba(255, 99, 132, 0.2)',
		                    'rgba(54, 162, 235, 0.2)',
		                    'rgba(255, 206, 86, 0.2)',
		                    'rgba(75, 192, 192, 0.2)',
		                    'rgba(153, 102, 255, 0.2)',
		                    'rgba(255, 159, 64, 0.2)'
		                ],
		                borderColor: [
		                    'rgba(255, 99, 132, 1)'
		                ],
		                borderWidth: 3
		            },
		            {
		            	pointRadius:9,
		            	pointHoverRadius:9,
		            	pointBorderColor:'rgba(54, 162, 235, 1)',
		            	label: `number of games won ${team}`,
		                data: n_won,
		                fill:false,
		                pointHoverBackgroundColor:[
		                	'rgba(255, 99, 132, 1)',
		                    'rgba(54, 162, 235, 1)',
		                    'rgba(255, 206, 86, 1)',
		                    'rgba(75, 192, 192, 1)',
		                    'rgba(153, 102, 255, 1)',
		                    'rgba(255, 159, 64, 1)'
		                ],
		                backgroundColor: [
		                	'rgba(255, 99, 132, 0.2)',
		                    'rgba(54, 162, 235, 0.2)',
		                    'rgba(255, 206, 86, 0.2)',
		                    'rgba(75, 192, 192, 0.2)',
		                    'rgba(153, 102, 255, 0.2)',
		                    'rgba(255, 159, 64, 0.2)'
		                ],
		                borderColor: [
		                	'rgba(54, 162, 235, 1)'
		                ],
		                borderWidth: 3
		            }]
		        },
		        options: {
		        	 legend: {
		                 labels: {
		                     // This more specific font property overrides the global property
		                     fontColor: 'black',
		                    	 fontSize:20,
		                    	 padding:20
		                 }
		             },
		            scales: {
		                yAxes: [{
		                    ticks: {
		                        beginAtZero: true,
		                        fontStyle:"bold",
		                		fontSize:20
		                    },
		                    scaleLabel:
		                    	{
		                    	display:true,
		                    	labelString: "number of wins and losses",
		                    	fontStyle:"bold",
		                    	fontSize:20
		                    	}
		                }],
		                xAxes:[{
		                	ticks:
		                		{
		                		fontStyle:"bold",
		                		min:2015,
		                		max:2020,
		                		stepSize:1,
		                		fontSize:20
		                		},
		                		scaleLabel:
		                			{
		                			display:true,
		                			labelString:"Year",
		                			fontStyle:"bold",
		                		    fontSize:20
		                			}
		                }]
		            },
		            responsive:false
		        }
		    });
		}
}
function createFootBallStats(data)
{
	var image_container = document.getElementsByClassName('img-container')[0];
	image_container.style.display="none";
	for(var i = 0;i<data.length;i++)
		{
		  n_loss = new Array();
		  n_won = new Array();
		  n_tie = new Array();
		  n_goals = new Array();
		  year = new Array();
		  team = "";
		    for(var football of data[i])
		    	{
		    	   n_loss.push(football.number_loss);
		    	   n_won.push(football.number_won);
		    	   n_tie.push(football.number_tie);
		    	   n_goals.push(football.number_goals);
		    	   year.push(football.year);
		    	   team = football.team_name;
		    	}
		    var wrapper = document.getElementsByClassName('wrapper-stats')[0];
		    var canvas = document.createElement("CANVAS");
		    canvas.setAttribute('id',`myChart${i}`);
		    canvas.setAttribute('width',"600px");
		    canvas.setAttribute('height',"600px");
		    wrapper.appendChild(canvas);
		    var ctx = document.getElementById(`myChart${i}`).getContext('2d');
		    var myChart = new Chart(ctx, {
		        type: 'line',
		        data: {
		            labels: ['2015','2016','2017','2018','2019','2020'],
		            datasets: [{
		            	pointRadius:6,
		            	pointHoverRadius:9,
		            	pointBorderColor:'rgba(255, 99, 132, 1)',
		            	fill:false,
		            	pointHoverBackgroundColor:[
		                	'rgba(255, 99, 132, 1)',
		                    'rgba(54, 162, 235, 1)',
		                    'rgba(255, 206, 86, 1)',
		                    'rgba(75, 192, 192, 1)',
		                    'rgba(153, 102, 255, 1)',
		                    'rgba(255, 159, 64, 1)'
		                ],
		                label: `number of games lost ${team}`,
		                data: n_loss,
		                backgroundColor: [
		                	'rgba(255, 99, 132, 0.2)',
		                    'rgba(54, 162, 235, 0.2)',
		                    'rgba(255, 206, 86, 0.2)',
		                    'rgba(75, 192, 192, 0.2)',
		                    'rgba(153, 102, 255, 0.2)',
		                    'rgba(255, 159, 64, 0.2)'
		                ],
		                borderColor: [
		                    'rgba(255, 99, 132, 1)'
		                ],
		                borderWidth: 3
		            },
		            {
		            	pointRadius:6,
		            	pointHoverRadius:9,
		            	pointBorderColor:'rgba(54, 162, 235, 1)',
		            	label: `number of games won ${team}`,
		                data: n_won,
		                fill:false,
		                pointHoverBackgroundColor:[
		                	'rgba(255, 99, 132, 1)',
		                    'rgba(54, 162, 235, 1)',
		                    'rgba(255, 206, 86, 1)',
		                    'rgba(75, 192, 192, 1)',
		                    'rgba(153, 102, 255, 1)',
		                    'rgba(255, 159, 64, 1)'
		                ],
		                backgroundColor: [
		                	'rgba(255, 99, 132, 0.2)',
		                    'rgba(54, 162, 235, 0.2)',
		                    'rgba(255, 206, 86, 0.2)',
		                    'rgba(75, 192, 192, 0.2)',
		                    'rgba(153, 102, 255, 0.2)',
		                    'rgba(255, 159, 64, 0.2)'
		                ],
		                borderColor: [
		                	'rgba(54, 162, 235, 1)'
		                ],
		                borderWidth: 3
		            },
		            {
		            	pointRadius:6,
		            	pointHoverRadius:9,
		            	pointBorderColor:'rgba(54, 162, 235, 1)',
		            	label: `number of games tied ${team}`,
		                data: n_tie,
		                fill:false,
		                pointHoverBackgroundColor:[
		                	'rgba(255, 99, 132, 1)',
		                    'rgba(54, 162, 235, 1)',
		                    'rgba(255, 206, 86, 1)',
		                    'rgba(75, 192, 192, 1)',
		                    'rgba(153, 102, 255, 1)',
		                    'rgba(255, 159, 64, 1)'
		                ],
		                backgroundColor: [
		                	'rgba(255, 99, 132, 0.2)',
		                    'rgba(54, 162, 235, 0.2)',
		                    'rgba(255, 206, 86, 0.2)',
		                    'rgba(75, 192, 192, 0.2)',
		                    'rgba(153, 102, 255, 0.2)',
		                    'rgba(255, 159, 64, 0.2)'
		                ],
		                borderColor: [
		                	'rgba(255, 206, 86, 1)'
		                ],
		                borderWidth: 3
		            },
		            {
		            	pointRadius:6,
		            	pointHoverRadius:9,
		            	pointBorderColor:'rgba(54, 162, 235, 1)',
		            	label: `number of goals scored by ${team}`,
		                data: n_goals,
		                fill:false,
		                pointHoverBackgroundColor:[
		                	'rgba(255, 99, 132, 1)',
		                    'rgba(54, 162, 235, 1)',
		                    'rgba(255, 206, 86, 1)',
		                    'rgba(75, 192, 192, 1)',
		                    'rgba(153, 102, 255, 1)',
		                    'rgba(255, 159, 64, 1)'
		                ],
		                backgroundColor: [
		                	'rgba(255, 99, 132, 0.2)',
		                    'rgba(54, 162, 235, 0.2)',
		                    'rgba(255, 206, 86, 0.2)',
		                    'rgba(75, 192, 192, 0.2)',
		                    'rgba(153, 102, 255, 0.2)',
		                    'rgba(255, 159, 64, 0.2)'
		                ],
		                borderColor: [
		                	'rgba(75, 192, 192, 1)'
		                ],
		                borderWidth: 3
		            }
		            ]
		        },
		        options: {
		        	 legend: {
		                 labels: {
		                     // This more specific font property overrides the global property
		                     fontColor: 'black',
		                    	 fontSize:20,
		                    	 padding:20
		                 }
		             },
		            scales: {
		                yAxes: [{
		                    ticks: {
		                        beginAtZero: true,
		                        fontStyle:"bold",
		                		fontSize:20
		                    },
		                    scaleLabel:
		                    	{
		                    	display:true,
		                    	labelString: "number of wins and losses",
		                    	fontStyle:"bold",
		                    	fontSize:20
		                    	}
		                }],
		                xAxes:[{
		                	ticks:
		                		{
		                		fontStyle:"bold",
		                		min:2015,
		                		max:2020,
		                		stepSize:1,
		                		fontSize:20
		                		},
		                		scaleLabel:
		                			{
		                			display:true,
		                			labelString:"Year",
		                			fontStyle:"bold",
		                		    fontSize:20
		                			}
		                }]
		            },
		            responsive:false
		        }
		    });
		}
}

function createCricketStats(data)
{
	var image_container = document.getElementsByClassName('img-container')[0];
	image_container.style.display="none";
	for(var i = 0;i<data.length;i++)
		{
		  n_odi = new Array();
		  n_t20 = new Array();
		  n_test = new Array();
		  n_draw = new Array();
		  year = new Array();
		  team = "";
		    for(var cricket of data[i])
		    	{
		    	   n_odi.push(cricket.number_odi);
		    	   n_t20.push(cricket.number_t20);
		    	   n_test.push(cricket.number_test);
		    	   n_draw.push(cricket.number_draw);
		    	   year.push(cricket.year);
		    	   team = cricket.team_name;
		    	}
		    var wrapper = document.getElementsByClassName('wrapper-stats')[0];
		    var canvas = document.createElement("CANVAS");
		    canvas.setAttribute('id',`myChart${i}`);
		    canvas.setAttribute('width',"600px");
		    canvas.setAttribute('height',"600px");
		    wrapper.appendChild(canvas);
		    var ctx = document.getElementById(`myChart${i}`).getContext('2d');
		    var myChart = new Chart(ctx, {
		        type: 'bar',
		        data: {
		            labels: ['2015','2016','2017','2018','2019','2020'],
		            datasets: [{
		            	pointRadius:6,
		            	pointHoverRadius:9,
		            	pointBorderColor:'rgba(255, 99, 132, 1)',
		            	fill:false,
		            	pointHoverBackgroundColor:[
		                	'rgba(255, 99, 132, 1)',
		                    'rgba(54, 162, 235, 1)',
		                    'rgba(255, 206, 86, 1)',
		                    'rgba(75, 192, 192, 1)',
		                    'rgba(153, 102, 255, 1)',
		                    'rgba(255, 159, 64, 1)'
		                ],
		                label: `number of ODI won by ${team}`,
		                data: n_odi,
		                backgroundColor: [
		                	'rgba(255, 99, 132, 0.2)',
		                    'rgba(54, 162, 235, 0.2)',
		                    'rgba(255, 206, 86, 0.2)',
		                    'rgba(75, 192, 192, 0.2)',
		                    'rgba(153, 102, 255, 0.2)',
		                    'rgba(255, 159, 64, 0.2)'
		                ],
		                borderColor: [
		                    'rgba(255, 99, 132, 1)'
		                ],
		                borderWidth: 3
		            },
		            {
		            	pointRadius:6,
		            	pointHoverRadius:9,
		            	pointBorderColor:'rgba(54, 162, 235, 1)',
		            	label: `number of T20s won by ${team}`,
		                data: n_t20,
		                fill:false,
		                pointHoverBackgroundColor:[
		                	'rgba(255, 99, 132, 1)',
		                    'rgba(54, 162, 235, 1)',
		                    'rgba(255, 206, 86, 1)',
		                    'rgba(75, 192, 192, 1)',
		                    'rgba(153, 102, 255, 1)',
		                    'rgba(255, 159, 64, 1)'
		                ],
		                backgroundColor: [
		                	'rgba(255, 99, 132, 0.2)',
		                    'rgba(54, 162, 235, 0.2)',
		                    'rgba(255, 206, 86, 0.2)',
		                    'rgba(75, 192, 192, 0.2)',
		                    'rgba(153, 102, 255, 0.2)',
		                    'rgba(255, 159, 64, 0.2)'
		                ],
		                borderColor: [
		                	'rgba(54, 162, 235, 1)'
		                ],
		                borderWidth: 3
		            },
		            {
		            	pointRadius:6,
		            	pointHoverRadius:9,
		            	pointBorderColor:'rgba(54, 162, 235, 1)',
		            	label: `number of tests won by ${team}`,
		                data: n_test,
		                fill:false,
		                pointHoverBackgroundColor:[
		                	'rgba(255, 99, 132, 1)',
		                    'rgba(54, 162, 235, 1)',
		                    'rgba(255, 206, 86, 1)',
		                    'rgba(75, 192, 192, 1)',
		                    'rgba(153, 102, 255, 1)',
		                    'rgba(255, 159, 64, 1)'
		                ],
		                backgroundColor: [
		                	'rgba(255, 99, 132, 0.2)',
		                    'rgba(54, 162, 235, 0.2)',
		                    'rgba(255, 206, 86, 0.2)',
		                    'rgba(75, 192, 192, 0.2)',
		                    'rgba(153, 102, 255, 0.2)',
		                    'rgba(255, 159, 64, 0.2)'
		                ],
		                borderColor: [
		                	'rgba(255, 206, 86, 1)'
		                ],
		                borderWidth: 3
		            },
		            {
		            	pointRadius:6,
		            	pointHoverRadius:9,
		            	pointBorderColor:'rgba(54, 162, 235, 1)',
		            	label: `number of games drawed by ${team}`,
		                data: n_draw,
		                fill:false,
		                pointHoverBackgroundColor:[
		                	'rgba(255, 99, 132, 1)',
		                    'rgba(54, 162, 235, 1)',
		                    'rgba(255, 206, 86, 1)',
		                    'rgba(75, 192, 192, 1)',
		                    'rgba(153, 102, 255, 1)',
		                    'rgba(255, 159, 64, 1)'
		                ],
		                backgroundColor: [
		                	'rgba(255, 99, 132, 0.2)',
		                    'rgba(54, 162, 235, 0.2)',
		                    'rgba(255, 206, 86, 0.2)',
		                    'rgba(75, 192, 192, 0.2)',
		                    'rgba(153, 102, 255, 0.2)',
		                    'rgba(255, 159, 64, 0.2)'
		                ],
		                borderColor: [
		                	'rgba(75, 192, 192, 1)'
		                ],
		                borderWidth: 3
		            }
		            ]
		        },
		        options: {
		        	 legend: {
		                 labels: {
		                     // This more specific font property overrides the global property
		                     fontColor: 'black',
		                    	 fontSize:20,
		                    	 padding:20
		                 }
		             },
		            scales: {
		                yAxes: [{
		                    ticks: {
		                        beginAtZero: true,
		                        fontStyle:"bold",
		                		fontSize:20
		                    },
		                    scaleLabel:
		                    	{
		                    	display:true,
		                    	labelString: "number of wins and losses",
		                    	fontStyle:"bold",
		                    	fontSize:20
		                    	}
		                }],
		                xAxes:[{
		                	ticks:
		                		{
		                		fontStyle:"bold",
		                		min:2015,
		                		max:2020,
		                		stepSize:1,
		                		fontSize:20
		                		},
		                		scaleLabel:
		                			{
		                			display:true,
		                			labelString:"Year",
		                			fontStyle:"bold",
		                		    fontSize:20
		                			}
		                }]
		            },
		            responsive:false
		        }
		    });
		}
	
}

