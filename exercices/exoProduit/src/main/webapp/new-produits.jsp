<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un produit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<h1>Ajout d'un produit</h1>

<form action="produits" method="post">
    <div class="mb-3">
        <label for="marque" class="form-label">Marque</label>
        <input type="text" class="form-control" id="marque" name="marque" value="${prod.getMarque()}">
    </div>
    <div class="mb-3">
        <label for="reference" class="form-label">Reference</label>
        <input type="text" class="form-control" id="reference" name="reference" value="${prod.getReference()}">
    </div>
    <div class="mb-3">
        <label for="prix" class="form-label">Prix</label>
        <input type="number" class="form-control" id="prix" name="prix" value="${prod.getPrix()}" >
    </div>
    <div class="mb-3">
        <label for="date" class="form-label">Date d'achat</label>
        <input type="date" class="form-control" id="date" name="date" value="${prod.getDateAchat()}">
    </div>
    <div class="mb-3">
        <label for="stock" class="form-label">Stock</label>
        <input type="number" class="form-control" id="stock" name="stock" value="${prod.getStock()}">
    </div>
    <button type="submit" class="btn btn-primary" name="idPrdct" value="${prod.getId()}" >Update</button>
</form>


</body>
</html>
