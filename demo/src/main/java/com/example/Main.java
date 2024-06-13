package com.example;

import java.sql.SQLException;

import com.models.repository.UserReposity;
import com.util.DataBaseConnection;

public class Main {
    public static void main(String[] args) {
        UserReposity rep = null;
        try {
            rep = new UserReposity();
            rep.setConnection(DataBaseConnection.getConnection());
            System.out.println("\nDatos de los usuarios");
            rep.findAll().forEach(e -> System.out.println(e.toString()));

            rep.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}