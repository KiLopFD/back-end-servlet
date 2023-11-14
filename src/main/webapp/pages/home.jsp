<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="base/head.jsp">
        <jsp:param name="title" value="Home"/>
    </jsp:include>
</head>
<body>
<jsp:include page="base/header.jsp"/>
<main class="home-main-ctn relative">
    <div class="inner-wrap container mx-auto">
        <div>
            <p class="title hover:text-black">Choose for you one best phone</p>
            <p class="desc"></p>
        </div>
        <div>
        </div>

</main>
<%= request.getServletContext().getInitParameter("title-home")%>

<%--    My Script --%>

<script>
    <%@include file="../assets/scripts/jquery.js"%>
    <%@include file="../assets/scripts/header.js"%>
</script>
</body>
</html>