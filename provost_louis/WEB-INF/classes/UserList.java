import java.io.*;
import java.util.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;


@WebServlet("/UserList")
public class UserList extends HttpServlet {
    final String URL="jdbc:mysql://localhost/tomcat";  //  final String URL = "jdbc:mysql://127.0.0.1/tomcat";
    final String USER="tomcat";
    final String PWD="password";
    final String DRIVER="com.mysql.cj.jdbc.Driver";
    Connection connection = null;

public void init() throws ServletException {
    try {
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(URL, USER, PWD);
    } catch (SQLException | ClassNotFoundException e ) {
        e.printStackTrace();
        throw new ServletException("Erreur lors de l'initialisation de la connexion à la base de données", e);
    }
}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT lastname, firstname FROM users");
        ResultSetMetaData metaData = resultSet.getMetaData();
        int nombreColonnes = metaData.getColumnCount();
        PrintWriter out = response.getWriter();
        out.println("<html>\n<head>\n<title>List User</title>\n</head>\n<body>\n<table border=\"1\">\n<thead>\n<tr>\n<th>FirstName</th>\n<th>LastName</th>\n</tr>\n</thead>\n<tbody>");
        while (resultSet.next()) {
            out.println("<tr>");
            for (int i = 1; i <= nombreColonnes; i++) {
                out.println("<td>");
                out.print(resultSet.getString(i) + " ");
                out.println("</td>");
            }
            out.println("</tr>");
        }
        out.println("</tbody>\n</table>\n</body>\n</html>");
        out.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
