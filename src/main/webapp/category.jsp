<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page import="java.time.format.DateTimeFormatter" %>

<html lang="pl" style="background-color: #BDBDBD">
<head>
    <meta charset="UTF-8">
    <title>DevNotes</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./styles/main.css">
</head>
<body>
<div class="container">
    <nav class="navbar">
        <a href="#" class="logo">
            <i class="fas fa-paper-plane"></i>
            DevNotes
        </a>
        <a href="#" class="login-button">Log in</a>
    </nav>

   <h1>${requestScope.category.name}</h1>
    <p>${requestScope.category.description}</p>

    <main>
        <c:forEach var="discovery" items="${requestScope.discoveries}">
            <article class="discovery">
                <h2 class="discovery-header">
                        <c:out value="${discovery.title}"/>
                    <p class="discovery-details">Added by: Mosh,
                        On: ${discovery.dateAdded.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))}</p>
                    <a href="<c:out value="${discovery.url}"/>" target="_blank" class="discovery-link"><c:out
                            value="${discovery.url}"/></a>
                    <p><c:out value="${discovery.description}"/></p>
                    <section class="discovery-bar">
                        <a href="#" class="discovery-link upvote">
                            <i class="fas fa-arrow-alt-circle-up discovery-upvote"></i>
                        </a>
                        <p class="discovery-votes">32</p>
                        <a href="#" class="discovery-link downvote">
                            <i class="fas fa-arrow-alt-circle-down discovery-downvote"></i>
                        </a>
                    </section>
            </article>
        </c:forEach>
    </main>
    <footer>DevNotes®, developed by Alex</footer>
</div>
</body>
</html>