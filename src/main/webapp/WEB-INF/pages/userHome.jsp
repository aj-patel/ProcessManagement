<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>UserHome</title>
</head>
<body>
       <h3>User Home Page</h3>
       <br >  
       <span id = "info" name="info">${info}</span><br><br>
       
       <form:form action="/ProcessManagement/process/completeTask" method="post">
       <input type="hidden" value="${userId}" name="userId"/>
       <input type="hidden" value="${tid}" name="tid"/>
       <input type="button" value="Get Next" onclick="window.location.href='/ProcessManagement/process/getTask'"><br><br>
       <b>Task Name:</b> &nbsp &nbsp &nbsp ${taskDetails.tsk_name}<br><br>       
       <b>Task Description:</b> ${taskDetails.tsk_desc}<br ><br>
        <b>Status:</b><br>
        <input type="radio" name="status" value="Approved" checked="checked">Approved
       <input type="radio" name="status" value="Disapproved">Disapproved<br><br>
       <b>User Comment:</b>&nbsp<input type="text" name="comment" /><br><br>
       <input type="submit" value="done" /> 
       </form:form>
</body>
</html>
