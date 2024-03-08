// ListeUtilisateursServlet.java
// Importez les classes nécessaires
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

@WebServlet("/ListeUtilisateursServlet")
public class ListeUtilisateursServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Liste des utilisateurs</title></head><body>");

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Charger le driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Établir la connexion à la base de données
            String url = "jdbc:mysql://localhost:3306/tomcat";
            String utilisateur = "tomcat";
            String motDePasse = "louis";
            conn = DriverManager.getConnection(url, utilisateur, motDePasse);

            // Exécuter la requête SQL
            String sql = "SELECT * FROM users";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            // Afficher les résultats
            out.println("<h2>Liste des utilisateurs</h2><ul>");
            while (rs.next()) {
                String nom = rs.getString("lastname");
                String prenom = rs.getString("firstname");
                out.println("<li>" + prenom + " " + nom + "</li>");
            }
            out.println("</ul>");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("Erreur : " + e.getMessage());

        } finally {
            // Fermer les ressources
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        out.println("</body></html>");
    }
}
