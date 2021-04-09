<%-- Simple Acknowledgement JSP : This form Thanks user for filling out the form and 
	prints mean and standard deviation. With the use of Databean &   --%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thank You for Filling Out the Form!</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
 <link rel="stylesheet" type="text/css" href="css/edited.css">
</head>

<body class="back">
<div class="w3-top w3-margin-bottom">
  <div class="w3-container w3-gmu w3-center w3-margin-bottom">
    <a class="w3-bar-item w3-gmu w3-hover-gmu w3-disbutton" >Better luck next time!</a>
  </div>
</div>
</br></br>
<div class="w3-container w3-margin-top w3-center w3-margin-bottom">
<p> Your score is:</p>
<p>Mean : ${dataBean.mean} </p>
<p>Standard Deviation : ${dataBean.stdDev} </p>
</div>
<form id="SimpleAck" method="get" action="Controller">
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
</br></br></br></br></br>
<h1 style="text-align:center"> Thank you for filling out the form!</h1>
</body>
</html>