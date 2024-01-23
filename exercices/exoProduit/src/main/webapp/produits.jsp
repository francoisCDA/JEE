<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des produits</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
    <h1>Tous les produits</h1>

    <ul class="list-group">

<c:forEach items="${produits}" var="produit">
    <li class="list-group-item">
        Id: ${produit.getId()}
        Marque: ${produit.getMarque()}
        Réf: ${produit.getReference()}
        Prix: ${produit.getPrix()}
        Date d'achat: ${produit.getDateAchat()}
        stock: ${produit.getStock()}
    </li>

</c:forEach>
    </ul>
    <a href="index.jsp">Accueil</a>
    <br/>
    <a href="new-produits.jsp">Ajouter produits</a>


</body>
</html>
