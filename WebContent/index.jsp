<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JQuery Example</title>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	My colors :
	<h1 id="mycolor"></h1>
	<input type="email" name="userEmail" id="userEmail" placeholder="enter your email">
	<!-- <button>click me</button> -->
	<p id="resp"></p>
	<!--  <p id="sdate"></p> -->
	<!-- <button onClick="display()">Click Me</button> -->
	<script type="text/javascript">
	
	$(document).ready(function() 
	{
        $('#userEmail').blur(function(event) 
        {
                var name = $('#userEmail').val();
                $.post('GetUserServlet', 
                {
                	userEmail : name
                }, 
                function(responseText) 
                {
                	//document.getElementById("resp").innerHTML=responseText;
                        $('#resp').text(responseText);
                });
        });
	});
	/* var colors=["red","green","blue","orange"];
	var i=0;
	setInterval(() => {
		display();
		var date=new Date();
		var sdate=document.getElementById("sdate");
		sdate.innerHTML=date;
	},1000);
	
	setTimeout(() => {
		window.location.href="welcome.jsp";
	}, 9000);
	
	function display()
	{
		var mycolor=document.getElementById("mycolor");
		mycolor.innerHTML=colors[i];
		mycolor.style.color=colors[i];
		i++;
		if((colors.length)==i)
			i=0;
	} */
	
	
	</script>












			<!-- $(document).ready(function(){
			  $("button").click(function(){
			    $("p").hide();
			  });
			}); -->
</body>
</html>