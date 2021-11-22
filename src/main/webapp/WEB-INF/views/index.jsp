<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page import="java.time.format.DateTimeFormatter" %>

<html lang="pl" style="background-color: #BDBDBD">
<head>
    <meta charset="UTF-8">
    <title>DevNotes</title>
    <%--    Styles--%>
    <%@ include file="../segments/stylesheets.jspf" %>
</head>
<body>
<div class="container">
    <%--    Header--%>
    <%@ include file="../segments/header.jspf" %>

    <aside class="categories">
        <ul>
            <c:forEach var="category" items="${requestScope.categories}">
                <li>
                    <a href="${pageContext.request.contextPath.concat('/category?id=').concat(category.id)}">${category.name}</a>
                </li>
            </c:forEach>
        </ul>
    </aside>
    <main>
        <%--        Discovery list--%>
        <%@ include file="../segments/discovery-list.jspf" %>
    </main>
    <%--    Footer--%>
    <%@ include file="../segments/footer.jspf" %>
</div>
</body>
</html>