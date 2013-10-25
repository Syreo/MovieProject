	<%@page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="org.springframework.security.core.AuthenticationException"%>
<%@ page
	import="org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter"%>
<%@ page
	import="org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
	
	<html>
	<title>Login</title>
	<head></head>
	<body>
	<div id="backgroundDiv" class = "backgroundClass">

		<div id="loginMessage">Login</div>

		<div id="loginForm">
		<form method="post" action="j_spring_security_check" id="formlogin"
				name="formlogin">
				<label>User Name:</label> <input type="text" name="j_username"
						id="j_username" /> <br /> <label>Password:</label> <input
						type="password" name="j_password" id="j_password" value="" /> <br />
					<input type="submit" value="Login" id="Login" />
					<button name="registerpage" class="navigationbutton"
						id="registerpage">New User</button>
				</form>
<!-- 			<table> -->
<!-- 			<tbody> -->
				
<!-- 				<tr><th class="label">Username </th><td><input type="text" -->
<!-- 					class="inputField" id = "userName" name="userName" placeholder="Enter Username" /></td></tr> -->
<!-- 				<tr><th class="label">Password </th><td><input type="password" -->
<!-- 					class="inputField" id = "password" name="password" placeholder="Enter Password" /></td></tr> -->
				
				
<!-- 				</tbody> -->
<!-- </table> -->
<!-- <br><br> -->
<!-- 				<div id="loginButtonDiv"> -->
<!-- 					<button value="Login" name="login" id="loginButton" >Login</button> -->


<!-- 					<input type="submit" name="cancel" value = "Cancel" id="cancelButton"/> -->
						
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div align="center" id="errorMessageDiv"></div> -->
		
	</div>
	</div>
	</body></html>