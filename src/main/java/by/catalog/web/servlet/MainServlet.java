package by.catalog.web.servlet;

import by.catalog.entity.Board;
import by.catalog.entity.User;
import by.catalog.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User currentUser = (User) req.getSession().getAttribute("currentUser");
        if (currentUser != null) {
            BoardService boardService = new BoardService();
            List<Board> boardList = boardService.returnBoardByIdUser(currentUser.getId());
            List<Board> boardList1 = boardList;

        }
        req.getServletContext().getRequestDispatcher("/pages/index.jsp").forward(req, resp);
    }
}

