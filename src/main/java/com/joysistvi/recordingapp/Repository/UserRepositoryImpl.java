package com.joysistvi.recordingapp.Repository;

import com.joysistvi.recordingapp.Model.User;
import com.joysistvi.recordingapp.config.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepo {

    private final DbConnection dbConnection;

    public UserRepositoryImpl(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public User login(String username, String password) {

        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    @Override
    public boolean register(User user) {

        String sql = "INSERT INTO user(username,password,role) VALUES(?,?,?)";

        try(Connection conn = dbConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1,user.getUsername());
            stmt.setString(2,user.getPassword());
            stmt.setString(3,user.getRole());

            return stmt.executeUpdate()>0;

        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void addUser(User user) {

        String sql = "INSERT INTO user(username, password, role) VALUES (?, ?, ?)";

        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());

            stmt.executeUpdate();

            System.out.println("User added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM user";

        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                User user = new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                );

                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User getUserById(int id) {

        String sql = "SELECT * FROM user WHERE user_id = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void updateUser(User user) {

        String sql = "UPDATE user SET username=?, password=?, role=? WHERE user_id=?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            stmt.setInt(4, user.getId());

            stmt.executeUpdate();

            System.out.println("User updated successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {

        String sql = "DELETE FROM user WHERE user_id=?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("User deleted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}