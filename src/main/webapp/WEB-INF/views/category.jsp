<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page import="java.time.format.DateTimeFormatter" %>

<html lang="pl" style="background-color: #BDBDBD">
<head>
    <meta charset="UTF-8">
    <title>DevNotes</title>
    <%@ include file="../segments/stylesheets.jspf"%>
</head>
<body>
<div class="container">
    <%@ include file="../segments/header.jspf"%>

   <h1>${requestScope.category.name}</h1>
    <p>${requestScope.category.description}</p>

    <main>
        <%@ include file="../segments/discovery-list.jspf"%>
    </main>
    <%@ include file="../segments/footer.jspf"%>
</div>
</body>
</html>