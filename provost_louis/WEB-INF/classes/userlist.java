import java.io.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/userlist")
public class userlist extends
  HTTPServlet
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
