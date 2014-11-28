<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>UserHome</title>
</head>
<body>
	<h3>Create User Page</h3>
	<br >
<form action="addUsers" method="post">  
User name: <input type="text" name="userName"/><br/><br/>  
Password:<input type="password" name="password"/><br/><br/>  
Role:&nbsp &nbsp&nbsp &nbsp
<select name="role"><br/>
Role: <option value="Select">Select</option>
<option value="ADMIN">ADMIN</option>
<option value="SSE">SSE</option>
<option value="TL">TL</option>
<option value="Manager">Manager</option>
<option value="HR Mgr">HR Mgr</option>
</select>
<input type="submit" />  
</form>
</body>
</html>
