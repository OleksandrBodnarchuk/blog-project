<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Log in DevNotes</title>
    <%@ include file="../segments/stylesheets.jspf" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/forms.css">
</head>
<body>
<div class="container">
    <%@ include file="../segments/header.jspf" %>

    <form action="j_security_check" method="post" class="user-form">
        <h2 class="user-form-title">Log into DevNotes</h2>
        <input name="j_username" placeholder="User name" required>
        <input name="j_password" placeholder="Password" type="password" required>
        <button class="user-form-button">Log in</button>
        <p>Dont have account? <a href="${pageContext.request.contextPath}/signup">Register here</a></p>
    </form>

    <%@ include file="../segments/footer.jspf" %>
</div>
</body>
</html>