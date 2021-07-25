<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<table border="1px solid black">
<tr>
<th>id</th>
<th>First Name</th>
<th>Last Name</th>
<th>User Name</th>
<th>Password</th>	
<th>Action</th>
</tr>
<c:forEach items="${sessionScope.list}" var="a">
<tr>
   <td>${a.id}</td>
   <td>${a.fname}</td>
   <td>${a.lname}</td>
   <td>${a.uname}</td>
   <td>${a.pname}</td>
   <td><button><a href ="insert1?id_del=${a.id}&flag=delete">delete</a></button>
   <a href ="insert1?id_edit=${a.id}&flag=edit">edit</a>
   </td>

</tr>

 </c:forEach>
</table>
</body>
</html>