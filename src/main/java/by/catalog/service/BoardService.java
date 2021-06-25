package by.catalog.service;

import by.catalog.entity.Board;
import by.catalog.storage.BoardStorage;

import java.util.List;

public class BoardService {
    BoardStorage boardStorage = new BoardStorage();

    public void saveBoard (Board board){
        boardStorage.addBoard(board);
    }

    public List<Board> returnBoardByIdUser(long id){
        return boardStorage.getBoardByIdUser(id);
    }
}
