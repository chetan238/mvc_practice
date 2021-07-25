<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container ml-5">
		<form class="form" method="post"
			action="<%=request.getContextPath()%>/insert1">
			<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
			<c:forEach items="${sessionScope.list}" var="a">
			 <c:set value="${a.id}" var="x"></c:set>
             <c:set value="${a.fname}" var="b"></c:set>
             <c:set value="${a.lname}" var="c"></c:set>
             <c:set value="${a.uname}" var="d"></c:set>
    		 <c:set value="${a.pname}" var="e"></c:set>         
				
			</c:forEach>
			<label>Enter First Name </label>
				<input type="text" class="form-control" name="fname" value="${b}">
			 Enter Last Name : <input type="text" class="form-control" name="lname" value="${c}">
			 User Name : <input type="text" class="form-control" name="uname" value="${d}"> 
			 pswd :<input type="text" class="form-control" name="pname" value="${e}">
				<input type="hidden" name="flag" value="editdb">
				<input type="hidden" name="uid" value="${x}">
				
				<input type="submit" class="btn btn-success">
		</form>
		<a href="<%=request.getContextPath()%>/insert1?flag=search">search
			here</a>
	</div>
</body>
</html>