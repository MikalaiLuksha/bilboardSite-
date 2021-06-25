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

@WebServlet(urlPatterns = "/createBoard")
public class CreateBoardServlet extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = userService.allUsersList();
        req.setAttribute("userList", userList);
        req.getServletContext().getRequestDispatcher("/pages/createBoard.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] userPerformers = req.getParameterValues("userPerformer");
        String join = String.join(" ", userPerformers);
        String s = userPerformers.toString();
        long[] longs = userService.userIdFromCreateBoard(userPerformers);
        long[] longs1 = longs;
        String task = req.getParameter("task");
        String task1 = task;
    }
}

