<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>UserHome</title>
</head>
<body>
	<h3>Create User Page</h3>
	<br >
<form action="/ProcessManagement/admin/addUsers" method="post">  
User name: <input type="text" name="userName"/><br/><br/>  
Password:<input type="password" name="password"/><br/><br/>  
Role:&nbsp &nbsp&nbsp &nbsp
<select name="role"><br/>
Role: <option value="Select">Select</option>
<option value="0">Admin</option>
<option value="11">SSE</option>
<option value="12">TL</option>
<option value="13">Manager</option>
<option value="14">HR Mgr</option>
</select>
<input type="submit" />  
</form>
${message}
</body>
</html>