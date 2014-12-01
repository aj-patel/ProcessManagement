<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<script>
	function validate_fields() {
		var empt = document.forms["adminForm"]["appName"].value;  
		if (empt == "")  
		{  
			document.getElementById("errorMessage").innerHTML = "Please enter the applicant name";
			return false;  
		} else if (document.forms["adminForm"]["processType"].value == 'default'){
			document.getElementById("errorMessage").innerHTML = "Please select the process type";
			return false; 
		} else {
			document.getElementById("errorMessage").innerHTML = "";
			return true;
		}
	}
</script>
<title>UserHome</title>
</head>
<body>
	<h3>Admin Home Page</h3>
		
	<form:form name="adminForm" action="/ProcessManagement/admin/createTask" onsubmit= "return validate_fields()">
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
    <br/><br/>
    <font id="errorMessage" color="red"></font>
	<h4>Create User:</h4>
	<a href="/ProcessManagement/admin/showCreateUser">Create User</a> 
	</form:form>
	${message}
</body>
</html>