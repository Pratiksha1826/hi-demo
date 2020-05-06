<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*" %>
 <%@ page import="Dao.RegistrationDao ,Bean.RegistrationBean" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Update Data</h1>
<hr>
<form action = "userupdateaction" method="post" >
	<div align="center" >
	
	<%
	String id = request.getParameter("id");
	int Id = Integer.parseInt(id);
	List<RegistrationBean> li = RegistrationDao.getDataById(Id);
	request.getAttribute("data");
	for(RegistrationBean ob:li)
	{
		System.out.println("In home jsp:"+ob.getName());
	
	
	%>
	<div>
	<input type="hidden" name="id" value="<%=Id%>">
	</div>
	<table>
		<tr>
			<td>Name</td>
			<td><input type="text"  name="name" id="nameid" value="<%=ob.getName()%>"></td>
		</tr>
	
		<tr>
			<td>Address</td>
			<td><textarea  id="addressid" name="address"><%=ob.getAddress()%></textarea></td>
		</tr>
	
		<tr>
			<td>Contact</td>
			<td><input type="text" id="contactid" name="contact" value="<%=ob.getContact()%>"></td>
		</tr>
	
		<tr>
			<td>Email</td>
			<td><input type="email" name="email" id="emailid" value="<%=ob.getEmail()%>"></td>
		</tr>
	<%} %>
		<tr>
			<td><button type="Submit">Update</button></td>
		</tr>
	</table>
	
</form>
</body>
</html>