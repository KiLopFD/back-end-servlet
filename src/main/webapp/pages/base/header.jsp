<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="bg-white sticky top-0 left-0 z-[9999] box-shadow-sm">
    <nav class="mx-auto flex max-w-7xl items-center justify-between p-6 lg:px-8" aria-label="Global">
        <div class="flex lg:flex-1">
            <a href="<c:url value="/"/>" class="-m-1.5 p-1.5">
                <span class="sr-only">Your Company</span>
                <img class="h-8 w-auto" src="<c:url value="/assets/images/brand_web/logo.png"/>" alt="">
            </a>
        </div>
        <div class="flex lg:hidden">
            <button type="button" class="-m-2.5 inline-flex items-center justify-center rounded-md p-2.5 text-gray-700"
                    id="show-bar-menu">
                <span class="sr-only">Open main menu</span>
                <svg class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"
                     aria-hidden="true">
                    <path stroke-linecap="round" stroke-linejoin="round"
                          d="M3.75 6.75h16.5M3.75 12h16.5m-16.5 5.25h16.5"/>
                </svg>
            </button>
        </div>
        <div class="hidden lg:flex lg:gap-x-12">
            <a id="home" href="<c:url value="/"/>" class="text-sm font-semibold leading-6 text-gray-900">Home</a>
            <a id="product" href="<c:url value="/product"/>" class="text-sm font-semibold leading-6 text-gray-900">Product</a>
            <a id="contact" href="<c:url value="/"/>" class="text-sm font-semibold leading-6 text-gray-900">Contact</a>
            <a id="about" href="<c:url value="/"/>" class="text-sm font-semibold leading-6 text-gray-900">About</a>
        </div>
        <div class="hidden lg:flex lg:flex-1 lg:justify-end">
            <%--            Check User Logged In To Show Avatar--%>
            <c:set var="userAccount" value="${sessionScope.get('userAccount')}" scope="session"/>
            <c:set var="isLogin" value="${sessionScope.get('isLogin')}" scope="session"/>
            <c:if test="${isLogin.equals(true)}">
                <div class="avatar-wrapper relative">
                    <div class="avatar border-2 border-cyan-500 rounded-full cursor-pointer" id="header-avatar">
                        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
                             stroke="currentColor" class="w-7 h-7">
                            <path stroke-linecap="round" stroke-linejoin="round"
                                  d="M15.75 6a3.75 3.75 0 11-7.5 0 3.75 3.75 0 017.5 0zM4.501 20.118a7.5 7.5 0 0114.998 0A17.933 17.933 0 0112 21.75c-2.676 0-5.216-.584-7.499-1.632z"/>
                        </svg>
                    </div>
                    <div class="model-settings absolute bottom-[-12.8rem] right-[-1.5rem] translate-x-full opacity-0 transition-all duration-300 ease"
                         id="settings-avatar">
                        <div class=" rounded-md flex flex-col bg-slate-700 w-[12rem] overflow-hidden">
                            <a href="<c:url value="/profile"/>" class="block p-2 transition-all hover:bg-slate-600 duration-300 ease cursor-pointer">Profile</a>
                            <a href="<c:url value="/cart"/>"
                               class="block p-2 transition-all hover:bg-slate-600 duration-300 ease cursor-pointer flex justify-between">
                                Cart
                                <c:set var="quantityCart" value="${sessionScope.get('quantityCart')}" scope="session"/>
                                <c:if test="${quantityCart==null}">
                                    <span class="bg-slate-900 text-white px-2 rounded-full">0</span>
                                </c:if>
                                <c:if test="${quantityCart!=null}">
                                    <span class="bg-slate-900 text-white px-2 rounded-full"><c:out
                                            value="${quantityCart}"/></span>
                                </c:if>
                            </a>
                            <a href="<c:url value="/payment?action=history"/>"
                               class="block p-2 transition-all hover:bg-slate-600 duration-300 ease cursor-pointer">History
                                Payment</a>
                            <a href="<c:url value="/payment?action=wallet"/>"
                               class="block p-2 transition-all hover:bg-slate-600 duration-300 ease cursor-pointer flex justify-between">
                                Wallet
                                <c:set var="money" value="${sessionScope.get('money')}" scope="session"/>
                                <span class="bg-slate-900 text-white px-2 rounded-full">
                                    <c:out value="${money}"/>
                                </span>
                            </a>
