<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>UserHome</title>
</head>
<body>
	<h3>Login Page</h3>
	<br />
	<form:form method="POST" action="login">  	
	User Name  :<input type="text" name="username" />
		<br />
		<br />	
   	Password &nbsp &nbsp :<input type="password" name="password" />
		<br />
		<br />
		<input type="submit" />
	</form:form>
</body>
</html>