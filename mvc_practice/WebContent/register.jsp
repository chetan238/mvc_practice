<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container ml-5">
<form class="form" method="post" action="<%=request.getContextPath()%>/insert1" >

<label >Enter First Name </label> <input type="text" class="form-control" name="fname">

Enter Last Name :  <input type="text" class="form-control" name="lname">
User Name :  <input type="text" class="form-control" name="uname">
pswd :  <input type="text" class="form-control" name="pname">
   <input type="hidden" name="flag" value="insert"> <input type="submit" class="btn btn-success">
  
</form>
<a href="<%=request.getContextPath() %>/insert1?flag=search">search here</a>
</div>
</body>
</html>