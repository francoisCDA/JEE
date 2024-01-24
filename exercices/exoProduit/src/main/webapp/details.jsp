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
        <li class="list-group-item">URL image : ${prod.getPathImg()}</li>
    </ul>

    <div>
        <img src="images/${prod.getPathImg()}" />
    </div>

    <form action="upload" method="post" enctype="multipart/form-data">
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">Upload</span>
            </div>
            <div class="custom-file" >
                <input type="file" name="image" class="custom-file-input" id="inputGroupFile01" />
                <label class="custom-file-label" for="inputGroupFile01">Select image</label>
            </div>
        </div>
        <div>
            <button type="submit" class="btn btn-primary" name="idUpdt" value="${prod.getId()}" >Charger</button>
        </div>
    </form>


</body>
</html>
