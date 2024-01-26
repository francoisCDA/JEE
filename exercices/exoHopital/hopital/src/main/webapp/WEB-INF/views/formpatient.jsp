<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../../includes/head.jsp" />
</head>
<body>
<jsp:include page="../../includes/header.jsp"/>
<h1>Inscription nouveau patient</h1>

<div>
    <form action="insert" method="post" enctype="multipart/form-data">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="nom">Nom</label>
                <input type="text" class="form-control" id="nom" name="nom" >
            </div>
            <div class="form-group col-md-6">
                <label for="prenom">Prénom</label>
                <input type="text" class="form-control" id="prenom" name="prenom" >
            </div>
            <div class="form-group col-md-4">
                <label for="naissance">Date de naissance</label>
                <input type="date" class="form-control" id="naissance" name="naissance" >
            </div>
            <div class="mb-3">
                <label for="photo" class="form-label">Image</label>
                <input class="form-control" type="file" id="photo" name="photo" accept="image/*" >
            </div>
        </div>
        <button type="submit" class="btn btn-primary">${produit == null ? 'Validation' : 'Update'}</button>
    </form>
</div>


</body>
</html>
