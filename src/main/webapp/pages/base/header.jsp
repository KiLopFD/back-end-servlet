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
            <a href="<c:url value="/"/>" class="text-sm font-semibold leading-6 text-gray-900">Home</a>
            <a href="<c:url value="/product"/>" class="text-sm font-semibold leading-6 text-gray-900">Product</a>
            <a href="#" class="text-sm font-semibold leading-6 text-gray-900">Contact</a>
            <a href="#" class="text-sm font-semibold leading-6 text-gray-900">About</a>
        </div>
        <div class="hidden lg:flex lg:flex-1 lg:justify-end">
            <%--            Check User Logged In To Show Avatar--%>
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
                    <div class="model-settings absolute bottom-[-11rem] right-[-1rem] hidden"
                         id="settings-avatar">
                        <div class=" rounded-md flex flex-col bg-slate-700 w-[10rem] overflow-hidden">
                            <a class="block p-2 transition-all hover:bg-slate-600 duration-300 ease cursor-pointer">Profile</a>
                            <a href="<c:url value="/cart"/>"
                               class="block p-2 transition-all hover:bg-slate-600 duration-300 ease cursor-pointer flex justify-between">
                                Cart
                                <c:set var="quantityCart" value="${sessionScope.get('quantityCart')}" scope="session"/>
                                <c:if test="${quantityCart==null}">
                                    <span class="bg-slate-900 text-white px-2 rounded-full">0</span>
                                </c:if>
                                <c:if test="${quantityCart!=null}">
                                    <span class="bg-slate-900 text-white px-2 rounded-full"><c:out value="${quantityCart}"/></span>
                                </c:if>
                            </a>
                            <a class="block p-2 transition-all hover:bg-slate-600 duration-300 ease cursor-pointer">History
                                Payment</a>
                            <a href="<c:url value="/?action=logout"/>"
                               class="block p-2 transition-all hover:bg-slate-600 duration-300 ease cursor-pointer">Log
                                out</a>
                        </div>

                        <div id="close-settings" class="absolute -top-2 -right-2 bg-slate-700 p-2 rounded-full border-2 cursor-pointer hover:bg-slate-900 hover:stroke-white transition-all duration-300 ease">
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
                        <a href="#"
                           class="-mx-3 block rounded-lg px-3 py-2 text-base font-semibold leading-7 text-gray-900 hover:bg-gray-50">Home</a>
                        <a href="<c:url value="/product"/>"
                           class="-mx-3 block rounded-lg px-3 py-2 text-base font-semibold leading-7 text-gray-900 hover:bg-gray-50">Product</a>
                        <a href="#"
                           class="-mx-3 block rounded-lg px-3 py-2 text-base font-semibold leading-7 text-gray-900 hover:bg-gray-50">Contact</a>
                        <a href="#"
                           class="-mx-3 block rounded-lg px-3 py-2 text-base font-semibold leading-7 text-gray-900 hover:bg-gray-50">About</a>
                    </div>
                    <div class="py-6">
                        <a href="<c:url value="/login"/>"
                           class="-mx-3 block rounded-lg px-3 py-2.5 text-base font-semibold leading-7 text-gray-900 hover:bg-gray-50">Log
                            in</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>

