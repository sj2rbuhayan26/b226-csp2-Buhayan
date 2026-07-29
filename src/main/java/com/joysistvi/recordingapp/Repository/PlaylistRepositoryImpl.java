package com.joysistvi.recordingapp.Repository;

import com.joysistvi.recordingapp.Model.Playlist;
import com.joysistvi.recordingapp.config.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistRepositoryImpl implements PlaylistRepo {


    private final DbConnection dbConnection;


    public PlaylistRepositoryImpl(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }


    @Override
    public void addPlaylist(int userId) {

        String sql = "INSERT INTO playlist(user_id) VALUES (?)";


        try(Connection conn = dbConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setInt(1,userId);

            stmt.executeUpdate();


        } catch(SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public List<Playlist> getAllPlaylists() {


        List<Playlist> playlists = new ArrayList<>();

        String sql = "SELECT * FROM playlist";

        try(Connection conn = dbConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while(rs.next()) {

                Playlist playlist = new Playlist(

                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getDate("date_Created")

                );

                playlists.add(playlist);

            }


        } catch(SQLException e){

            e.printStackTrace();

        }


        return playlists;

    }



    @Override
    public void updatePlaylist(int id) {

        System.out.println("Update playlist ID: " + id);

    }



    @Override
    public void deletePlaylist(int id) {

        String sql = "DELETE FROM playlist WHERE id=?";

        try(Connection conn = dbConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Playlist deleted successfully!");

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

}