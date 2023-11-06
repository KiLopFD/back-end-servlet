<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Home</title>
    <%@include file="base/style.jsp"%>
</head>
<body>
    <jsp:include page="base/header.jsp"/>
    ${name}
    <%= request.getServletContext().getInitParameter("title-home")%>

    <%--    My Script --%>
    <script>
        <%@include file="../assets/scripts/header.js"%>
    </script>
</body>
</html>