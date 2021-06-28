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

    private final static String ADD_BOARD = "insert into boarddata (id, task, adddate) values (default , ?, ?)";
    private final static String ADD_ID_BOARD_ID_USER = "insert into id_board_id_user (idboard, iduser) values (?, ?)";
    private final static String GET_ID_BOARD_BY_ID_USER = "select * from id_board_id_user s where s.iduser=?";
    private final static String GET_ID_USER_BY_ID_BOARD = "select * from id_board_id_user s where s.idboard=?";
    private final static String GET_BOARD_BY_ID = "select * from boarddata s where s.id=?";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public long addBoard(Board board) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_BOARD, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, board.getTask());
            preparedStatement.setLong(2, board.getAddDate().getTimeInMillis());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            long idBoard = 0;
            if (resultSet.next()){
                idBoard = resultSet.getLong(1);
                return idBoard;
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void addIdBoardIdUser(Board board, long idBoard) {
        long[] userId = board.getUserId();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_ID_BOARD_ID_USER);
            for (long l : userId) {
                preparedStatement.setLong(1, idBoard);
                preparedStatement.setLong(2, l);
                preparedStatement.execute();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Long> getIdBoardByIdUser(long idUser){
        List<Long> idList = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ID_BOARD_BY_ID_USER);
            preparedStatement.setLong(1, idUser);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long idBoardFromData = resultSet.getLong(1);
                idList.add(idBoardFromData);
            }
            connection.close();
            return idList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Long> getIdUserByIdBoard(long idUBoard){
        List<Long> idList = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ID_USER_BY_ID_BOARD);
            preparedStatement.setLong(1, idUBoard);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long idUserFromData = resultSet.getLong(2);
                idList.add(idUserFromData);
            }
            connection.close();
            return idList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Board getBoardById (long id) {
        GregorianCalendar calendar = new GregorianCalendar();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BOARD_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String task = resultSet.getString(2);
            long date = resultSet.getLong(3);
            connection.close();
            Board board = new Board(id, task);
            calendar.setTimeInMillis(date);
            board.setAddDate(calendar);
            return board;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }




}
