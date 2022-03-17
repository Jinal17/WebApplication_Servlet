Web Application Using Servlet, JSP, JDBC & Oracle Database



####Project Description####

This project focuses on server-side processing of the Student Survey Form data via MVC
implementation using a RequestDispatcher object. The implementation requires you to
implement one Servlet that acts as a front controller that receives all client requests, saves the
form data to a database table, performs business logic(s) via business delegate classes, stores
JavaBean objects into a session or request object, and then forwards the request to appropriate
JSP to present the data to the user. The assignment requires all business logic code into separate
Java class(es) which could be called from within the servlet to perform specific tasks. All
presentation logic is moved to JSP pages. 

####GitHub Repo####
[https://github.com/Jinal17/WebApplication_Servlet](https://github.com/Jinal17/WebApplication_Servlet)

####Software and jar files Required

1. Eclipse IDE for Java EE Developers <br/>
2. Apache Tomcat 8.5 or 10 <br/>
3. Cisco AnyConnect VPN <br/>
4. ojdbc8.jar, javax.servlet-api-3.0.1.jar <br/>


####Installation Instructions
1. Install Eclipse and Tomcat. Configure Tomcat with Eclipse IDE<br/><br/>
2. Install Cisco AnyConnect VPN (Ref: https://its.gmu.edu/service/virtual-private-network-vpn/) and connect to vpn.gmu.edu using your username and password<br/><br/>
3. Unzip the file which contains .war, .zip and readme.md file<br/><br/>
4. Activate oracle database account and Connect to oracle database (Ref: https://labs.vse.gmu.edu/index.php/Services/Oracle#connect )<br/><br/>
5. Create table(student) using below query. Use username:jshah21 password:abeckoab <br/><br/>

	create table studentform (
	studentid varchar(20),
	username varchar2(20), 
	streetaddress varchar2(50),
	city varchar2(50),
	state varchar2(10),
	zipcode varchar(20),
	phoneno varchar2(20),
	email varchar(50),
	hsgradmonth varchar2(20),
	hsgradyear varchar(20),
	likedmost varchar(20),
	interested varchar(20),
	comments varchar(100),
	recommend varchar(40)
	);

6. Import the war file in the Eclipse. <br/><br/>
	Eclipse -> File -> Import -> filter with 'war' and 
	click Next -> Browse for this 'war' file -> Choose Tomcat v8.5 or v10 --> Choose ojdbc8.jar, javax.servlet-api-3.0.1.jar --> Click Finish <br/><br/>
	After importing the .war file if it shows Error "Faceted Project Problem (Java Version 			Mismatch)" then <br/><br/>
	Right-click on project name -> Properties -> Project Facets -> Select Java Version 14 and 		Apply.<br/><br/>
7. Run the project. Right-click on the project -> Run As -> 1 Run on Server<br/><br/>
