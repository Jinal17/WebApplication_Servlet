<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thank You for Filling Out the From</title>
</head>

<body>

<p> <h1> Better Luck Next Time!! </h1></p>
<p>Mean : ${dataBean.mean} </p>
<p>Standard Deviation : ${dataBean.stdDev} </p>

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
</body>
</html>