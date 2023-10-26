<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Store Phone</title>
    backend-servlet
<%--    Css Link --%>
    <link rel="stylesheet" href="./assets/styles/lib/base_lib.css">
    <link rel="stylesheet" href="./assets/styles/my_styling/global.css">

</head>
<body class="bg-[#fafafa]">
    <%@include file="header.jsp"%>

    <p></p>

    <script>
        // On page load or when changing themes, best to add inline in `head` to avoid FOUC
        if (localStorage.getItem('color-theme') === 'dark' || (!('color-theme' in localStorage) && window.matchMedia('(prefers-color-scheme: dark)').matches)) {
            document.documentElement.classList.add('dark');
        } else {
            document.documentElement.classList.remove('dark')
        }
    </script>
    <script src="./assets/scripts/dark_mode.js"></script>
</body>
</html>