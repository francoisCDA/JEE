<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Product App</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<h1>"Exo produits !</h1>

<h2>Identification</h2>

<form action="user" method="post">
  <div class="mb-3">
    <label for="pseudo" class="form-label">Pseudo</label>
    <input type="text" class="form-control" id="pseudo" name="pseudo">
  </div>
  <div class="mb-3">
    <label for="passwd" class="form-label">Mot de passe</label>
    <input type="password" class="form-control" id="passwd" name="passwd">
  </div>
  <button type="submit" class="btn btn-primary" name="action" value="login" >Se connecter</button>
  <button type="submit" class="btn btn-success" name="action" value="register">S'inscrire</button>
</form>


<%--<br/>--%>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<%--<br/>--%>
<%--<a href="produits">Hello Produits</a>--%>
<%--<br/>--%>
<%--<a href="new-produits.jsp">Ajouter produits</a>--%>

</body>
</html>