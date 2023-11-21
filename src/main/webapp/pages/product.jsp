<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="base/head.jsp">
        <jsp:param name="title" value="Product"/>
    </jsp:include>
</head>
<body>
<jsp:include page="base/header.jsp"/>
<main class="home-main-ctn relative">
    <div class="inner-wrap container mx-auto py-10">
        <div class="wrapper cart flex flex-wrap gap-3 justify-center">
            <c:set var="listProducts" value="${requestScope.get('listProducts')}" scope="request"/>
            <c:if test="${listProducts != null}">
                <c:forEach var="item" items="${listProducts}">
                    <div class="cart-item max-w-[20rem] h-[30rem] bg-slate-700 p-3 rounded-md">
                        <div class="wrap-img p-7 overflow-hidden">
                            <img class="w-full object-fit-contain rounded-md" src="<c:out value="${item.getUrlImg()}"/>"
                                 alt="<c:out value="${item.getProductName()}"/>"/>
                        </div>

                        <p class="product-name"><c:out value="${item.getProductName()}"/></p>
                        <p class="product-price">
                            <span class="">Price:</span>
                            <c:out value="${item.getPrice()}"/>
                        </p>

                    </div>
                </c:forEach>
            </c:if>

        </div>

    </div>
</main>
<%--<%= request.getServletContext().getInitParameter("title-home")%>--%>

<%--    My Script --%>

<script>
    <%@include file="../assets/scripts/jquery.js"%>
    <%@include file="../assets/scripts/header.js"%>
</script>
</body>
</html>