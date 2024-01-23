<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un produit</title>
</head>
<body>
<h1>Ajout d'un produit</h1>

<form action="produits" method="post">
    <div class="mb-3">
        <label for="marque" class="form-label">Marque</label>
        <input type="text" class="form-control" id="marque" name="marque">
    </div>
    <div class="mb-3">
        <label for="reference" class="form-label">Reference</label>
        <input type="text" class="form-control" id="reference" name="reference">
    </div>
    <div class="mb-3">
        <label for="prix" class="form-label">Prix</label>
        <input type="number" class="form-control" id="prix" name="prix">
    </div>
    <div class="mb-3">
        <label for="date" class="form-label">Date d'achat</label>
        <input type="date" class="form-control" id="date" name="date">
    </div>
    <div class="mb-3">
        <label for="stock" class="form-label">Stock</label>
        <input type="number" class="form-control" id="stock" name="stock">
    </div>
    <button type="submit" class="btn btn-primary">Ajouter</button>
</form>


</body>
</html>
