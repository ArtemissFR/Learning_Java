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
  final String URL "JDBC:mysql://localhost/tomcat";
  final String USER = "tomcat";
  final String PWD = "louis";
  final String Driver = "com.mysql.cj.jdbc.Driver";
  Connection connection;
