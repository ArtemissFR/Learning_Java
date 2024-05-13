<%@ page import="java.util.List" %>
<%@ page import="your.package.Utilisateur" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Liste des utilisateurs</title>
</head>
<body>
    <h2>Liste des utilisateurs</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Mot de passe</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${utilisateurs}" var="utilisateur">
                <tr>
                    <td>${utilisateur.nom}</td>
                    <td>${utilisateur.prenom}</td>
                    <td>${utilisateur.motDePasse}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
