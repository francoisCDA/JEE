<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Les patients</title>
    <jsp:include page="../../includes/head.jsp" />
</head>
<body>
<jsp:include page="../../includes/header.jsp"/>
<h1>Liste des patients</h1>

<div class="container">
    <div class="row">
        <div class="col-8 ">
           <table class="table table-dark">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Nom</th>
                    <th scope="col">Prenom</th>
                    <th scope="col">Date de naissance</th>
                    <th scope="col">Dossier médical</th>
                </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${not empty patients}">
                            <c:forEach items="${patients}" var="pat">
                            <tr>
                                <td>${pat.getId()}</td>
                                <td>${pat.getNom()}</td>
                                <td>${pat.getPrenom()}</td>
                                <td>${pat.getNaissance()}</td>
                                <td>
                                    <a class="btn btn-info" href="dossier?${pat.getId()}" >-></a>
                                </td>
                            </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <tr><td colspan="5">Aucun patient inscrit</td></tr>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
