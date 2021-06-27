package by.catalog.service;

import by.catalog.entity.Board;
import by.catalog.storage.BoardStorage;

import java.util.ArrayList;
import java.util.List;

public class BoardService {
    BoardStorage boardStorage = new BoardStorage();

    public void saveBoard (Board board){
        long l = boardStorage.addBoard(board);
        boardStorage.addIdBoardIdUser(board, l);
    }

    public List<Board> returnBoardByIdUser(long id){
        List<Board> boardList = new ArrayList<>();
        List<Long> idBoardByIdUser = boardStorage.getIdBoardByIdUser(id);
        for (Long aLong : idBoardByIdUser) {
            Board boardById = boardStorage.getBoardById(aLong);
            List<Long> idUserByIdBoard = boardStorage.getIdUserByIdBoard(aLong);
            long[] longs = convertToArrayListLong(idUserByIdBoard);
            boardById.setUserId(longs);
            boardList.add(boardById);
        }
        return boardList;

    }

    private long[] convertToArrayListLong(List<Long> longList){
        long[]arrayLong = new long[longList.size()];
        for (int i = 0; i < arrayLong.length; i++) {
            arrayLong[i] = longList.get(i);
        }
        return arrayLong;
    }
}
