<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <jsp:include page="../base/head.jsp">
        <jsp:param name="title" value="History Payment"/>
    </jsp:include>
</head>
<body>
<jsp:include page="../base/header.jsp"/>
<main class="py-10">
    <section class="history payment container mx-auto">
        <c:set var="listOrders" value="${requestScope.get('orders')}" scope="request"/>
        <c:if test="${listOrders.size()>0}">
<%--            Table History Payment --%>
            <div class="relative overflow-auto max-h-[40rem] h-auto  shadow-md sm:rounded-lg">
                <table class="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400 relative">
                    <thead class="text-xs text-gray-700 uppercase dark:text-gray-400 sticky top-0 left-0 z-[10]">
                    <tr>
                        <th scope="col" class="px-6 py-3 bg-gray-900 text-lg">
                            Product name
                        </th>
                        <th scope="col" class="px-6 py-3 text-lg">
                            Date Time
                        </th>
                        <th scope="col" class="px-6 py-3 bg-gray-900 text-lg">
                            Status
                        </th>
                        <th scope="col" class="px-6 py-3 text-lg">
                            Price
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="order" items="${listOrders}">
                        <c:forEach var="orderDetail" items="${order.getListOrderDetails()}">
                            <tr class="border-b border-gray-700 bg-inherit hover:bg-slate-800 transition-all duration-300 linear">

<%--                                Check Payment Pending --%>
                                <c:if test="${order.getStatusPayment()=='pending'}">
                                    <th scope="row"
                                        class="px-6 py-4 font-medium whitespace-nowrap text-white bg-gray-800 sm:w-auto w-[5rem]">
                                            ${orderDetail.getProductOfOrderDetail().getProductName()}
                                    </th>
                                    <td class="px-6 py-4 text-white bg-gray-800 sm:w-auto w-[5rem]">
                                            ${orderDetail.getDetailTime()}
                                    </td>
                                    <td class="px-6 py-4 text-white bg-gray-800">
                                            ${order.getStatusPayment()}
                                    </td>
                                    <td class="px-6 py-4 text-white bg-slate-800">
                                            ${orderDetail.getProductOfOrderDetail().getPrice()}
                                    </td>
                                </c:if>
                                <c:if test="${order.getStatusPayment()!='pending'}">
                                    <th scope="row"
                                        class="px-6 py-4 font-medium whitespace-nowrap text-white bg-gray-800 sm:w-auto w-[5rem]">
                                            ${orderDetail.getProductOfOrderDetail().getProductName()}
                                    </th>
                                    <td class="px-6 py-4 text-slate-400 sm:w-auto w-[5rem]">
                                            ${orderDetail.getDetailTime()}
                                    </td>
                                    <td class="px-6 py-4 bg-gray-50 dark:bg-gray-800">
                                            ${order.getStatusPayment()}
                                    </td>
                                    <td class="px-6 py-4 text-slate-400">
                                            ${orderDetail.getProductOfOrderDetail().getPrice()}
                                    </td>
                                </c:if>
                            </tr>
                        </c:forEach>
                    </c:forEach>


                    </tbody>
                </table>
            </div>
<%--            Total Price Payment Pending --%>
            <c:set var="totalPricePending" value="${requestScope.get('totalPricePending')}" scope="request"/>
            <div class="pending-payment bg-slate-900 py-5 rounded-md">
                <p class="text-white text-center mb-3">Total Pending Price: ${totalPricePending}$</p>
                <div class="wrapper-btn flex justify-center relative">
                    <a href="<c:url value="/payment?action=history&pay=y"/>" class="px-10 py-3 bg-slate-700 text-slate-300 rounded-md border-2 border-slate-700 hover:border-2 hover:bg-black hover:text-white transition-all duration-300 ease">Pay Pending Price</a>
                    <c:set var="currentWallet" value="${sessionScope.get('money')}" scope="session"/>
                    <c:if test="${currentWallet.compareTo(totalPricePending)==-1 || totalPricePending==0}">
                        <div class="disable-cart-action absolute w-full h-full z-[50] cursor-not-allowed"></div>
                    </c:if>
                </div>
            </div>
        </c:if>
    </section>
</main>

<script>
    <%@include file="../../assets/scripts/header.js"%>
</script>
</body>
</html>
