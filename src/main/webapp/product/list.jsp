<%--
  Created by IntelliJ IDEA.
  User: S
  Date: 6/2/2022
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="">
    <input type="text" name="name">
    <button>Tim</button>
</form>
asfawf
<c:forEach var="product" items="${ds}">
    <h2>${product.name}</h2>
</c:forEach>
</body>
</html>
