<!-- StudentJSP using RequestDispatcher object to display the student data to the user. 
The structure of the StudentJSP page for the retrieved data could be similar to the 
Survey Form in a read only format.  -->

<%@page import="main.java.bean.StudentBean"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css" /> --%>
<title>Student Survey Details</title>
 <link rel="stylesheet" type="text/css" href="css/edited.css">
</head>
<body class="back">
	<!-- Display students survey records -->
	<div class="w3-top w3-margin-bottom">
  <div class="w3-container w3-gmu w3-center w3-margin-bottom">
    <a class="w3-bar-item w3-gmu w3-hover-gmu w3-disbutton" >Student Survey Records</a>
  </div>
</div>
</br></br>
<div class="w3-container w3-margin-top">
	<table>
		
		<%	StudentBean std = new StudentBean();
			std = (StudentBean) request.getAttribute("studentRecord");
		%>
		<tr>
			<td>Student ID</td>
			<td><%=std.getStudentId() %></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><%=std.getUsername() %></td>
		</tr>
		<tr>
			<td>Street Address</td>
			<td><%=std.getStreetAddress() %></td>
		</tr>
		<tr>
			<td>City</td>
			<td><%=std.getCity() %></td>
		</tr>
		<tr>
			<td>State</td>
			<td><%=std.getState() %></td>
		</tr>
		<tr><%-- 
			<td>Zip</td>
			<td><%=std.getZip() %></td>
		</tr>
		<tr>
			<td>Telephone</td>
			<td><%=std.getTelephone() %></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><%=std.getMail() %></td>
		</tr> --%>
		<tr>
			<td>URL</td>
			<td><%=std.getUrl() %></td>
		</tr>		
		<%-- <tr>
			<td>Interested in the university because</td>
			<td><%=std.getIntrestinuni() %></td>
		</tr>
		<tr>
			<td>Additional Comments</td>
			<td><%=std.getAdditionalcomments() %></td>
		</tr>
		<tr>
			<td>High-school graduation month-year</td>
			<td><%=std.getHighschlgradmonth() %>&nbsp;<%=std.getHighschlgradyear() %></td>
		</tr>
		<tr>
			<td>Recommending this school to other students</td>
			<td><%=std.getRecos() %></td>
		</tr> --%>
	</table>
	</div>
</body>
</html>