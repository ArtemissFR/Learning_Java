<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inscription</title>
</head>
<body>
    <h2>Inscription</h2>
    <form action="users" method="post">
        Prénom: <input type="text" name="firstName"><br>
        Nom: <input type="text" name="lastName"><br>
        Mot de passe: <input type="password" name="password"><br>
        <input type="submit" value="S'inscrire">
    </form>
</body>
</html>
