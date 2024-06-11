package com.models.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.models.schema.User;

public class UserReposity implements Repository<User> {

    public Connection connection = null;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    private User createUser(ResultSet result) throws SQLException {
        String email = result.getString("email");
        String username = result.getString("username");
        String password = result.getString("password");
        String id = result.getString("id");

        return new User(username, email, password, id);
    }

    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();
        try (java.sql.Statement st = connection.createStatement()) {
            String query = "Select * from user ";
            ResultSet result = st.executeQuery(query);

            while (result.next()) {
                users.add(createUser(result));
            }
        }
        return users;
    }

    @Override
    public User find(String id) throws SQLException {
        User user = null;
        String query = "Select * from users where id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, id);

            ResultSet result = ps.executeQuery();
            if (result.next())
                user = createUser(result);
        }
        return user;

    }

    @Override
    public boolean save(User user) throws SQLException {
        if (user.getId() == null) {
            String query = "Insert into user (username, email, password) values (?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getPassword());

                ps.executeUpdate();
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(User user) throws SQLException {
        if (user.getId() != null) {
            String query = "Update user set username= ?, email = ?, password = ? WHERE id = ?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getPassword());
                ps.setString(4, user.getId());

                ps.executeUpdate();
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User delete(String id) throws SQLException {
        String query = "Delete from users where id = ?";
        User user = this.find(id);
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, id);
            ps.executeUpdate();
        }
        return user;
    }


}