<%--                            Dash Board --%>
                            <c:if test="${userAccount != null && userAccount.getRole().equals('admin')}">
                                <a class="block p-2 transition-all hover:bg-slate-600 duration-300 ease cursor-pointer" href="<c:url value="/admin"/>">Dash Board Admin</a>
                            </c:if>
                            <a href="<c:url value="/?action=logout"/>"
                               class="block p-2 transition-all hover:bg-slate-600 duration-300 ease cursor-pointer">Log
                                out</a>
                        </div>

                        <div id="close-settings"
                             class="absolute -top-2 -right-2 bg-slate-700 p-2 rounded-full border-2 cursor-pointer hover:bg-slate-900 hover:stroke-white transition-all duration-300 ease">
                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
                                 stroke="currentColor" class="w-6 h-6">
                                <path stroke-linecap="round" stroke-linejoin="round" d="M6 18L18 6M6 6l12 12"/>
                            </svg>

                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${isLogin.equals(false)}">
                <a href="<c:url value="/login"/>" class="text-sm font-semibold leading-6 text-gray-900">Log in <span
                        aria-hidden="true">&rarr;</span></a>
            </c:if>


        </div>
    </nav>
    <!-- Mobile menu, show/hide based on menu open state. -->
    <div class="hidden" id="header-modal-menu">
        <!-- Background backdrop, show/hide based on slide-over state. -->
        <div class="fixed inset-0 z-10"></div>
        <div class="fixed inset-y-0 right-0 z-10 w-full overflow-y-auto bg-white px-6 py-6 sm:max-w-sm sm:ring-1 sm:ring-gray-900/10">
            <div class="flex items-center justify-between">
                <a href="#" class="-m-1.5 p-1.5">
                    <span class="sr-only">Your Company</span>
                    <img class="h-8 w-auto" src="<c:url value="/assets/images/brand_web/logo.png"/>" alt="">
                </a>
                <button type="button" class="-m-2.5 rounded-md p-2.5 text-gray-700" id="header-close-menu-bar">
                    <span class="sr-only">Close menu</span>
                    <svg class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"
                         aria-hidden="true">
                        <path stroke-linecap="round" stroke-linejoin="round" d="M6 18L18 6M6 6l12 12"/>
                    </svg>
                </button>
            </div>
            <div class="mt-6 flow-root">
                <div class="-my-6 divide-y divide-gray-500/10">
                    <div class="space-y-2 py-6">
                        <a href="<c:url value="/"/>"
                           class="-mx-3 block rounded-lg px-3 py-2 text-base font-semibold leading-7 text-gray-900 hover:bg-gray-50">Home</a>
                        <a href="<c:url value="/product"/>"
                           class="-mx-3 block rounded-lg px-3 py-2 text-base font-semibold leading-7 text-gray-900 hover:bg-gray-50">Product</a>
                        <a href="<c:url value="/"/>"
                           class="-mx-3 block rounded-lg px-3 py-2 text-base font-semibold leading-7 text-gray-900 hover:bg-gray-50">Contact</a>
                        <a href="<c:url value="/"/>"
                           class="-mx-3 block rounded-lg px-3 py-2 text-base font-semibold leading-7 text-gray-900 hover:bg-gray-50">About</a>
                    </div>
                    <div class="py-6">
                        <c:if test="${isLogin.equals(false)}">
                            <a href="<c:url value="/login"/>"
                               class="-mx-3 block rounded-lg px-3 py-2.5 text-base font-semibold leading-7 text-gray-900 hover:bg-gray-50">Log
                                in</a>
                        </c:if>
                        <c:if test="${isLogin.equals(true)}">
                            <a href="<c:url value="/profile"/>"
                               class="-mx-3 block rounded-lg px-3 py-2.5 text-base font-semibold leading-7 text-gray-900 hover:bg-gray-50">My Profile</a>
                            <c:if test="${userAccount != null && userAccount.getRole().equals('admin')}">
                                <a class="-mx-3 block rounded-lg px-3 py-2.5 text-base font-semibold leading-7 text-gray-900 hover:bg-gray-50" href="<c:url value="/admin"/>">Dash Board Admin</a>
                            </c:if>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--Set Domain --%>
    <c:set var="subDomain" value="${sessionScope.get('subDomain')}" scope="session"/>
    <input class="hidden" type="hidden" name="subDomain" value="${subDomain}" id="subDomain"/>
</header>


