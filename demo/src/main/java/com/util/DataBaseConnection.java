package com.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;



public class DataBaseConnection {
    private static final String url = "jdbc:mysql://localhost:3306/users";

    private static final String username = "root";

    private static final String password = "root";

    private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";

    private static BasicDataSource pool = null;

    
    private static BasicDataSource getInstance(){
        if(pool == null){
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(username);
            pool.setPassword(password);
            pool.setDriverClassName(DRIVER_CLASS_NAME);

            
            pool.setInitialSize(3);
            pool.setMinIdle(3);
            pool.setMaxIdle(8);
        }
        return pool;
    }
    public static Connection getConnection() throws SQLException{
        return getInstance().getConnection();
    }


}
