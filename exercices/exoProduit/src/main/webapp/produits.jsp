<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des produits</title>
</head>
<body>
    <h1>Tous les produits</h1>

<c:forEach items="${produits}" var="produit">
    <div>
        Id: ${produit.getId()}
        Marque: ${produit.getMarque()}
        Réf: ${produit.getReference()}
        Prix: ${produit.getPrix()}
        Date d'achat: ${produit.getDateAchat()}
        stock: ${produit.getStock()}
    </div>

</c:forEach>


</body>
</html>
