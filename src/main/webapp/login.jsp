<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="orange">
<form action="login.do" method="post">
<font color="red">${InvalidMessage}
</font>
UserName:<input type="text" name="userName">
password:<input type="text" name="Password">

<input type="submit" value="login">
<input type="reset" value="cancel">
</form>
</body>
</html>