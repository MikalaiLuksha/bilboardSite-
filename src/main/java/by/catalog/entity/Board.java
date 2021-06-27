package by.catalog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    private long id;
    private String task;
    private long[] userId;
    private Calendar addDate;

    public Board(String task, long[] userId, Calendar addDate) {
        this.task = task;
        this.userId = userId;
        this.addDate = addDate;

    }

    public Board(String task, long[] userId) {
        this.task = task;
        this.userId = userId;
    }

    public Board(long id, String task, long[] userId) {
        this.id = id;
        this.task = task;
        this.userId = userId;
    }

    public Board(long id, String task) {
        this.id = id;
        this.task = task;
    }
}
