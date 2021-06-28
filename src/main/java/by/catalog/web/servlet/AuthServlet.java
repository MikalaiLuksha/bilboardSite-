package by.catalog.web.servlet;

import by.catalog.entity.User;
import by.catalog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserService userService = new UserService();
        User currentUser = userService.getUserByLoginAndPassword(login, password);
        if (currentUser != null) {
            req.getSession().setAttribute("currentUser", currentUser);
            req.getSession().setAttribute("key1", true);
            if (currentUser.getRole().equals("admin")){
                req.getSession().setAttribute("admin", true);
            }
//            req.getServletContext().getRequestDispatcher("/pages/index.jsp").forward(req, resp);
            resp.sendRedirect("/");

        }
        else {
            String checkAuth = userService.checkLoginAndPassword(login, password);
            req.getSession().setAttribute("check", true);
            req.getSession().setAttribute("checkAuth", checkAuth);
//            req.getServletContext().getRequestDispatcher("/pages/index.jsp").forward(req, resp);
            resp.sendRedirect("/");

        }
    }
}
