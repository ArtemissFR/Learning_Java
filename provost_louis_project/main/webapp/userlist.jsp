<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Utilisateurs</title>
</head>
<body>
    <h2>Liste des Utilisateurs</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Prénom</th>
                <th>Nom</th>
                <th>Mot de passe</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.password}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
