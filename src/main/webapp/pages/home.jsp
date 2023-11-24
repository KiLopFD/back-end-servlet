<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="base/head.jsp">
        <jsp:param name="title" value="Home"/>
    </jsp:include>
</head>
<body class="bg-slate-200">
<jsp:include page="base/header.jsp"/>
<main class="home-main-ctn relative">
    <section>
        <!-- Slider main container -->
        <div class="swiper w-full h-auto">
            <!-- Additional required wrapper -->
            <div class="swiper-wrapper">
                <!-- Slides -->
                <div class="swiper-slide relative">
                    <img class="w-full h-auto" src="<c:url value="/assets/images/section_1/phono-slider-1.jpg"/>"
                         alt="slider-1"/>
                    <div class="inner-ctn absolute right-0 top-0 pt-[3rem] w-full md:pt-[10rem] md:w-[40rem] xl:pt-[20rem] pr-0 lg:pr-[5rem] xl:w-[60rem]">
                        <p class="text-lg sm:text-2xl lg:text-3xl font-[600] text-center text-white">LIMITED EDITION</p>
                        <p class="title text-[1.5rem] sm:text-[3rem] lg:text-[4rem] text-center text-white">
                            SOUND IS LIVELY WITH DUAL AUDIO
                        </p>
                        <div class="flex justify-center py-5">
                            <a class="px-10 py-3 bg-black rounded-full cursor-pointer text-white border-2">SHOP NOW</a>
                        </div>
                    </div>
                </div>
                <div class="swiper-slide relative">
                    <img class="w-full h-auto" src="<c:url value="/assets/images/section_1/phono-slider-2.jpg"/>"
                         alt="slider-1"/>
                    <div class="inner-ctn absolute left-0 top-0 pt-[3rem] w-full md:pt-[10rem] md:w-[40rem] xl:pt-[20rem] pl-0 lg:pl-[5rem] xl:w-[60rem]">
                        <p class="text-lg sm:text-2xl lg:text-3xl font-[600] text-center text-black">4K RESOLUTION</p>
                        <p class="title text-[1.5rem] sm:text-[3rem] lg:text-[4rem] text-center text-black">
                            EXCLUSIVE STEEL FRAME
                        </p>
                        <div class="flex justify-center py-5">
                            <a class="px-10 py-3 bg-black rounded-full cursor-pointer text-white border-2">SHOP NOW</a>
                        </div>
                    </div>
                </div>
                <div class="swiper-slide relative">
                    <img class="w-full h-auto" src="<c:url value="/assets/images/section_1/phono-slider-3.jpg"/>"
                         alt="slider-1"/>
                    <div class="inner-ctn absolute right-0 top-0 pt-[3rem] w-full md:pt-[10rem] md:w-[40rem] xl:pt-[20rem] pr-0 lg:pr-[5rem] xl:w-[60rem]">
                        <p class="text-lg sm:text-2xl lg:text-3xl font-[600] text-center text-white">LIMITED EDITION</p>
                        <p class="title text-[1.5rem] sm:text-[3rem] lg:text-[4rem] text-center text-white">
                            FULL SCREEN DISPLAY PERFECTLY
                        </p>
                        <div class="flex justify-center py-5">
                            <a class="px-10 py-3 bg-black rounded-full cursor-pointer text-white border-2">SHOP NOW</a>
                        </div>
                    </div>
                </div>
                ...
            </div>

            <!-- If we need navigation buttons -->
            <div class="swiper-button-prev"></div>
            <div class="swiper-button-next"></div>

        </div>
    </section>
    <div class="inner-wrap">


    </div>
</main>
<%--<%= request.getServletContext().getInitParameter("title-home")%>--%>

<%--    My Script --%>

<script>
    <%@include file="../assets/scripts/jquery.js"%>
    <%@include file="../assets/scripts/header.js"%>
    <jsp:include page="../assets/scripts/swipper.js" />
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
</body>
</html>