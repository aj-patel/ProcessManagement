<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>UserHome</title>
</head>
<body>
	<h3>Admin Home Page</h3>
		
	<form:form action="createTask">
	<h4>Start Process:</h4>
	Applicant Name &nbsp:
	<input type="text" name="appName">&nbsp &nbsp
	Process Type &nbsp:
	<select name="processType" style="width: 100px !important; min-width: 100px; max-width: 100px;">
		<option value="default" disabled selected="selected">--Select--</option>
		<option value=1>Interview</option>
	</select>
	&nbsp &nbsp 	
    <input type="submit" value="Inititate process"/>
	<h4>Create User:</h4>
	<a href="showCreateUser">Create User</a> 
	</form:form>
</body>
</html>