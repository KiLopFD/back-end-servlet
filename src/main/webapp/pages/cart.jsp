<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <jsp:include page="base/head.jsp">
        <jsp:param name="title" value="Cart"/>
    </jsp:include>
</head>
<body>
<jsp:include page="base/header.jsp"/>
<main class="cart grid place-items-center min-h-[60vh] h-auto sm:p-0 p-3">
    <section class="cart-section w-full sm:w-[75vw] bg-slate-200 p-2 sm:p-5 rounded-md overflow-x-auto h-auto">
        <div class="info-cart">
            <div class="name-cart-item p-0 sm:p-3">
                <div class="title-data flex border-b-2 border-black">
                    <p class="name hidden sm:block font-[600] text-2xl text-black w-[6rem] text-center">Index</p>
                    <p class="name font-[600] text-md sm:text-2xl text-black sm:w-[20rem] w-[12rem] text-center">Name Product</p>
                    <p class="name font-[600] text-md sm:text-2xl text-black w-[6rem] text-center">Quantity</p>
                    <p class="name font-[600] text-md sm:text-2xl text-black w-[10rem] text-center">Action</p>
                    <p class="name hidden sm:block font-[600] text-2xl text-black w-[10rem] text-center">Price</p>

                </div>
                <c:set var="listCarts" value="${requestScope.get('listCarts')}" scope="request"/>
                <c:if test="${listCarts!=null}">
                    <div class="">
<%--                        Create Information Cart--%>
                        <c:forEach var="cart" items="${listCarts}">
                            <form class="" method="get" action="<c:url value="/cart"/>">
                                <div class="row-data flex items-stretch block w-full">
                                    <div class="w-[6rem] hidden md:grid border-r-2 border-b-2 border-black place-items-center">
                                        <input checked class="h-5 w-5 check-<c:out value="${cart.getCartId()}"/>" type="checkbox" name="pkCart"
                                               value="<c:out value="${cart.getCartId()}"/>">
                                    </div>
                                    <p class="text-lg sm:w-[20rem] w-[12rem] border-r-2 border-b-2 border-black py-2"><c:out
                                            value="${cart.getProduct().getProductName()}"/></p>
                                    <div class="border-r-2 border-b-2 border-black px-2 grid place-items-center w-[6rem]">
                                        <input type="hidden" name="pkProduct" value="${cart.getProduct().getProductId()}">
                                        <input class="rounded-full h-[2.3rem] pl-5 border-r-2 w-full" type="text"
                                               name="quantity" value="<c:out value="${cart.getQuantity()}"/>"/>
                                    </div>
                                    <div class="group-action py-2 flex border-r-2 border-b-2 border-black w-[10rem] grid place-items-center">
                                        <div class="remove-item inline-block px-5 py-1 bg-slate-300 rounded-md mb-1 hover:bg-slate-600 hover:text-white transition-all duration-300 ease">
                                            <button type="submit" name="actionCart" value="remove">Remove</button>
                                        </div>
                                        <div class="update-item inline-block px-5 py-1 bg-slate-300 rounded-md hover:bg-slate-600 hover:text-white transition-all duration-300 ease">
                                            <button type="submit" name="actionCart" value="update">Update</button>
                                        </div>
                                    </div>
                                    <div class="detail-price hidden md:grid  w-[10rem] border-r-2 border-b-2 border-black place-items-center">
                                        <div>
                                            <p class="origin-price">
                                                <span>Origin:</span>
                                                <c:out value="${cart.getProduct().getPrice()}"/>
                                            </p>
                                            <p class="origin-price">
                                                <span>Total</span>
                                                <c:out value="${cart.getProduct().getPrice()*cart.getQuantity()}"/>
                                            </p>
                                        </div>
                                    </div>
                                </div>

                            </form>
                        </c:forEach>
<%--                        Action To Check Out All Or Specific Items --%>
                        <c:set var="totalAmount" value="${requestScope.get('totalAmount')}" scope="request"/>
                        <p class="pt-5 text-center text-xl text-black font-[600]">
                            Total Price:
                            <c:out value="${totalAmount}"/>
                        </p>
                        <div class="action flex py-10 grid place-items-center">
                            <div class="flex flex-wrap gap-5 relative">
                                <a class="text-xl text-black font-[500] check-out-all px-5 py-3 bg-slate-300 rounded-md hover:bg-slate-900 hover:text-white transition-all duration-300 ease-in-out" href="<c:url value="/cart?actionCart=checkOutAll"/>">Checkout All</a>
                                <a class="text-xl text-black font-[500] check-out-idx px-5 py-3 bg-slate-300 rounded-md hover:bg-slate-900 hover:text-white transition-all duration-300 ease-in-out" href="<c:url value="/cart?actionCart=checkOutIdx"/>">Checkout Selected</a>
<%--                                Disable Action When Not Exist Cart--%>
                                <c:set var="quantityCart" value="${sessionScope.get('quantityCart')}" scope="session"/>
                                <c:if test="${quantityCart==0}">
                                    <div class="disable-cart-action absolute w-full h-full z-[50] cursor-not-allowed">
                                    </div>
                                </c:if>
                            </div>


                        </div>
                    </div>

                </c:if>
            </div>

        </div>

    </section>
</main>

<script>
    <%@include file="../assets/scripts/header.js"%>
</script>
<script>

</script>
</body>
</html>
