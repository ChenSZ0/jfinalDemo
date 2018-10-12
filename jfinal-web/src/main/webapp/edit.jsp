<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit</title>
</head>
<body>
    <h2> edit page</h2><br>
<form action="/student/update" method="post">
    <input type="hidden" name="student.id" value="<%=request.getAttribute("id")%>"><br>
    name:<br>
    <input type="text" name="student.name" value="<%= request.getAttribute("name")%>"><span style="color: red"><%=request.getAttribute("errorName")%></span><br>
    age:<br>
    <input type="text" name="student.age" value="<%= request.getAttribute("age")%>"><span style="color: red"><%=request.getAttribute("errorAge")%></span><br>
    <input type="submit" value="提交">
</form>

</body>
</html>
