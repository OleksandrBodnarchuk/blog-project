<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Register - DevNotes</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/forms.css">
    <%@ include file="../segments/stylesheets.jspf" %>

</head>
<body>
<div class="container">
    <nav class="navbar">
        <a href="#" class="logo">
            <i class="fas fa-share-alt-square"></i>
            DevNotes
        </a>
        <a href="#" class="login-button">Log in</a>
    </nav>

    <form action="#" method="post" class="user-form">
        <h2 class="user-form-title">Register on DevNotes</h2>
        <label>
            <input name="username" placeholder="User name" required>
        </label>
        <label>
            <input name="email" placeholder="Email" type="email" required>
        </label>
        <label>
            <input name="password" placeholder="Password" type="password" required>
        </label>
        <button class="user-form-button">Register</button>
    </form>

    <%@include file="../segments/footer.jspf" %>

</body>
</html>