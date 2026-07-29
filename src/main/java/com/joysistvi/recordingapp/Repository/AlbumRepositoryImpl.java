package com.joysistvi.recordingapp.Repository;

import com.joysistvi.recordingapp.Model.Album;
import com.joysistvi.recordingapp.config.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumRepositoryImpl implements AlbumRepo {

    private final DbConnection dbConnection;

    public AlbumRepositoryImpl(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public void addAlbum(Album album) {

        String checkArtist = "SELECT id FROM artists WHERE id=?";

        try(Connection conn = dbConnection.connect();
            PreparedStatement check = conn.prepareStatement(checkArtist)) {

            check.setString(1, album.getArtistsId());

            ResultSet rs = check.executeQuery();

            if(!rs.next()) {
                System.out.println("Artist ID does not exist!");
                return;
            }


            String sql = "INSERT INTO albums(id,name,year,artists_id) VALUES(?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, album.getId());
            ps.setString(2, album.getName());
            ps.setInt(3, album.getYear());
            ps.setString(4, album.getArtistsId());

            ps.executeUpdate();

            System.out.println("Album added successfully!");

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Album> getAllAlbums() {

        List<Album> albums = new ArrayList<>();

        String sql = "SELECT * FROM albums";

        try(Connection conn = dbConnection.connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()){

                Album album = new Album();

                album.setId(rs.getString("id"));
                album.setName(rs.getString("name"));
                album.setYear(rs.getInt("year"));
                album.setArtistsId(rs.getString("artists_Id"));
                albums.add(album);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return albums;
    }

    @Override
    public void updateAlbum(Album album) {

        String sql = "UPDATE albums SET name=?, year=?, artists_Id=? WHERE id=?";

        try(Connection conn = dbConnection.connect();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, album.getName());
            ps.setInt(2, album.getYear());
            ps.setString(3, album.getArtistsId());
            ps.setString(4, album.getId());

            ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAlbum(String id) {

        String sql = "DELETE FROM albums WHERE id=?";

        try(Connection conn = dbConnection.connect();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, id);
            ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}