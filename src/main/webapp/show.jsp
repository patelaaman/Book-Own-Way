<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Data</title>
</head>
<body>
    <h2>Registration Data</h2>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Password</th>
            <th>Address</th>
        </tr>
        <c:forEach items="${student}" var="registration">
            <tr>
                <td>${registration.name}</td>
                <td>${registration.email}</td>
                <td>${registration.password}</td>
                <td>${registration.address}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
