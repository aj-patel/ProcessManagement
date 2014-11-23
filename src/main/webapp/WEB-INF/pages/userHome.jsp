<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>UserHome</title>
</head>
<body>
	<h3>User Home Page</h3>
	<br >	
	<form:form action="getTask" method="post">
	<input type="hidden" value='${userId}'/>
	<input type="button" value="Get Next"><br><br>
	<input type="submit" /> 
	</form:form>
	<form:form action="">
	Task Name &nbsp &nbsp &nbsp :<input type="text" name="taskName"><br><br>	
   	Step  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp:<input type="text" name="step" /><br ><br>
	User Comment :<input type="text" name="comment" /><br><br>
	<input type="submit" value="done"/> 
	</form:form>
</body>
</html>