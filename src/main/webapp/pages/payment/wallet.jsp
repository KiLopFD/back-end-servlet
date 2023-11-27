<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <jsp:include page="../base/head.jsp">
        <jsp:param name="title" value="My Wallet"/>
    </jsp:include>
</head>
<body>
<jsp:include page="../base/header.jsp"/>
<main>
    <section class="wallet grid place-items-center min-h-[50vh] h-auto">
        <div class="wrapper w-full sm:w-[30rem] p-5 bg-slate-200 h-auto">
            <p class="mb-3 text-xl text-black font-[600] text-center">Wallet</p>
            <form class="" action="<c:url value="/payment"/>" method="post">
                <div class="wrapp-input px-10">
                    <input class="block w-full py-2 rounded-md pl-2" name="money"/>
                </div>
                <div class="group-btn py-5 flex justify-center">
                    <button name="action" value="wallet" class="px-10 py-3 bg-slate-700 rounded-md text-xl hover:bg-black hover:text-white transition-all duration-300 ease" type="submit">Push</button>
                </div>
            </form>
        </div>
    </section>
</main>

<script>
    <%@include file="../../assets/scripts/header.js"%>
</script>
</body>
</html>
