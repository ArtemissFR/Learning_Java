package com.votreentreprise.servlets;

// Importez les packages nécessaires

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Traitement de l'ajout d'utilisateur dans la base de données (utilisez le formulaire d'inscription)
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);

        DatabaseUtil.addUser(user);

        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupération et affichage de la liste des utilisateurs depuis la base de données
        List<User> userList = DatabaseUtil.getAllUsers();
        request.setAttribute("users", userList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/userlist.jsp");
        dispatcher.forward(request, response);
    }
}
