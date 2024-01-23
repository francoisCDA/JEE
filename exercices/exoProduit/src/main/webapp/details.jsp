<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Détails</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
    <h1>Détails du produit ${prod.getId()}</h1>

    <ul class="list-group">
        <li class="list-group-item">Marque : ${prod.getMarque()}</li>
        <li class="list-group-item">Référence : ${prod.getReference()}</li>
        <li class="list-group-item">Prix : ${prod.getPrix()}</li>
        <li class="list-group-item">Date d'achat : ${prod.getDateAchat()}</li>
        <li class="list-group-item">Stock : ${prod.getStock()}</li>
    </ul>

</body>
</html>
