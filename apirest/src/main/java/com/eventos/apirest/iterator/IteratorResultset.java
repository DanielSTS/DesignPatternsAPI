package com.eventos.apirest.iterator;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IteratorResultset implements IteratorInterface {

    protected ResultSet resultSet;
    protected int contador;

    public IteratorResultset(ResultSet rs) {
        this.resultSet = rs;
    }
    @Override
    public void First() {
        try {
            this.resultSet.first();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void Next() {
        try {
            this.resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean isDone() {

        try {
            return resultSet.isLast();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean hasNext(){
        try {
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public ResultSet currentItem() {
        return null;
    }
}
