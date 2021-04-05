<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>No Student Found.</title>
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
    <a class="w3-bar-item w3-gmu w3-hover-gmu w3-disbutton" >Form acknowledgement</a>
  </div>
</div>
<div style="margin:300px">
<form id="NoStudent" method="get" action="Controller">
		<% ArrayList<String> std = (ArrayList<String>)request.getAttribute("studentIds"); 
		if(std == null){%>
			<h2 style="text-align: center; border: 5px solid #006633; box-shadow: 10px 15px 10px;">No Such Student found with the given student ID.</h2>
			<%}%>
</form>
</div>
</body>
</html>