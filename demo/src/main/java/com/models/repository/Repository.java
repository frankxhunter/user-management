package com.models.repository;

import java.sql.SQLException;
import java.util.List;
public interface Repository<T> {
    
    List<T> findAll()  throws SQLException;

    T find(String id)  throws SQLException;

    boolean save(T t)  throws SQLException;

    boolean update(T t)  throws SQLException;

    T delete(String id)  throws SQLException;
}
