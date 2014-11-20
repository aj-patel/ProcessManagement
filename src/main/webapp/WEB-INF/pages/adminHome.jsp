<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>UserHome</title>
</head>
<body>
	<h3>Admin Home Page</h3>
		
	<form:form action="createTask">
	<h4>Create Task:</h4>
	Enter Task Name &nbsp:<input type="text" name="taskName">&nbsp &nbsp 	
      <input type="submit" />
	<h4>Create User:</h4>
	<a href="showCreateUser">Create User</a> 
	</form:form>
</body>
</html>