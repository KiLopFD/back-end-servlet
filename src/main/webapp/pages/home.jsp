<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="base/head.jsp">
        <jsp:param name="title" value="Home"/>
    </jsp:include>
</head>
<body class="bg-[#fdfdfd] overflow-x-hidden w-full h-auto">
<jsp:include page="base/header.jsp"/>
<main class="home-main-ctn h-auto min-h-[90vh]">
    <section class="w-full p-0 min-h-screen h-auto" id="sec1">
        <div class="wrapper h-auto w-full flex flex-col items-center">
            <!-- Slider main container -->
            <div class="swiper-one w-full">
                <!-- Additional required wrapper -->
                <div class="swiper-wrapper">
                    <!-- Slides -->
                    <div class="swiper-slide relative">
                        <img class="w-full h-auto"
                             src="https://phono-demo.myshopify.com/cdn/shop/files/phono-slider-1.jpg?v=1613704452&width=1500"
                             alt="slider-1"/>
                        <div class="inner-ctn absolute right-0 top-0 pt-[3rem] w-full md:pt-[10rem] md:w-[40rem] xl:pt-[20rem] pr-0 lg:pr-[5rem] xl:w-[60rem]">
                            <p class="text-lg sm:text-2xl lg:text-3xl font-[600] text-center text-white items-0">LIMITED
                                EDITION</p>
                            <p class="title text-[1.5rem] sm:text-[3rem] lg:text-[4rem] text-center text-white items-0">
                                SOUND IS LIVELY WITH DUAL AUDIO
                            </p>
                            <div class="flex justify-center py-5 items-0">
                                <a href="<c:url value="/product"/>"
                                   class="px-10 py-3 bg-black rounded-full cursor-pointer text-white border-2">SHOP
                                    NOW</a>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide relative">
                        <img class="w-full h-auto" src="<c:url value="/assets/images/section_1/phono-slider-2.jpg"/>"
                             alt="slider-2"/>
                        <div class="inner-ctn absolute left-0 top-0 pt-[3rem] w-full md:pt-[10rem] md:w-[40rem] xl:pt-[20rem] pl-0 lg:pl-[5rem] xl:w-[60rem]">
                            <p class="text-lg sm:text-2xl lg:text-3xl font-[600] text-center text-black items-0">4K
                                RESOLUTION</p>
                            <p class="title text-[1.5rem] sm:text-[3rem] lg:text-[4rem] text-center text-black items-0">
                                EXCLUSIVE STEEL FRAME
                            </p>
                            <div class="flex justify-center py-5 items-0">
                                <a href="<c:url value="/product"/>"
                                   class="px-10 py-3 bg-black rounded-full cursor-pointer text-white border-2">SHOP
                                    NOW</a>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide relative">
                        <img class="w-full h-auto" src="<c:url value="/assets/images/section_1/phono-slider-3.jpg"/>"
                             alt="slider-3"/>
                        <div class="inner-ctn absolute right-0 top-0 pt-[3rem] w-full md:pt-[10rem] md:w-[40rem] xl:pt-[20rem] pr-0 lg:pr-[5rem] xl:w-[60rem]">
                            <p class="text-lg sm:text-2xl lg:text-3xl font-[600] text-center text-white items-0">LIMITED
                                EDITION</p>
                            <p class="title text-[1.5rem] sm:text-[3rem] lg:text-[4rem] text-center text-white items-0">
                                FULL SCREEN DISPLAY PERFECTLY
                            </p>
                            <div class="flex justify-center py-5 items-0">
                                <a href="<c:url value="/product"/>"
                                   class="px-10 py-3 bg-black rounded-full cursor-pointer text-white border-2">SHOP
                                    NOW</a>
                            </div>
                        </div>
                    </div>
                    ...
                </div>

                <%--                <!-- If we need navigation buttons -->--%>
                <%--                <div class="swiper-button-prev"></div>--%>
                <%--                <div class="swiper-button-next"></div>--%>

            </div>
            <div class="w-full bg-slate-100 px-5 py-10 flex justify-center flex-wrap">
                <div class="flex items-center gap-2 px-10 items-1 cursor-pointer bg-slate-100 hover:bg-slate-200 py-5 rounded">
                    <img src="<c:url value="/assets/images/section_1/free-deliver-icon.jpg"/>"/>
                    <div>
                        <p class="text-black font-[500] text-xl">Free Shipping</p>
                        <p>For order over 50$</p>
                    </div>
                </div>
                <div class="flex items-center gap-2 px-10 items-1 cursor-pointer bg-slate-100 hover:bg-slate-200 py-5 rounded">
                    <img src="<c:url value="/assets/images/section_1/offers-icon.jpg"/>"/>
                    <div>
                        <p class="text-black font-[500] text-xl">OFFICIAL DISCOUNTS</p>
                        <p>Save Big on next product</p>
                    </div>
                </div>
                <div class="flex items-center gap-2 px-10 items-1 cursor-pointer bg-slate-100 hover:bg-slate-200 py-5 rounded">
                    <img src="<c:url value="/assets/images/section_1/support-icon.jpg"/>"/>
                    <div>
                        <p class="text-black font-[500] text-xl">24/7 HELPLINE</p>
                        <p>Care till the end</p>
                    </div>
                </div>
            </div>
            <div class="w-full bg-white px-5 py-10 ">
                <p class="sm:text-3xl text-xl text-black font-[600] mb-3 text-center sec1-title">WHAT MAKES THE
                    ESSENTIAL DIFFERENT?</p>
                <p class="sm:text-xl text-lg text-center mb-3 sec1-title">EXPERIENCE HIGH PERFORMANCE AND SECURE</p>
                <div class="flex justify-center flex-wrap py-5">
                    <div class="flex flex-col items-center gap-2 p-10 items-1 w-[20rem] hover:bg-slate-200 rounded-md cursor-pointer">
                        <img src="https://phono-demo.myshopify.com/cdn/shop/files/ic12.png?v=1613704474&width=275"/>
                        <div>
                            <p class="text-black sm:text-xl text-lg text-center font-[500]">PERFECT CUT
                                DUAL CAMERA</p>
                            <p class="text-center text-md">Tristique senectus et netus et malesuada ant reiet fames.</p>
                        </div>
                    </div>
                    <div class="flex flex-col items-center gap-2 p-10 items-1 w-[20rem] hover:bg-slate-200 rounded-md cursor-pointer">
                        <img src="https://phono-demo.myshopify.com/cdn/shop/files/ic13.png?v=1613704474&width=275"/>
                        <div>
                            <p class="text-black sm:text-xl text-lg text-center font-[500]">PRETTY
                                INTELLIGENT PROCESSING</p>
                            <p class="text-center text-md">Consequat ac habit amet asse felis donec et odio pellentesque
                                diam.</p>
                        </div>
                    </div>
                    <div class="flex flex-col items-center gap-2 p-10 items-1 w-[20rem] hover:bg-slate-200 rounded-md cursor-pointer">
                        <img src="https://phono-demo.myshopify.com/cdn/shop/files/ic11.png?v=1613704474&width=275"/>
                        <div>
                            <p class="text-black sm:text-xl text-lg text-center font-[500]">MOST POPULAR
                                8GB DDR5 RAM</p>
                            <p class="text-center text-md">Dictum varius duis at consectetur lorem donec massa sap
                                faucibus.</p>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </section>
    <section id="slide-product" class="overflow-hidden">
        <div class="min-h-screen flex flex-col justify-center h-auto w-full overflow-hidden gap-2 slide-products">
            <p class="sm:text-3xl text-xl text-black font-[600] mb-3 text-center product-text">FIND YOUR PERFECT
                MATCH</p>
            <p class="sm:text-xl text-lg text-center mb-3 product-text">EXPLORE AND FIND RIGHT ONE</p>
            <div class="swiper-two h-[30rem] w-full contain mx-auto">
                <!-- Additional required wrapper -->
                <div class="swiper-wrapper w-full">
                    <!-- Slides -->
                    <c:set var="listProducts" value="${requestScope.get('listProducts')}" scope="request"/>
                    <c:forEach var="item" items="${listProducts}">
                        <div class="swiper-slide w-full">
                            <div class="slide-product cursor-pointer bg-slate-100 h-full shadow-lg hover:bg-slate-200 transition-all duration-300 ease-in-out">
                                <div class="wrapper p-5 flex justify-center">
                                    <img class="h-[15rem] w-auto"
                                         src="<c:out value="${item.getUrlImg()}"/>"
                                         alt="slider-1"/>
                                </div>

                                <div class="flex flex-col items-center p-5 gap-3 items-0">
                                    <a href="<c:url value="/product"/>"
                                       class="px-10 py-3 bg-black rounded-full cursor-pointer text-white border-2">SHOP
                                        NOW</a>
                                    <p>${item.getProductName()}</p>
                                </div>
                            </div>

                        </div>
                    </c:forEach>


                </div>
                <%--                <!-- If we need navigation buttons -->--%>
                <%--                <div class="swiper-button-prev"></div>--%>
                <%--                <div class="swiper-button-next"></div>--%>
            </div>
        </div>
    </section>
    <section id="slide-contact" class="min-h-screen h-auto py-[5rem] grid place-items-center">
        <div>
            <p class="sm:text-3xl text-xl text-black font-[600] mb-3 text-center product-text">Contact with us</p>

            <div class="wapper flex flex-wrap items-center container mx-auto">
                <div class="col-1 w-[50%] p-5 rounded-md">


                    <form class="w-full mx-auto bg-slate-100 shadow-md p-5" method="get" action="<c:url value="/"/>">
                        <div class="relative z-0 w-full mb-5 group">
                            <input type="email" name="floating_email" id="floating_email"
                                   class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none focus:outline-none focus:ring-0 focus:border-blue-600 peer"
                                   placeholder=" " required/>
                            <label for="floating_email"
                                   class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 rtl:peer-focus:left-auto peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Email
                                address</label>
                        </div>
                        <div class="grid md:grid-cols-2 md:gap-6">
                            <div class="relative z-0 w-full mb-5 group">
                                <input type="text" name="floating_first_name" id="floating_first_name"
                                       class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none focus:outline-none focus:ring-0 focus:border-blue-600 peer"
                                       placeholder=" " required/>
                                <label for="floating_first_name"
                                       class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">First
                                    name</label>
                            </div>
                            <div class="relative z-0 w-full mb-5 group">
                                <input type="text" name="floating_last_name" id="floating_last_name"
                                       class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none focus:outline-none focus:ring-0 focus:border-blue-600 peer"
                                       placeholder=" " required/>
                                <label for="floating_last_name"
                                       class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Last
                                    name</label>
                            </div>
                        </div>
                        <div class="grid md:grid-cols-2 md:gap-6">
                            <div class="relative z-0 w-full mb-5 group">
                                <input type="tel" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" name="floating_phone"
                                       id="floating_phone"
                                       class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none focus:outline-none focus:ring-0 focus:border-blue-600 peer"
                                       placeholder=" " required/>
                                <label for="floating_phone"
                                       class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Phone
                                    number (123-456-7890)</label>
                            </div>
                            <div class="relative z-0 w-full mb-5 group">
                                <input type="text" name="floating_company" id="floating_company"
                                       class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none focus:outline-none focus:ring-0 focus:border-blue-600 peer"
                                       placeholder=" " required/>
                                <label for="floating_company"
                                       class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Company
                                    (Ex. Google)</label>
                            </div>
                        </div>
                        <button type="submit"
                                class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800" name="action" value="contact">
                            Submit
                        </button>
                    </form>

                </div>
                <div class="col-2 w-[50%] p-5 overflow-hidden">
                    <div class="swiper-three h-[25rem] w-full contain mx-auto">
                        <!-- Additional required wrapper -->
                        <div class="swiper-wrapper">
                            <!-- Slides -->
                            <c:set var="listProducts" value="${requestScope.get('listProducts')}" scope="request"/>
                            <c:forEach var="item" items="${listProducts}">
                                <div class="swiper-slide h-full">
                                    <div class="slide-product cursor-pointer bg-slate-100 h-full shadow-lg hover:bg-slate-200 transition-all duration-300 ease-in-out">
                                        <div class="wrapper p-5 flex justify-center">
                                            <img class="h-[10rem] w-auto"
                                                 src="<c:out value="${item.getUrlImg()}"/>"
                                                 alt="slider-1"/>
                                        </div>

                                        <div class="flex flex-col items-center p-5 gap-3 items-0">
                                            <a href="<c:url value="/product"/>"
                                               class="px-10 py-3 bg-black rounded-full cursor-pointer text-white border-2">SHOP
                                                NOW</a>
                                            <p>${item.getProductName()}</p>
                                        </div>
                                    </div>

                                </div>
                            </c:forEach>


                        </div>
                        <%--                <!-- If we need navigation buttons -->--%>
                        <%--                <div class="swiper-button-prev"></div>--%>
                        <%--                <div class="swiper-button-next"></div>--%>
                    </div>
                </div>
            </div>
        </div>

    </section>
    <section id="slide-about" class="min-h-screen grid place-items-center">
        <div class="ctn">
            <p class="sm:text-3xl text-xl text-black font-[600] mb-3 text-center sec2-title">NEWEST MODERN PRODUCTS IS CASTED BY PROFESSOR DEVELOPER</p>
            <p class="sm:text-xl text-lg text-center mb-3 sec2-title">EXPERIENCE HIGH PERFORMANCE AND SECURE</p>
            <div class="flex justify-center flex-wrap py-5">
                <div class="flex flex-col items-center gap-2 p-10 w-[20rem] hover:bg-slate-200 rounded-md cursor-pointer items-2">
                    <img src="<c:url value="/assets/images/logo_admin/logo-admin-1.jpg"/>"/>
                    <div>
                        <p class="text-black sm:text-xl text-lg text-center font-[500]">TD FULLSTACK</p>
                        <p class="text-center text-md">Tristique senectus et netus et malesuada ant reiet fames.</p>
                    </div>
                </div>
                <div class="flex flex-col items-center gap-2 p-10 w-[20rem] hover:bg-slate-200 rounded-md cursor-pointer items-2">
                    <img src="<c:url value="/assets/images/logo_admin/logo-admin-2.jpg"/>"/>
                    <div>
                        <p class="text-black sm:text-xl text-lg text-center font-[500]">DQ FULLSTACK</p>
                        <p class="text-center text-md">Consequat ac habit amet asse felis donec et odio pellentesque
                            diam.</p>
                    </div>
                </div>
                <div class="flex flex-col items-center gap-2 p-10 w-[20rem] hover:bg-slate-200 rounded-md cursor-pointer items-2">
                    <img src="https://avatars.githubusercontent.com/u/115167404?v=4"/>
                    <div>
                        <p class="text-black sm:text-xl text-lg text-center font-[500]">AT FULLSTACK</p>
                        <p class="text-center text-md">Dictum varius duis at consectetur lorem donec massa sap
                            faucibus.</p>
                    </div>
                </div>
            </div>

        </div>
    </section>
