<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
</head>
<body >
<h1 align="center">Registration</h1>
<hr>
<form action = "RegistrationAction" method="post" >
	<div align="center" >
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text"  name="name" id="nameid"></td>
			</tr>
		
			<tr>
				<td>Address</td>
				<td><textarea  id="addressid" name="address"></textarea></td>
			</tr>
		
			<tr>
				<td>Contact</td>
				<td><input type="text" id="contactid" name="contact"></td>
			</tr>
		
			<tr>
				<td>Email</td>
				<td><input type="email" name="email" id="emailid"></td>
			</tr>
			
			<tr>	
				<td><button type="submit" >Submit</button></td>
			</tr>
		</table>
	</div>
</form>
</body>
</html>