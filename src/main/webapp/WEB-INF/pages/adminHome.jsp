<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>UserHome</title>
</head>
<body>
	<h3>Admin Home Page</h3>
		
	<form:form action="">
	<h4>Create Task:</h4>
	Enter Task Name &nbsp:<input type="text" name="taskName">&nbsp &nbsp 	
        <a href="">Submit task</a><br><br>
	<h4>Create User:</h4>
	<a href="createUser.jsp">Create User</a><br><br>
	</form:form>
</body>
</html>