package com.eventos.apirest.iterator;

import sun.management.BaseOperatingSystemImpl;

import java.sql.ResultSet;

public interface IteratorInterface {

    void First();

    void Next();

    boolean isDone();

    boolean hasNext();

    ResultSet currentItem();

}