package by.catalog.web.servlet;

import by.catalog.entity.Board;
import by.catalog.entity.User;
import by.catalog.service.BoardService;
import by.catalog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

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
        Date date= new Date();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        long[] longs = userService.userIdFromCreateBoard(userPerformers);
        String task = req.getParameter("task");
        Board board = new Board(task, longs);
        board.setAddDate(calendar);
        BoardService boardService = new BoardService();
        boardService.saveBoard(board);
        resp.sendRedirect("/createBoard");


//        String join = String.join(" ", userPerformers);
//        String[] userIdArray = join.split(" ");
//        Board board1 = board;
//        String string = board.getAddDate().toString();
//        String string1 = string;
//        long time = board.getAddDate().getTime().getTime();
//        long timeInMillis = board.getAddDate().getTimeInMillis();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        GregorianCalendar calendar1 = new GregorianCalendar();
//        calendar1.setTimeInMillis(timeInMillis);
//        String format = sdf.format(calendar1.getTime());
//        String format1 = format;

    }

}

