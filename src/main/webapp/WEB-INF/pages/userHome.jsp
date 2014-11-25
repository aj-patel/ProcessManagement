<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>UserHome</title>
</head>
<body>
	<h3>User Home Page</h3>
	<br >	
	<span id = "info" name="info">${info}</span>
	<form:form action="completeTask" method="post">
	<input type="hidden" value="${userId}" name="userId"/>
	<input type="hidden" value="${tid}" name="tid"/>
	<input type="button" value="Get Next" onclick="window.location.href='/ProcessManagement/admin/getTask'"><br><br>
	Task Name &nbsp &nbsp &nbsp :<input type="text" name="taskName" value="${taskName}"><br><br>	
   	Step  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp:<input type="text" name="step" value="${step}" /><br ><br>
	User Comment :<input type="text" name="comment" /><br><br>
	<input type="submit" value="done"/> 
	</form:form>
</body>
</html>