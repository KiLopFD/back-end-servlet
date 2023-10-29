<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Store Phone</title>
    <%-- Css Link --%>
    <%@include file="../../assets/styles/my_styling/base_style.jsp"%>

</head>

<body class="flex flex-col justify-between h-[100vh] min-h-auto w-full min-w-[355px]"
      style="background: url(/backend_war_exploded/assets/images/background.jpg);">
<%@include file="header.jsp" %>


<main class="h-full">
    <%
        if (request.getRequestURL().toString().equals("http://localhost:8080/backend_war_exploded/")) {
    %>
    <%@include file="../Content/home.jsp" %>
    <%
        }
    %>

</main>


<%@include file="footer.jsp" %>

<script>
    // On page load or when changing themes, best to add inline in `head` to avoid FOUC
    if (localStorage.getItem('color-theme') === 'dark' || (!('color-theme' in localStorage) && window.matchMedia('(prefers-color-scheme: dark)').matches)) {
        document.documentElement.classList.add('dark');
    } else {
        document.documentElement.classList.remove('dark')
    }
</script>
<script src="./assets/scripts/dark_mode.js"></script>
<script src="./assets/styles/lib/base_lib.js"></script>
</body>

</html>


