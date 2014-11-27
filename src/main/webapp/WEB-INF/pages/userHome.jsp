<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>UserHome</title>
</head>
<body>
       <h3>User Home Page</h3>
       <br >  
       <span id = "info" name="info">${info}</span>
       
       <span id = "info" name="info">${info}</span>
       <form:form action="completeTask" method="post">
       <span id = "info1" name="info1">${taskName}</span>
       <span id = "info2" name="info2">${taskDescription}</span>
       <input type="hidden" value="${userId}" name="userId"/>
       <input type="hidden" value="${tid}" name="tid"/>
       <input type="button" value="Get Next" onclick="window.location.href='/ProcessManagement/admin/getTask'"><br><br>
       Task Name &nbsp &nbsp &nbsp ${taskName}<br><br>       
       Task Description: ${taskDescription}<br ><br>
         Status:<br>
        <input type="radio" name="Status" value="Approved">Approved
       <input type="radio" name="Status" value="Disapproved">Disapproved<br><br>
        User Comment :<input type="text" name="comment" /><br><br>
       <input type="submit" value="done" /> 
       </form:form>
</body>
</html>
