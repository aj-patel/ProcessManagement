<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>UserHome</title>
</head>
<body>
	<h3>Create User Page</h3>
	<br >
<form action="" method="post">  
Name: &nbsp &nbsp   <input type="text" name="name"/><br/><br/>  
UserID: &nbsp <input type="number" name="userId"/><br><br/>
Password:<input type="password" name="password"/><br/><br/>  
Address:&nbsp <input type="text" name="address"/><br><br/>
Role:&nbsp &nbsp&nbsp &nbsp
<select name="Role"><br/>
Role: <option value="Select">Select------------</option>
<option value="Developer">Developer</option>
<option value="Admin">Admin</option>
<option value="Bussiness Analyst">BusinessAnalyst</option>
<option value="QA">QA</option>
<option value="manager">Manager</option>
<option value="Team Lead">TeamLead</option>
</select>
<input type="submit" value="login"/>  
</form>
</body>
</html>