<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Add Users</title>
</head>
<body>
	<h3>Add Users</h3>
	<br />
	<form:form method="POST" action="addUsers">  
	Enter User Name:<input type="text" name="userName">
		<br />
   	Enter Password :<input type="password" name="password" />
		<br />
	Enter Role :<input type="text" name="role" />
		<input type="submit">
	</form:form>
</body>
</html>