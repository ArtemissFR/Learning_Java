<%@ page import="java.util.*" %>
<html>
<head>
    <title>JIHESPE</title>
    <style>

        h1 {
            font-size: 2em;
        }

        p {
            font-size: 1.5em;
            margin: 0;
        }

        table {
            border-collapse: collapse;
            width: 50%;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: center;
        }

        img {
            max-width: 20%;
            height: auto;
            margin-top: 20px;
        }
    </style>
</head>
<body>

    <div>
        <p>Date du jour : <%= new Date() %></p>
        <h1>Mon prenom et nom</h1>
        <p>Prenom: Louis</p>
        <p>Nom: Provost</p>

        <h2>Les dix premiers chiffres :</h2>
        <table>
            <tr>
                <th>Chiffre</th>
                <th>Carre</th>
            </tr>
            <% for (int i = 1; i <= 10; i++) { %>
                <tr>
                    <td><%= i %></td>
                    <td><%= i*i %></td>
                </tr>
            <% } %>
        </table>

        <img src="https://www.pngmart.com/files/12/Kangaroo-Roger-Tekken-PNG-File.png" alt="Renault Kangoo">
    </div>

</body>
</html>
