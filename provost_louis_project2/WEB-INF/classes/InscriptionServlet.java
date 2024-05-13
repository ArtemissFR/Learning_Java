import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class InscriptionServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String motDePasse = request.getParameter("motdepasse");

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nom_de_votre_base_de_donnees", "votre_utilisateur_mysql", "votre_mot_de_passe_mysql");
            PreparedStatement ps = con.prepareStatement("INSERT INTO utilisateurs (nom, prenom, mot_de_passe) VALUES (?, ?, ?)");
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setString(3, motDePasse);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        response.sendRedirect("index.jsp");
    }
}
