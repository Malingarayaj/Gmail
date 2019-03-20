<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.clearfix::after {
  content: "";
  clear: both;
  display: table;
  background-color: green;
  
}



</style>
<title>Registration Page</title>
</head>
<body 
bgcolor="orange" >
<h1><font color="blue">Welcome to Registration Page </font></h1>

<form action="reg.do" method="post">
<h3>
<b>
<font color="red">
${emsg }
</font>
</b>
</h3>
<div class="container" align="center" style="background-color: green;display: inline-block;">
<pre>
Name:<input type="text" name="cname"/>
Mobile Number:<input type="text" name="cmobileNo"/>
Password:<input type="text" name="password"/>
DOB:<input type="text" name="dob"/> </pre>
Gender:Male<input type="radio" name="gender" value="M"/>
      Female<input type="radio" name="gender" value="F"/>
      NA<input type="radio" name="gender" value="NA"/>
     
      <pre>
Email:<input type="text" name="email"/>
Location:<input type="text" name="location"/>
Education:<input type="text" name="education"/>
Experience:<input type="text" name="experience"/>
Skill set:<input type="text" name="skill">
Description:<textarea name="description" rows="10" cols="20"></textarea>
</pre>
</div>

<div class="clearfix">
      <input type="reset" class="cancelbtn"/>Cancel
      <input type="submit" class="signupbtn"/>Sign Up
      
    </div>  
</form>
</body>
</html>