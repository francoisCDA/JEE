
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--  <jsp:include page="head.jsp" />--%>
<%--  <title></title>--%>
<%--</head>--%>
<%--<body>--%>

  <nav class="navbar navbar-expand-lg navbar-light bg-light shadow-lg">
    <a class="navbar-brand" href="#">Hello'spital</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="patients">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="addpatient">Inscription</a>
        </li>
      </ul>
      <div class="form-inline  gx-4 my-lg-0 text-center ">
        <c:if test="${not empty sessionScope.admin}">
          <div class="mx-4">
            <span>Mode admin</span>
            <a class="btn btn-outline-danger my-2 my-sm-0" href="disconnect" >disconnect</a>
          </div>
        </c:if>
      </div>
    </div>
  </nav>
<%--</body>--%>
<%--</html>--%>
