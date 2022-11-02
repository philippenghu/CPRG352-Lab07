package servelets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.RoleService;
import services.UserService;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        displayAll(request, response);
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String email = "";
        boolean active = false;
        String firstname = "";
        String lastname = "";
        String password = "";
        int roleID = 0;
        String roleName = "";
        String editMessage = "";
        UserService userService = new UserService();
        User user;
        ArrayList<User> users;
        User editUser = null;
        RoleService roleService = new RoleService();
        try {
            users = userService.getAll();
            if (action != null) {
                switch (action) {
                    case "save":
                        email = request.getParameter("email");
                        active = request.getParameter("active") != null;
                        firstname = request.getParameter("firstname");
                        lastname = request.getParameter("lastname");
                        password = request.getParameter("password");
                        roleID = Integer.parseInt(request.getParameter("role"));
                        roleName = roleService.getRoleName(roleID);
                        String message;
                        if (email.equals(null) || email.equals("")
                                || firstname.equals(null) || firstname.equals("")
                                || lastname.equals(null) || lastname.equals("")
                                || password.equals(null) || password.equals("")) {
                            message = "Please correctly enter all the information.";
                            request.setAttribute("message", message);

                        } else if (!users.isEmpty()) {
                            boolean duplicated = false;
                            for (int i = 0; i < users.size(); i++) {
                                if (email.equals(users.get(i).getEmail())) {
                                    message = "Email duplicated, fail to add user.";
                                    request.setAttribute("message", message);
                                    duplicated = true;
                                }
                            }
                            if (duplicated == false) {
                                user = new User(email, active, firstname, lastname, password, roleID, roleName);
                                userService.insert(user);
                                message = "User " + email + " successfully added";
                                request.setAttribute("message", message);
                            }
                        } else if (users.isEmpty()) {
                            user = new User(email, active, firstname, lastname, password, roleID, roleName);
                            userService.insert(user);
                            message = "User " + email + " successfully added";
                            request.setAttribute("message", message);

                        }
                        break;
                    case "showEdit":
                        email = (String) request.getParameter("editUser");
                        editUser = userService.getUser(email);
                        request.setAttribute("editUser", editUser);
                        session.setAttribute("editUser", editUser);
                        break;
                    case "delete":
                        email = request.getParameter("deleteUser");
                        editUser = userService.getUser(email);
                        userService.delete(editUser);
                        editMessage = "User " + email + " Deleted";
                        request.setAttribute("editMessage", editMessage);
                        break;
                    case "reset":
                        user = new User(email, active, firstname, lastname, password, roleID, roleName);
                        request.setAttribute("editUser", user);
                        break;
                    case "update":
                        user = (User) session.getAttribute("editUser");
                        email = (String) user.getEmail();
                        ;
                        active = request.getParameter("activeEdit") != null;
                        firstname = request.getParameter("firstnameEdit");
                        lastname = request.getParameter("lastnameEdit");
                        password = request.getParameter("passwordEdit");
                        roleID = Integer.parseInt(request.getParameter("editRole"));
                        roleName = roleService.getRoleName(roleID);
                        if (firstname == null || firstname.equals("")
                                || lastname == null || lastname.equals("")
                                || password == null || password.equals("")) {
                            editMessage = "Please correctly enter all the information.";
                            request.setAttribute("editMessage", editMessage);

                        } else {
                            User editedUser = new User(email, active, firstname,
                                    lastname, password, roleID, roleName);
                            userService.updateUser(editedUser);

                            editMessage = "User " + email + " Updated";
                            request.setAttribute("editMessage", editMessage);
                        }
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception ex) {
            String message = "Sorry, something went wrong.";
            request.setAttribute("message", message);
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        displayAll(request, response);
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
        return;
    }

    private void displayAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        ArrayList<User> users;
        try {
            users = userService.getAll();
            request.setAttribute("users", users);
        } catch (Exception ex) {
            String message = "Sorry, displaying exception.";
            request.setAttribute("message", message);
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