</main>

<%--Footer --%>
<jsp:include page="base/footer.jsp" />
<%--<%= request.getServletContext().getInitParameter("title-home")%>--%>

<%--    My Script --%>

<script>
    <%@include file="../assets/scripts/jquery.js"%>
    <%@include file="../assets/scripts/header.js"%>
</script>
<%--<script>--%>
<%--    <jsp:include page="../assets/scripts/swipper.js" />--%>
<%--</script>--%>
<script>
    <%--    <jsp:include page="../assets/scripts/headjs.js" />--%>
</script>
<script>
    <%--    <jsp:include page="../assets/scripts/reveal.js" />--%>
</script>
<%--<script>--%>
<%--    <jsp:include page="../assets/scripts/scrollReivew.js" />--%>
<%--</script>--%>

<script>
    window.addEventListener('load', (e) => {
        const swiper = new Swiper('.swiper-one', {
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
            speed: 2000,
            longSwipesMs: 2000,

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
        const swiperTwo = new Swiper('.swiper-two', {
            // Optional parameters
            direction: 'horizontal',
            loop: true,
            autoplay: {
                delay: 3000,
            },
            effect: 'coverflow',
            coverflowEffect: {
                rotate: 30,
                slideShadows: false,
            },
            speed: 3000,
            longSwipesMs: 3000,

            breakpoints: {
// when window width is >= 320px
                320: {
                    slidesPerView: 1,
                    spaceBetween: 20
                },
                // when window width is >= 480px
                480: {
                    slidesPerView: 2,
                    spaceBetween: 30
                },
                // when window width is >= 640px
                640: {
                    slidesPerView: 3,
                    spaceBetween: 40
                }
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
        const swiperThree = new Swiper('.swiper-three', {
            // Optional parameters
            direction: 'horizontal',
            loop: true,
            autoplay: {
                delay: 3000,
            },
            speed: 3000,
            longSwipesMs: 3000,
            effect: 'creative',
            creativeEffect: {
                prev: {
                    // will set `translateZ(-400px)` on previous slides
                    translate: [0, 0, -400],
                },
                next: {
                    // will set `translateX(100%)` on next slides
                    translate: ['100%', 0, 0],
                },
            },
        });
    })


</script>
<script>


</script>
</body>
</html>