<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <jsp:include page="base/head.jsp">
        <jsp:param name="title" value="Detail Item"/>
    </jsp:include>
</head>
<body class="overflow-x-hidden w-full h-auto">
<jsp:include page="base/header.jsp"/>
<main class="min-h-[90vh]">
    <section class="detail-product container mx-auto py-10">
        <c:set var="product" value="${sessionScope.get('detailItem')}" scope="session"/>
        <c:if test="${product!=null}">
            <div class="flex flex-wrap">
                <div class="col-1 md:w-[30%] w-full p-5 ">
                    <div class="shadow-md wrap-img md:w-full w-[20rem] mx-auto rounded-md overflow-hidden">
                        <img class="w-full hover:scale-110 transition-all duration-300 ease"
                             src="${product.getUrlImg()}"/>
                    </div>
                </div>
                <div class="col-2 md:w-[70%] w-full p-5">
                    <div class="shadow-md wrap-ctn p-5 bg-slate-200 rounded-lg">
                        <p class="name-product text-2xl text-slate-700 text-center mb-3">
                            <c:out value="${product.getProductName()}"/>
                        </p>
                        <p class="price mb-3 text-xl">
                            <span class="text-slate-700 inline-block w-[8rem]">Hot Price</span>:
                            <c:out value="${product.getPrice()}"/>$
                        </p>
                        <p class="category mb-3 text-xl">
                            <span class="text-slate-700 inline-block w-[8rem]">Category</span>:
                            <c:out value="${product.getCategory().getCategoryName()}"/>
                        </p>
                        <p class="date mb-3 text-xl">
                            <span class="text-slate-700 inline-block w-[8rem]">Date Public</span>:
                            <c:out value="${product.getDatePublic()}"/>
                        </p>
                        <p class="description mb-3 text-xl">
                            <span class="text-slate-700 inline-block w-[8rem]">Description</span>:
                            <c:out value="${product.getDescription()}"/>
                        </p>

                            <%--                        Action for Detail Page --%>
                        <div class="group-btn py-5 flex flex-wrap justify-center gap-3 items-center">
                            <a class="shadow-md px-10 py-3 bg-slate-700 rounded-md text-xl hover:bg-slate-900 hover:text-white transition-all duration-300 ease"
                               href="<c:url value="/detail-item?action=addCart"/>">Add Cart</a>
                            <a class="shadow-md px-10 py-3 text-xl bg-slate-700 rounded-md hover:bg-slate-900 hover:text-white transition-all duration-300 ease"
                               href="<c:url value="/detail-item?action=buyNow"/>">Buy Now</a>

                        </div>
                    </div>

                </div>
            </div>
            <div class="add-comment container mx-auto p-3">
                <p class="text-center text-xl font-[600] text-black">Comment Your Opinion</p>
                <form class="p-5 rounded-md bg-slate-700 flex flex-wrap items-center" method="get"
                      action="<c:url value="/detail-item"/>">


                    <div class="col-1 sm:w-[30%] w-full p-3 grid place-items-center">
                        <div class="wrapper">
                            <c:forEach var="item" begin="1" end="5">
                                <div class="row-input flex gap-2">
                                    <input type="radio" id="focus-<c:out value="${item}"/>" name="rating"
                                           value="<c:out value="${item}"/>">
                                    <label for="focus-<c:out value="${item}"/>" class="flex">
                                        <c:forEach var="inItem" begin="1" end="${item}">
                                            <svg class="w-4 h-4 stroke-yellow-300 fill-yellow-300 me-1"
                                                 aria-hidden="true" xmlns="http://www.w3.org/2000/svg"
                                                 fill="currentColor" viewBox="0 0 22 20">
                                                <path d="M20.924 7.625a1.523 1.523 0 0 0-1.238-1.044l-5.051-.734-2.259-4.577a1.534 1.534 0 0 0-2.752 0L7.365 5.847l-5.051.734A1.535 1.535 0 0 0 1.463 9.2l3.656 3.563-.863 5.031a1.532 1.532 0 0 0 2.226 1.616L11 17.033l4.518 2.375a1.534 1.534 0 0 0 2.226-1.617l-.863-5.03L20.537 9.2a1.523 1.523 0 0 0 .387-1.575Z"/>
                                            </svg>
                                        </c:forEach>
                                        <c:forEach var="inItem" begin="1" end="${5-item}">
                                            <svg class="w-4 h-4 stroke-slate-900 fill-slate-900 me-1" aria-hidden="true"
                                                 xmlns="http://www.w3.org/2000/svg" fill="currentColor"
                                                 viewBox="0 0 22 20">
                                                <path d="M20.924 7.625a1.523 1.523 0 0 0-1.238-1.044l-5.051-.734-2.259-4.577a1.534 1.534 0 0 0-2.752 0L7.365 5.847l-5.051.734A1.535 1.535 0 0 0 1.463 9.2l3.656 3.563-.863 5.031a1.532 1.532 0 0 0 2.226 1.616L11 17.033l4.518 2.375a1.534 1.534 0 0 0 2.226-1.617l-.863-5.03L20.537 9.2a1.523 1.523 0 0 0 .387-1.575Z"/>
                                            </svg>
                                        </c:forEach>

                                    </label>
                                </div>
                            </c:forEach>


                        </div>
                    </div>
                    <div class="col-2 sm:w-[70%] w-full p-3">
                        <div class="wrapper h-full">
                            <label for="comment"
                                   class="mb-3 inline-block px-3 py-1 bg-slate-800 rounded-full cursor-pointer">Your
                                Comment</label>
                            <textarea autofocus id="comment" required class="rounded-md p-2 w-full h-full text-black"
                                      name="comment">

                            </textarea>

                        </div>
                            <%--                        Action Post Review--%>
                        <div class="pt-3 flex justify-center">
                            <button class="px-10 py-3 bg-slate-900 rounded-md hover:text-white hover:bg-black transition-all duration-300 ease"
                                    type="submit" name="action" value="review">Post Review
                            </button>
                        </div>
                    </div>

                </form>
            </div>
            <div class="list-review">
                <c:set var="listReviews" value="${requestScope.get('reviews')}" scope="request"/>
                <c:if test="${listReviews.size()>0}">

                    <blockquote class="text-md italic text-gray-900 p-5 bg-slate-200 shadow-md">
                        <svg class="w-8 h-8 text-gray-400 dark:text-gray-600 mb-4" aria-hidden="true"
                             xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 18 14">
                            <path d="M6 0H2a2 2 0 0 0-2 2v4a2 2 0 0 0 2 2h4v1a3 3 0 0 1-3 3H2a1 1 0 0 0 0 2h1a5.006 5.006 0 0 0 5-5V2a2 2 0 0 0-2-2Zm10 0h-4a2 2 0 0 0-2 2v4a2 2 0 0 0 2 2h4v1a3 3 0 0 1-3 3h-1a1 1 0 0 0 0 2h1a5.006 5.006 0 0 0 5-5V2a2 2 0 0 0-2-2Z"/>
                        </svg>
                        <c:forEach var="item" items="${listReviews}">

                            <div class="ctn p-2 bg-slate-700 rounded-md mb-2">
                                <div class="avatar mb-1 flex gap-2 items-center flex-wrap">
                                    <div>
                                        <span class="inline-block py-1 px-2 bg-slate-500 rounded-full">Author</span>
                                            ${item.getUserReview().getUsername()}
                                    </div>
                                    <div class="flex items-center gap-2 flex-wrap">
                                        <span class="inline-block py-1 px-2 bg-slate-500 rounded-full">Rating</span>
                                        <div class="flex">
                                            <c:forEach begin="1" end="${item.getRating()}">
                                                <svg class="w-4 h-4 stroke-yellow-300 fill-yellow-300 me-1" aria-hidden="true"
                                                     xmlns="http://www.w3.org/2000/svg" fill="currentColor"
                                                     viewBox="0 0 22 20">
                                                    <path d="M20.924 7.625a1.523 1.523 0 0 0-1.238-1.044l-5.051-.734-2.259-4.577a1.534 1.534 0 0 0-2.752 0L7.365 5.847l-5.051.734A1.535 1.535 0 0 0 1.463 9.2l3.656 3.563-.863 5.031a1.532 1.532 0 0 0 2.226 1.616L11 17.033l4.518 2.375a1.534 1.534 0 0 0 2.226-1.617l-.863-5.03L20.537 9.2a1.523 1.523 0 0 0 .387-1.575Z"/>
                                                </svg>
                                            </c:forEach>
                                            <c:forEach begin="1" end="${5-item.getRating()}">
                                                <svg class="w-4 h-4 stroke-slate-900 fill-slate-900 me-1" aria-hidden="true"
                                                     xmlns="http://www.w3.org/2000/svg" fill="currentColor"
                                                     viewBox="0 0 22 20">
                                                    <path d="M20.924 7.625a1.523 1.523 0 0 0-1.238-1.044l-5.051-.734-2.259-4.577a1.534 1.534 0 0 0-2.752 0L7.365 5.847l-5.051.734A1.535 1.535 0 0 0 1.463 9.2l3.656 3.563-.863 5.031a1.532 1.532 0 0 0 2.226 1.616L11 17.033l4.518 2.375a1.534 1.534 0 0 0 2.226-1.617l-.863-5.03L20.537 9.2a1.523 1.523 0 0 0 .387-1.575Z"/>
                                                </svg>
                                            </c:forEach>
                                        </div>

                                    </div>
                                </div>
                                <p>
                                    <span class="inline-block py-1 px-2 bg-slate-500 rounded-full">Comment</span>

                                    <c:out value="${item.getComment()}"/>
                                </p>

                            </div>
                        </c:forEach>

                    </blockquote>


                </c:if>
            </div>
        </c:if>
    </section>
</main>
<%--Footer --%>
<jsp:include page="base/footer.jsp" />
<script>
    <%@include file="../assets/scripts/header.js"%>
</script>
<script>
    window.addEventListener('load', (e) => {
        setTimeout(()=>{
            let url = new URL(window.location.href);
            url.searchParams.delete("action");
        }, 500)
    })
</script>
</body>
</html>
