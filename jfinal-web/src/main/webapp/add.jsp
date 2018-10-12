<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
</head>
<body>
    <h2> add page</h2><br>
<form action="/student/save" method="post">
    name:<br>
    <input type="text" name="student.name" value=""><span style="color: red"><%=request.getAttribute("errorName")%></span><br>
    age:<br>
    <input type="text" name="student.age"><span style="color: red"><%=request.getAttribute("errorAge")%></span><br>
    <input type="submit" value="提交">
</form>

</body>
</html>
