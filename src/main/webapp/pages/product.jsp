<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="base/head.jsp">
        <jsp:param name="title" value="Product"/>
    </jsp:include>
</head>
<body class="min-h-[60vh] bg-slate-200">
<jsp:include page="base/header.jsp"/>
<main class="home-main-ctn relative">
    <div class="inner-wrap container mx-auto py-10">
        <div class="wrapper cart flex flex-wrap gap-3 justify-center">
            <c:set var="listProducts" value="${requestScope.get('listProducts')}" scope="request"/>
            <c:if test="${listProducts != null}">
                <c:forEach var="item" items="${listProducts}">
                    <div class="cart-item max-w-[20rem] h-auto bg-slate-700 p-3 rounded-md">
                        <div class="ctn-wrapper h-[25rem] overflow-auto">
                            <div class="wrap-img p-7 overflow-hidden rounded-md mb-3">
                                <img class="w-full object-fit-contain rounded-md transition-all duration-500 hover:scale-150"
                                     src="<c:out value="${item.getUrlImg()}"/>"
                                     alt="<c:out value="${item.getProductName()}"/>"/>
                            </div>

                            <p class="product-name"><c:out value="${item.getProductName()}"/></p>
                            <p class="product-price">
                                <span class="">Price:</span>
                                <c:out value="${item.getPrice()}"/>
                            </p>
                        </div>

                        <div class="py-5 flex flex-wrap justify-center gap-3 items-center">
                            <a class="block px-5 py-2 bg-slate-600 rounded-sm transition-all duration-150 hover:scale-110"
                               href="<c:url value="/product?action=add-cart"/>">Add Cart</a>
                            <a class="block px-5 py-2 bg-slate-600 rounded-sm transition-all duration-150 hover:scale-110"
                               href="<c:url value="/product?action=detail-cart"/>">Detail</a>
                        </div>
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