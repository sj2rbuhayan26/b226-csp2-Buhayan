package com.joysistvi.recordingapp.Repository;

import com.joysistvi.recordingapp.Model.Artist;
import com.joysistvi.recordingapp.config.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistRepositoryImpl implements ArtistRepo {

    private final DbConnection dbConnection;

    public ArtistRepositoryImpl(DbConnection dbConnection){
        this.dbConnection = dbConnection;
    }
    @Override
    public Artist getArtistById(int id) {

        String sql = "SELECT * FROM artist WHERE id = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Artist(
                        rs.getInt("id"),
                        rs.getString("name")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    @Override
    public void addArtist(Artist artist){
        String sql = "INSERT INTO artists(name) VALUES(?)";

        try (Connection conn = dbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, artist.getName());
            stmt.executeUpdate();

            System.out.println("Artist Added Successfully");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public List<Artist> getAllArtist(){
        List<Artist> artist = new ArrayList<>();

        String sql = "SELECT * FROM artists";

        try (Connection conn = dbConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()){

            while (rs.next()){
                artist.add(new Artist(
                        rs.getInt("id"),
                        rs.getString("name")
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return artist;
    }
    @Override
    public void updateArtist(Artist artist){

        String sql = "UPDATE artists SET name=? WHERE id";

        try (Connection conn = dbConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1,artist.getName());
            stmt.setInt(2,artist.getId());

            stmt.executeUpdate();

            System.out.println("Artist Updated Successfully");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public void deleteArtist(int id){
        String sql = "DELETE FROM artists WHERE id =?";

        try (Connection conn = dbConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1,id);

            stmt.executeUpdate();

            System.out.println("Artist Delete Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
