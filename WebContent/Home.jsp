<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*" %>
 <%@ page import="Dao.RegistrationDao ,Bean.RegistrationBean" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
<h1 align="center">Home Page</h1>
<hr>
<div>
	<a href="Registration.jsp">New Registration</a>
</div>
<div align="center">
				<table border="1" cellpadding="4" >
					<tr>
						<td>Sr. No.</td>
						<td>Name</td>
						<td>Address</td>
						<td>Contact</td>
						<td>Email</td>
						<td colspan="2">Actions</td>
					</tr>
					<%
						int i=0;
						List<RegistrationBean> li = RegistrationDao.getData();
						request.getAttribute("data");
						for(RegistrationBean ob:li)
						{
							System.out.println("In home jsp:"+ob.getId());
					%>
						
					<tr>
					<td><%=++i %></td>
					<td><%=ob.getName() %></td>
					<td><%=ob.getAddress() %></td>
					<td><%= ob.getContact() %></td>
					<td><%= ob.getEmail()%></td>	
					<td><a href="Update.jsp?id=<%= ob.getId()%>">Update</a>&nbsp;/
					<a href="deleteservlet?id=<%= ob.getId() %>">Delete</a></td>
					
					<%} %>	
				</table>
			</div>

</body>
</html>