<%--Loading Page--%>
<div id="loading" role="status" class="translate-x-full opacity-1 transition-all duration-300 ease absolute top-0 left-0 w-full h-full z-[9999]  grid place-items-center loading-component">
    <div class="absolute top-0 left-0 bg-slate-900 opacity-[0.7] animate-pulse w-full h-full"></div>
    <div class="flex justify-center gap-1">
        <span class="block w-3 h-3 rounded-full bg-cyan-300 animate-bounce animate-ping"></span>
        <span class="block w-4 h-4 rounded-full bg-cyan-300 animate-bounce animate-ping"></span>
        <span class="block w-5 h-5 rounded-full bg-cyan-300 animate-bounce animate-ping"></span>
        <span class="block w-6 h-6 rounded-full bg-cyan-300 animate-bounce animate-ping"></span>
        <span class="block w-7 h-7 rounded-full bg-cyan-300 animate-bounce animate-ping"></span>
        <span class="block w-8 h-8 rounded-full bg-cyan-300 animate-bounce animate-ping"></span>
        <span class="block w-9 h-9 rounded-full bg-cyan-300 animate-bounce animate-ping"></span>
    </div>
</div>


<%--Notice --%>
<c:set var="notice" value="${sessionScope.get('notice')}" scope="session"/>
<c:if test="${notice=='success'}">
    <div id="toast-success" class="absolute toast-success top-[5rem] right-0 z-[9999] flex items-center w-full max-w-xs p-4 mb-4 text-gray-500 bg-white rounded-lg shadow dark:text-gray-400 dark:bg-gray-800" role="alert">
        <div class="inline-flex items-center justify-center flex-shrink-0 w-8 h-8 text-green-500 bg-green-100 rounded-lg dark:bg-green-800 dark:text-green-200">
            <svg class="w-5 h-5" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
                <path d="M10 .5a9.5 9.5 0 1 0 9.5 9.5A9.51 9.51 0 0 0 10 .5Zm3.707 8.207-4 4a1 1 0 0 1-1.414 0l-2-2a1 1 0 0 1 1.414-1.414L9 10.586l3.293-3.293a1 1 0 0 1 1.414 1.414Z"/>
            </svg>
            <span class="sr-only">Check icon</span>
        </div>
        <div class="ms-3 text-sm font-normal">Successfully, Validation for Action</div>
        <button type="button" class="ms-auto -mx-1.5 -my-1.5 bg-white text-gray-400 hover:text-gray-900 rounded-lg focus:ring-2 focus:ring-gray-300 p-1.5 hover:bg-gray-100 inline-flex items-center justify-center h-8 w-8 dark:text-gray-500 dark:hover:text-white dark:bg-gray-800 dark:hover:bg-gray-700" data-dismiss-target="#toast-success" aria-label="Close">
            <span class="sr-only" id="close-notice">Close</span>
            <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 14">
                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6"/>
            </svg>
        </button>
    </div>
</c:if>
<c:if test="${notice=='danger'}">
    <div id="toast-danger" class="absolute toast-danger top-[5rem] right-0 z-[9999] flex items-center w-full max-w-xs p-4 mb-4 text-gray-500 bg-white rounded-lg shadow dark:text-gray-400 dark:bg-gray-800" role="alert">
        <div class="inline-flex items-center justify-center flex-shrink-0 w-8 h-8 text-red-500 bg-red-100 rounded-lg dark:bg-red-800 dark:text-red-200">
            <svg class="w-5 h-5" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
                <path d="M10 .5a9.5 9.5 0 1 0 9.5 9.5A9.51 9.51 0 0 0 10 .5Zm3.707 11.793a1 1 0 1 1-1.414 1.414L10 11.414l-2.293 2.293a1 1 0 0 1-1.414-1.414L8.586 10 6.293 7.707a1 1 0 0 1 1.414-1.414L10 8.586l2.293-2.293a1 1 0 0 1 1.414 1.414L11.414 10l2.293 2.293Z"/>
            </svg>
            <span class="sr-only">Error icon</span>
        </div>
        <div class="ms-3 text-sm font-normal">Has Some Errors, Please Check Again</div>
        <button type="button" class="ms-auto -mx-1.5 -my-1.5 bg-white text-gray-400 hover:text-gray-900 rounded-lg focus:ring-2 focus:ring-gray-300 p-1.5 hover:bg-gray-100 inline-flex items-center justify-center h-8 w-8 dark:text-gray-500 dark:hover:text-white dark:bg-gray-800 dark:hover:bg-gray-700" data-dismiss-target="#toast-danger" aria-label="Close">
            <span class="sr-only">Close</span>
            <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 14">
                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6"/>
            </svg>
        </button>
    </div>
</c:if>

