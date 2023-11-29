<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <jsp:include page="../base/head.jsp">
        <jsp:param name="title" value="Dash Board"/>
    </jsp:include>
</head>
<body class="bg-slate-700 overflow-x-hidden w-full h-auto">
<jsp:include page="../base/header.jsp"/>

<main class="min-h-[90vh]">
    <section class="dash-board relative min-h-screen h-auto w-full">
        <div class="col-1 flex flex-col items-start gap-2 absolute top-2 left-0">
            <!-- drawer init and show -->
            <div class="text-center inline-block pl-3">
                <button id="show-dashboard"
                        class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800"
                        type="button" data-drawer-target="drawer-navigation" data-drawer-show="drawer-navigation"
                        aria-controls="drawer-navigation">
                    Show Dashboard
                </button>
            </div>

            <!-- drawer component -->
            <div id="drawer-navigation"
                 class="transition-transform transition-all duration-300 ease sticky top-0 left-0 z-40 w-64 h-screen p-4 overflow-y-auto bg-white dark:bg-gray-800 rounded-r-lg side-bar"
                 tabindex="-1" aria-labelledby="drawer-navigation-label">
                <h5 id="drawer-navigation-label"
                    class="text-base font-semibold text-gray-500 uppercase dark:text-gray-400">Menu</h5>
                <button id="close-side-bar" type="button" data-drawer-hide="drawer-navigation"
                        aria-controls="drawer-navigation"
                        class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 absolute top-2.5 end-2.5 inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white">
                    <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20"
                         xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd"
                              d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
                              clip-rule="evenodd"></path>
                    </svg>
                    <span class="sr-only">Close menu</span>
                </button>
                <div class="py-4 overflow-y-auto">
                    <ul class="space-y-2 font-medium">
                        <li>
                            <a href="<c:url value="/admin?page=product"/>"
                               class="items-options-dash-board flex items-center p-2 text-gray-900 rounded-lg hover:bg-slate-700">
                                <svg class="flex-shrink-0 w-5 h-5 text-gray-500 transition duration-75"
                                     aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor"
                                     viewBox="0 0 18 18">
                                    <path d="M6.143 0H1.857A1.857 1.857 0 0 0 0 1.857v4.286C0 7.169.831 8 1.857 8h4.286A1.857 1.857 0 0 0 8 6.143V1.857A1.857 1.857 0 0 0 6.143 0Zm10 0h-4.286A1.857 1.857 0 0 0 10 1.857v4.286C10 7.169 10.831 8 11.857 8h4.286A1.857 1.857 0 0 0 18 6.143V1.857A1.857 1.857 0 0 0 16.143 0Zm-10 10H1.857A1.857 1.857 0 0 0 0 11.857v4.286C0 17.169.831 18 1.857 18h4.286A1.857 1.857 0 0 0 8 16.143v-4.286A1.857 1.857 0 0 0 6.143 10Zm10 0h-4.286A1.857 1.857 0 0 0 10 11.857v4.286c0 1.026.831 1.857 1.857 1.857h4.286A1.857 1.857 0 0 0 18 16.143v-4.286A1.857 1.857 0 0 0 16.143 10Z"/>
                                </svg>
                                <span class="ms-3">Products</span>
                            </a>
                        </li>

                    </ul>
                </div>
            </div>
        </div>
        <div class="col-2 pt-[3.5rem] w-auto pl-[270px] transition-all duration-300 ease w-full px-3"  id="showPage">
            <%--Variable to select page --%>
            <c:set var="showPage" value="${requestScope.get('showPage')}" scope="request"/>
            <c:set var="productList" value="${requestScope.get('productList')}" scope="request"/>
            <c:if test="${showPage != null && showPage.equals('product')}">
                <div class="w-full">


                    <form class="max-w-md mx-auto bg-slate-100 p-5 rounded-md mb-3" method="get" action="<c:url value="/admin"/>">
                        <input type="hidden" name="page" value="<c:out value="${showPage}"/>"/>
                        <div class="relative z-0 w-full mb-5 group">
                            <input type="text" name="productName" id="productName" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" "/>
                            <label for="productName" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 rtl:peer-focus:left-auto peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Product Name</label>
                        </div>
                        <div class="relative z-0 w-full mb-5 group">
                            <input type="text" name="description" id="description" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" "/>
                            <label for="description" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 rtl:peer-focus:left-auto peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Description</label>
                        </div>
                        <div class="relative z-0 w-full mb-5 group">
                            <input type="date" name="datePublic" id="datePublic" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-black dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" "/>
                            <label for="datePublic" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 rtl:peer-focus:left-auto peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Date Public</label>
                        </div>
                        <div class="relative z-0 w-full mb-5 group">
                            <input type="text" name="price" id="price" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" "/>
                            <label for="price" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 rtl:peer-focus:left-auto peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Price</label>
                        </div>
                        <div class="relative z-0 w-full mb-5 group">
                            <input type="text" name="urlImg" id="urlImg" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" "/>
                            <label for="urlImg" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 rtl:peer-focus:left-auto peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Link Img</label>
                        </div>
                        <div class="relative z-0 w-full mb-5 group">
                            <p class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-gray-300 appearance-none focus:outline-none focus:ring-0 focus:border-blue-600 peer">Category</p>
                            <select class="text-black rounded-md p-1" name="category">
                                <c:set var="categoryList" value="${requestScope.get('categoryList')}" scope="request"/>
                                <c:forEach var="cate" items="${requestScope.get('categoryList')}">
                                    <option class="text-black" value="<c:out value="${cate.getCategoryName()}"/>"><c:out value="${cate.getCategoryName()}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div id="showIdProduct" class="relative z-0 w-full mb-5 group hidden">
                            <input type="text" name="idProduct" id="idProduct" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" "/>
                            <label for="idProduct" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 rtl:peer-focus:left-auto peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Id Product</label>
                        </div>
                        <p class="mb-3 text-black">Click To Select Options: </p>
                        <div class="flex flex-wrap gap-2 mb-3">
                            <div class="product-option-exec cursor-pointer text-black bg-slate-200 px-5 py-3 rounded-md hover:bg-cyan-500 transition-all duration-300 ease hover:text-white">Add Product</div>
                            <div class="product-option-exec cursor-pointer text-black bg-slate-200 px-5 py-3 rounded-md hover:bg-green-500 transition-all duration-300 ease hover:text-white">Update</div>
                            <div class="product-option-exec cursor-pointer text-black bg-slate-200 px-5 py-3 rounded-md hover:bg-red-500 transition-all duration-300 ease hover:text-white">Delete</div>
                        </div>
                        <div class="flex flex-wrap gap-2 items-center">
                            <p>Execution:</p>
                            <button id="productAction" name="productAction" value="" class="px-10 py-2 rounded-md bg-slate-800 hover:bg-black hover:text-white transition-all duration-300 ease">Run</button>
                        </div>

                    </form>
                    <%--// --%>
                    <div class="relative w-full overflow-x-auto shadow-md sm:rounded-lg">
                        <table class="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
                            <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                            <tr>
                                <th scope="col" class="px-2 py-3">
                                    Id
                                </th>
                                <th scope="col" class="px-6 py-3">
                                    Product name
                                </th>
                                <th scope="col" class="px-6 py-3">
                                    Link Img
                                </th>
                                <th scope="col" class="px-6 py-3">
                                    Category
                                </th>
                                <th scope="col" class="px-6 py-3">
                                    Price
                                </th>
                                <th scope="col" class="px-6 py-3">
                                    <span class="sr-only">Edit</span>
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${productList}">
                                <form method="get" action="<c:url value="/admin?page=product"/>">
                                    <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600">
                                        <td class="px-2 py-4">
                                            <c:out value="${item.getProductId()}"/>
                                        </td>
                                        <th scope="row"
                                            class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                                            <c:out value="${item.getProductName()}"/>
                                        </th>
                                        <td class="px-6 block py-4">
                                            <a href="<c:out value="${item.getUrlImg()}"/>">Link Img</a>
                                        </td>
                                        <td class="px-6 py-4">
                                            <c:out value="${item.getCategory().getCategoryName()}"/>
                                        </td>
                                        <td class="px-6 py-4">
                                            <c:out value="${item.getPrice()}"/>
                                        </td>
                                        <td class="px-6 py-4 text-right">
                                            <a href="<c:url value="/admin?page=product&action=delete&idProduct=${item.getProductId()}"/>"
                                               class="font-medium text-blue-600 dark:text-red-500 hover:underline">Delete</a>
                                        </td>
                                    </tr>
                                </form>

                            </c:forEach>


                            </tbody>
                        </table>
                    </div>
                </div>


            </c:if>
        </div>

    </section>
