<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dossier Patient</title>
    <jsp:include page="../../includes/head.jsp" />
</head>
<body>
<jsp:include page="../../includes/header.jsp"/>
<h1>Dossier n°${patient.getId()}</h1>

<div class="container">
    <div class="row">
        <div class="col-lg-6">
            <ul class="list-group">
                <li class="list-group-item">Nom : ${patient.getNom().toUpperCase()}</li>
                <li class="list-group-item">Prénom : ${patient.getPrenom()}</li>
                <li class="list-group-item">né(e) le ${patient.getNaissance()}</li>
            </ul>
        </div>
        <div class="col-lg-4">
            <img src="${pageContext.request.contextPath}/photo" alt="photo id" class="img-fluid mx-auto" />
        </div>
    </div>
</div>

<div class="container align-self-center mt-5">
    <div class="row">
        <div class="col-8 ">

            <table class="table table-dark">
                <thead>
                <tr>
                    <th scope="col">Date</th>
                    <th scope="col">Médecin</th>
                    <th scope="col">Nombre de soins</th>
                    <th scope="col">Nombre de prescriptions</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${not empty patients.getConsultationList()}">
                            <c:forEach items="${patients.getConsultationList()}" var="consult">
                                <ul>
                                    <td>${consult.getDate()}</td>
                                    <td>${consult.getMedecin()}</td>
                                    <td>${consult.getFichesSoins().size()}</td>
                                    <td>${consult.getPrescriptions().size()}</td>
                                    <td>
                                        <a class="btn btn-info" href="dossier?id=${pat.getId()}" >détails</a>
                                    </td>
                                </ul>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <tr><td colspan="5">Aucune fiche de soin</td></tr>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>

            <form action="insert" method="post" class="border border-primary rounded p-3 ">
                <div class="form-row mb-4">
                    <div class="col-12">
                        <h5>Ajouter une fiche de soin</h5>
                    </div>

                    <div class="form-group col-10">
                        <label for="medecin">Nom du médecin</label>
                        <input type="text" class="form-control" id="medecin" name="medecin" >
                    </div>

                        <button type="submit" class="btn btn-primary">Ajouter</button>
                </div>
            </form>
        </div>
    </div>
</div>



</body>
</html>
