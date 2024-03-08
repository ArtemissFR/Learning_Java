import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listuser")
public class listuser extends HttpServlet {
  final String URL = "jdbc:mysql://127.0.0.1/tomcat";
  final String USER = "tomcat";
  final String PWD = "password";
  final String DRIVER = "com.mysql.cj.jdbc.Driver";
  Connection conn = null;

  public void init() throws ServletException {
    try {
      Class.forName(DRIVER);
      conn = DriverManager.getConnection(URL, USER, PWD);
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  try {
    Statement stmt = conn.createStatement();
    ResultSet results = stmt.executeQuery("SQL query");
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    ResultSetMetaData rsmd = results.getMetaData();
    int nbCols = rsmd.getColumnCount();
    while (results.next()) {
      for (int i = 1; i <= nbCols; i++) {
        out.println(results.getString(i);
      }
    }
    results.close();
    out.close();
  } catch (SQLException e) {
    e.printStackTrace();
  }
}
