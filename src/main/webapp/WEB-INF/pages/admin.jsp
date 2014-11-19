<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Login</title>
</head>
<body>
	<h3>Login Page</h3>
	<br />
	<form:form method="POST" action="admin/login">  
	Enter User Name:<input type="text" name="username">
		<br />
   	Enter Password :<input type="password" name="password" />
		<br />
		<input type="submit">
	</form:form>
</body>
</html>

