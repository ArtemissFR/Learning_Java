// UserDAO.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/tomcat";
    private static final String USERNAME = "tomcat";
    private static final String PASSWORD = "louis";

    public List<User> getUsers() {
        List<User> userList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users");
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    User user = new User();
                    user.setFirstname(rs.getString("firstname"));
                    user.setLastname(rs.getString("lastname"));
                    // Ajoutez d'autres champs selon votre table

                    userList.add(user);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
}
