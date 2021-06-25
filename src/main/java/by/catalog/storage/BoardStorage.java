package by.catalog.storage;

import by.catalog.entity.Board;
import by.catalog.entity.User;
import by.catalog.service.UserService;

import java.sql.*;
import java.util.*;

public class BoardStorage {

    private Connection connection = null;

    private final static String URL_TABLES = "jdbc:postgresql://localhost:5432/billboardsite";
    private final static String LOGIN_TABLES = "postgres";
    private final static String PASS_TABLES = "1987Roll";

    private final static String ADD_BOARD = "insert into boarddata (id, task, iduser, adddate) values (default , ?, ?, ?)";
    private final static String GET_ALL_BOARD = "select * from boarddata";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addBoard(Board board) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_BOARD);
            preparedStatement.setString(1, board.getTask());
            String join = String.join(" ", board.getUserId().toString());
            preparedStatement.setString(2, join);
            preparedStatement.setLong(3, board.getAddDate().getTimeInMillis());
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Board> getBoardByIdUser(long idUser){
        List<Board> boardList = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_BOARD);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String arrayId = resultSet.getString(3);
                long[] longs = convertStringToArrayLong(arrayId);
                boolean b = checkId(idUser, longs);
                if (b){
                    long id = resultSet.getLong(1);
                    String task = resultSet.getString(2);
                    long aLong = resultSet.getLong(4);
                    GregorianCalendar calendar = new GregorianCalendar();
                    calendar.setTimeInMillis(aLong);
                    Board board = new Board( id, task, longs);
                    board.setAddDate(calendar);
                    boardList.add(board);
                }
            }
            return boardList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean checkId(long idUser, long[]arrayId) {
        for (long l : arrayId) {
            if (l == idUser) {
                return true;
            }
        }
        return false;
    }

    private long[] convertStringToArrayLong(String s){
        String[] userIdArray = s.split(", ");
        UserService userService = new UserService();
        return userService.userIdFromCreateBoard(userIdArray);
    }

}
