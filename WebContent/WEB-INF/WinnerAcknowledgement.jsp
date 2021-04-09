<%-- Winner Acknowledgement JSP : This form declares the winner if the mean is greater then 90
 	& prints mean and standard deviation. With the use of Databean & StudentBean to retrieve records --%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Winner!!</title>
 <link rel="stylesheet" type="text/css" href="css/style.css">
 <link rel="stylesheet" type="text/css" href="css/edited.css">
<script type="text/javascript">
            function callServlet() {
                document.forms[0].action = "Controller";
                document.forms[0].submit();
            }
        </script>
</head>
<body class="back">
	<div class="w3-top w3-margin-bottom">
  <div class="w3-container w3-gmu w3-center w3-margin-bottom">
    <a class="w3-bar-item w3-gmu w3-hover-gmu w3-disbutton" >Congratulations!</a>
  </div>
</div>
</br></br>
<div class="w3-container w3-margin-top w3-center">
<p> Yay!! You are the Lucky Winner of the raffle. </p>
You have won two movie tickets. </br></br>
Your Score is : 
<p > Mean : ${dataBean.mean} </p>
<p> Standard Deviation : ${dataBean.stdDev} </p>

<form id="WinnerAck" method="get" action="Controller">
		<table class="cs-container cs-table">
		<caption class="cs-container cap-heading">Student Data</caption>
		<thead class="tablehead">
			<tr>
				<th>Student IDs</th>
			</tr>
		</thead>
		<% ArrayList<String> std = (ArrayList<String>)request.getAttribute("studentIds"); 
		for(String s:std){%>
		<tr>
			<td><a name="studID" href="Controller?param=<%=s%>"><%=s%></a></td>
		</tr>
			<%}%>
		</table>
</form>
</div>
</br></br></br></br></br>
<h1 style="text-align:center"> Thank you for filling out the form!</h1>


</body>
</html>