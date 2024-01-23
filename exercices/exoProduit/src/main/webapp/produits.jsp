<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des produits</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
    <h1>Tous les produits</h1>

    <div class="container">
        <div class="row">
            <div class="col-8 ">
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Marque</th>
            <th scope="col">Référence</th>
            <th scope="col">Prix</th>
            <th scope="col">Date achat</th>
            <th scope="col">Stock</th>
        </tr>
        </thead>
        <tbody>

<c:forEach items="${produits}" var="produit">
    <tr>
        <td>${produit.getId()}</td>
        <td>${produit.getMarque()}</td>
        <td>${produit.getReference()}</td>
        <td>${produit.getPrix()}</td>
        <td>${produit.getDateAchat()}</td>
        <td>${produit.getStock()}</td>
    </tr>

</c:forEach>

        </tbody>
    </table>

            </div>
            <div class="col-4 ">
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

            </div>
            </div>
    </div>

    <a href="index.jsp">Accueil</a>
    <br/>
    <a href="new-produits.jsp">Ajouter produits</a>


</body>
</html>
