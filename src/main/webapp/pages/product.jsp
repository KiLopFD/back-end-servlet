<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="base/head.jsp">
        <jsp:param name="title" value="Product"/>
    </jsp:include>

</head>
<body class=" bg-slate-200 overflow-x-hidden w-full h-auto">
<jsp:include page="base/header.jsp"/>
<main class="home-main-ctn relative min-h-[90vh]">
    <div class="inner-wrap container mx-auto py-10">
        <div class="wrapper cart flex flex-wrap gap-3 justify-center">
            <c:set var="listProducts" value="${requestScope.get('listProducts')}" scope="request"/>
            <c:if test="${listProducts.size()>0}">
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
                            <c:set var="sort" value="${requestScope.get('sort')}" scope="request"/>
                            <a class="block px-5 py-2 bg-slate-600 rounded-sm transition-all duration-150 hover:scale-110"
                               href="<c:url value="/product?action=add-item-${item.getProductId()}&sort=${sort}"/>">Add Cart</a>
                            <a class="block px-5 py-2 bg-slate-600 rounded-sm transition-all duration-150 hover:scale-110"
                               href="<c:url value="/product?action=detail-cart-${item.getProductId()}"/>">Detail</a>
                        </div>
                    </div>
                </c:forEach>
            </c:if>

        </div>

    </div>
</main>
<%--<%= request.getServletContext().getInitParameter("title-home")%>--%>

<%--    My Script --%>

<%--Footer --%>
<jsp:include page="base/footer.jsp" />
<script>
    <%@include file="../assets/scripts/jquery.js"%>
    <%@include file="../assets/scripts/header.js"%>
</script>
<script>
    <jsp:include page="../assets/scripts/swipper.js" />
</script>
<script>
    <jsp:include page="../assets/scripts/headjs.js" />
</script>
<script>
    <jsp:include page="../assets/scripts/reveal.js" />
</script>
<script>
    <jsp:include page="../assets/scripts/scrollReivew.js" />
</script>
<script>
    const animateSR = (className, direction="bottom", duration = 1000, delay = 300 ) => {
        let cartItem = document.getElementsByClassName(className);
        [...cartItem].forEach((value, index) => {
            let nameSr = "sr-"+(index);
            value.classList.add(nameSr);
            ScrollReveal().reveal("."+nameSr, {
                distance: '100%',
                origin: direction,
                opacity: '0',
                delay: index * delay + delay,
                duration: duration + (index  * delay + delay),
                reset: true
            });
        })
    }


    document.addEventListener("DOMContentLoaded", ()=>{
        animateSR("cart-item");
    })

</script>

<script>
    const swiper = new Swiper('.swiper', {
        // Optional parameters
        direction: 'horizontal',
        loop: true,
        autoplay: {
            delay: 3000,
        },
        effect: 'fade',
        fadeEffect: {
            crossFade: true
        },

        // If we need pagination
        pagination: {
            el: '.swiper-pagination',
        },

        // Navigation arrows
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },

        // And if we need scrollbar
        scrollbar: {
            el: '.swiper-scrollbar',
        },
    });

</script>
<script>
    Reveal.initialize(
        {
            autoSlide: 5000,
            loop: true,
            view: 'scroll',

            // Force the scrollbar to remain visible
            scrollProgress: true
        }
    );
</script>
<script>
    // Smooth scroll

    // ScrollReveal().reveal('.sr-1', {
    //     distance: '150%',
    //     origin: 'bottom',
    //     opacity: '0',
    //     delay: 200,
    //     reset: true
    // });
    // ScrollReveal().reveal('.sr-2', {
    //     distance: '150%',
    //     origin: 'bottom',
    //     opacity: '0',
    //     delay: 500,
    //     reset: true
    // });
    // ScrollReveal().reveal('.sr-3', {
    //     distance: '150%',
    //     origin: 'bottom',
    //     opacity: '0',
    //     delay: 1000,
    //     reset: true
    // });

    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function (e) {
            e.preventDefault();

            document.querySelector(this.getAttribute('href')).scrollIntoView({
                behavior: 'smooth'
            });
        });
    });
</script>

</body>
</html>