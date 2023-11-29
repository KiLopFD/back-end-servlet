<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <jsp:include page="base/head.jsp">
        <jsp:param name="title" value="Profile"/>
    </jsp:include>
</head>
<body class="overflow-x-hidden w-full h-auto " oncopy="return false" oncut="return false" onpaste="return false">
<jsp:include page="base/header.jsp"/>
<main class="relative min-h-[90vh]">
    <div class="absolute top-0 right-0" id="showNotice">

    </div>
    <section class="profile py-10 container mx-auto flex justify-center">
        <div class="wrapper sm:w-[30rem] bg-slate-700 p-3 rounded-md shadow-lg">
            <div class="wrap-img flex justify-center py-5">
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
                     stroke="currentColor" class="w-10 h-10 p-1 rounded-full ring-2 ring-cyan-300 ">
                    <path stroke-linecap="round" stroke-linejoin="round"
                          d="M15.75 6a3.75 3.75 0 11-7.5 0 3.75 3.75 0 017.5 0zM4.501 20.118a7.5 7.5 0 0114.998 0A17.933 17.933 0 0112 21.75c-2.676 0-5.216-.584-7.499-1.632z"/>
                </svg>
            </div>
            <c:set var="userAccount" value="${sessionScope.get('userAccount')}" scope="session"/>
            <form class="flex flex-col items-center gap-3" method="get" action="<c:url value="/profile"/>">
                <div>
                    <span class="inline-block min-w-[8rem]">Username</span>
                    <input type="text" class="profile-input px-3 py-1 rounded-md cursor-not-allowed" name="username" value="<c:out value="${userAccount.getUsername()}"/>" readonly/>
                </div>
                <div>
                    <span class="inline-block min-w-[8rem]">Full Name</span>
                    <input type="text" class="profile-input px-3 py-1 rounded-md" name="fullName" value="<c:out value="${userAccount.getFullName()}"/>"/>
                </div>
                <div>
                    <span class="inline-block min-w-[8rem]">Email</span>
                    <input type="email" class="profile-input px-3 py-1 rounded-md cursor-not-allowed" name="email" value="<c:out value="${userAccount.getEmail()}"/>" readonly/>
                </div>
                <div>
                    <span class="inline-block min-w-[8rem]">Address</span>
                    <input type="text" class="profile-input px-3 py-1 rounded-md" name="address" value="<c:out value="${userAccount.getAddress()}"/>" />
                </div>
                <div>
                    <span class="inline-block min-w-[8rem]">Phone</span>
                    <input type="text" class="profile-input px-3 py-1 rounded-md" name="phone" value="<c:out value="${userAccount.getPhoneNumber()}"/>"/>
                </div>
                <div>
                    <span class="inline-block min-w-[8rem]">Password</span>
                    <input type="password" class="profile-input px-3 py-1 rounded-md" name="password" value="<c:out value="${userAccount.getPassword()}"/>"/>
                </div>

                <div class="action py-10 relative">
                    <button type="submit" id="actionUpdate" class="px-10 py-3 bg-slate-900 rounded-md" name="action" value="update">Update</button>
                    <div id="disableAction" class=""></div>
                </div>

            </form>
        </div>
    </section>
</main>
<%--Footer --%>
<jsp:include page="base/footer.jsp" />
<script>
    <%@include file="../assets/scripts/header.js"%>
</script>
<script>
    // Load DOM
    document.addEventListener('DOMContentLoaded', function() {
        const isBlank = (str) => {
            return (!str || /^\s*$/.test(str));
        }
        const disableClass = "disable-cart-action absolute w-full h-full z-[50] cursor-not-allowed top-0 left-0";
        let disableAction = document.getElementById("disableAction");
        disableAction.className = disableClass;

        const oldProfile = {
            username: "",
            fullName: "",
            email: "",
            address: "",
            phone: "",
            password:""
        };

        let allInput = document.getElementsByClassName("profile-input");
        [...allInput].forEach((value, index) => {
            oldProfile[value.name] = value.value
        });

        [...allInput].forEach((value, index) => {
            value.addEventListener('change', (e) => {
                let val = e.target.value;
                if (isBlank(val) || oldProfile[e.target.name] === val) {
                    disableAction.className = disableClass
                }
                else {
                    disableAction.className = ''
                }
            })
        })
//         let errorElement = `<div class="">
//   <div class="bg-red-500 text-white font-bold rounded-t px-4 py-2">
//     Error
//   </div>
//   <div class="border border-t-0 border-red-400 rounded-b bg-red-100 px-4 py-3 text-red-700">
//     <p>Please, check again your input 😊"</p>
//   </div>
// </div>`
//         let showNotice = document.getElementById('showNotice');
//         disableAction.addEventListener('click', (e) => {
//             if (disableAction.className===disableClass) {
//                 console.log("error")
//                 showNotice.innerHTML = errorElement;
//                 setTimeout(()=>{
//                     showNotice.innerHTML="";
//                 }, 3000)
//             }
//         })
//         console.log(oldProfile)
    });
</script>
</body>
</html>