</main>
<%--Footer --%>
<jsp:include page="../base/footer.jsp" />
<script>
    <%@include file="../../assets/scripts/header.js"%>
</script>

<script>

    document.addEventListener('readystatechange', (e) => {
        if (document.readyState === 'interactive' || document.readyState === 'loading') {
            // still loading, wait for the event
            document.addEventListener('DOMContentLoaded', () => {
                let drawerNavigation = document.getElementById("drawer-navigation");
                let productShow = document.getElementById("showPage");
                productShow.classList.remove("pl-[270px]")
                drawerNavigation.classList.add("-translate-x-full")
                //
                let showIdProduct = document.getElementById('showIdProduct');
                showIdProduct.classList.add('hidden')
            });
        } else {
            let drawerNavigation = document.getElementById("drawer-navigation");
            let showDashBoard = document.getElementById("show-dashboard");
            let productShow = document.getElementById("showPage");

            showDashBoard.addEventListener('click', () => {
                drawerNavigation.classList.remove("-translate-x-full")
                productShow.classList.add("pl-[270px]")
            })

            let closeSideBar = document.getElementById('close-side-bar');
            closeSideBar.addEventListener('click', () => {
                drawerNavigation.classList.add("-translate-x-full")
                productShow.classList.remove("pl-[270px]")

            })

            let productOptionExec = document.getElementsByClassName('product-option-exec');
            let productAction = document.getElementById('productAction');
            let showIdProduct = document.getElementById('showIdProduct');
            [...productOptionExec].forEach((value, index) => {
                value.addEventListener('click', (e) => {
                    if (value.textContent === 'Add Product') {
                        value.classList.add('bg-cyan-500');
                        productOptionExec[index+1].classList.remove('bg-green-500')
                        productOptionExec[index+2].classList.remove('bg-red-500')
                        productAction.value = 'add-product'
                        showIdProduct.classList.add('hidden')
                    }
                    else if (value.textContent === 'Update') {
                        value.classList.add('bg-green-500');
                        productOptionExec[index-1].classList.remove('bg-cyan-500')
                        productOptionExec[index+1].classList.remove('bg-red-500')
                        productAction.value = 'update-product'
                        showIdProduct.classList.remove('hidden')
                    }
                    else if (value.textContent === 'Delete'){
                        value.classList.add("bg-red-500")
                        productOptionExec[index-1].classList.remove('bg-green-500')
                        productOptionExec[index-2].classList.remove('bg-cyan-500')
                        productAction.value = 'delete-product'
                        showIdProduct.classList.remove('hidden')
                    }
                })
            })

        }
    })


</script>
</body>
</html>
