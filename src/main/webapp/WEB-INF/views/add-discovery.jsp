<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Register DevNotes</title>
    <%@ include file="../segments/stylesheets.jspf" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/add-discovery-form.css">
</head>
<body>
<div class="container">
    <%@ include file="../segments/header.jspf" %>

    <form action="#" method="post" class="discovery-form">
        <h2 class="discovery-form-title">Add new note</h2>
        <input name="title" placeholder="Title" required>
        <input name="url" placeholder="URL" type="url" required>
        <select>
            <option>Backend</option>
            <option>Frontend</option>
            <option>Frameworks</option>
        </select>
        <textarea name="description" placeholder="Opis"></textarea>
        <button class="discovery-form-button">Add</button>
    </form>

    <%@ include file="../segments/footer.jspf" %>
</div>
</body>
</html>