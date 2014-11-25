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
<option value="11">Developer</option>
<option value="Admin">Admin</option>
<option value="Bussiness Analyst">BusinessAnalyst</option>
<option value="QA">QA</option>
<option value="manager">Manager</option>
<option value="Team Lead">TeamLead</option>
</select>
<input type="submit" />  
</form>
</body>
</html>