<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter Categorie</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
	integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>
	<br>
	<br>
	<div class=container-fluid>
		<div class="card mx-5">
			<div class="card-header">
				<c:if test='${categorie.id==null}'>Ajouter Categorie</c:if>
				<c:if test='${categorie.id!=null}'>Modifier Categorie</c:if>
			</div>
			<div class="card-body">
				<form method="post" action="/ajouterCategorie">
					<div class="mb-3">
						<label for="nom" class="form-label">Nom </label> <input
							type="text" class="form-control" id="nom" name="nom"
							value="${categorie.nom}">
					</div>
					<button type="submit" class="btn btn-primary">
						<c:choose>
							<c:when test="${categorie.id == null}">Ajouter</c:when>
							<c:otherwise>Modifier </c:otherwise>
						</c:choose>
					</button>
					<input type="hidden" name="id" value="${categorie.id}">
				</form>
				
			</div>
		</div>
	</div>
</body>
</html>