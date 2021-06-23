package by.catalog.web.servlet;

import by.catalog.entity.User;
import by.catalog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/userList")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        List<User> userList = userService.allUsersList();
        req.setAttribute("allUsers", userList);
        req.getServletContext().getRequestDispatcher("/pages/userList.jsp").forward(req, resp);
    }
}
