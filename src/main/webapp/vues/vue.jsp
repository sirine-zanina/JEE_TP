<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
              <li class="nav-item active">
                <a class="nav-link" href="produits">Produits <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item active">
                <a class="nav-link" href="categories">Categories <span class="sr-only">(current)</span></a>
              </li>

            </ul>
           <form method="get" action="search">
            <div class="input-group">
              <div class="form-outline">
                <input type="text" id="form1" class="form-control" name="mc" />

              </div>
              <button type="submit" value="rechercher" class="btn btn-primary" >
                <i class="fa fa-search"></i>
              </button>
            </div>
            </form>
          </div>
        </nav>
        <br>

        <br>
        <div class="d-flex flex-row-reverse">
          <div class="p-2">
              <a href="add" class="btn btn-success">Ajouter un nouveau produit</a>
          </div>
        </div>
        <br>
        <h1> Liste des produits</h1>
        <br />

        <table class="table">
               <tr>
                   <th>ID</th>
                   <th>Nom</th>
                   <th>Prix</th>
                   <th>Quantite</th>
                   <th>Catégorie</th>

                   <th>Action sur produit</th>
                 </tr>
                 <c:forEach items="${produits}" var="p">
                 <tr>
                     <td>${p.id}</td>
                     <td>${p.nom}</td>
                     <td>${p.prix}</td>
                     <td>${p.quantite}</td>
                     <td>${p.categorie.getNom()}</td>
                     <td>
                         <a href="delete/${p.id}"><span class="fa fa-trash"></span></a>
                          <a href="edit/${p.id}"><span class="fa fa-edit"></span></a>
                    </td>
                </tr>
                </c:forEach>
        </table>

    </body>
</html>