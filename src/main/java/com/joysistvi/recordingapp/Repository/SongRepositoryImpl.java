package com.joysistvi.recordingapp.Repository;

import com.joysistvi.recordingapp.Model.Song;
import com.joysistvi.recordingapp.config.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongRepositoryImpl implements SongRepo {

    private final DbConnection dbConnection;

    // Constructor Injection
    public SongRepositoryImpl(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    // CREATE SONG
    @Override
    public boolean createSong(Song song) {

        String query = "INSERT INTO songs (title, length, genre, album_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setString(1, song.getTitle());
            prep.setString(2, song.getLength());
            prep.setString(3, song.getGenre());
            prep.setInt(4, song.getAlbumId());

            System.out.println("Album ID being inserted: " + song.getAlbumId());


            return prep.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Create Song Error: " + e.getMessage());
        }

        return false;
    }

    // READ ALL SONGS
    @Override
    public List<Song> getAllSongs() {

        List<Song> songs = new ArrayList<>();

        String query =
                "SELECT s.id, s.title, s.length, s.genre, a.name, a.id AS albumId " +
                        "FROM songs s " +
                        "JOIN albums a ON s.album_id = a.id " +
                        "WHERE s.is_archived = FALSE";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query);
             ResultSet rs = prep.executeQuery()) {

            while (rs.next()) {

                Song song = new Song(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("length"),
                        rs.getString("genre"),
                        rs.getString("name"),
                        rs.getInt("albumId")
                );

                songs.add(song);
            }

        } catch (SQLException e) {
            System.out.println("Read Songs Error: " + e.getMessage());
        }

        return songs;
    }

    // UPDATE SONG
    @Override
    public boolean updateSong(Song song) {

        String query = "UPDATE songs SET title=?, length=?, genre=? WHERE id=?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setString(1, song.getTitle());
            prep.setString(2, song.getLength());
            prep.setString(3, song.getGenre());
            prep.setInt(4, song.getId());

            return prep.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Update Song Error: " + e.getMessage());
        }

        return false;
    }

    // DELETE SONG
    @Override
    public boolean deleteSong(int id) {

        String query = "DELETE FROM songs WHERE id = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setInt(1, id);

            return prep.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Delete Song Error: " + e.getMessage());
        }
        return false;
    }

    //ARCHIVED
    @Override
    public boolean archiveSong(int id) {

        String query = "UPDATE songs SET is_archived = TRUE WHERE id = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setInt(1, id);

            return prep.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Archive Song Error: " + e.getMessage());
        }

        return false;
    }

    //RESTORE SONG
    @Override
    public boolean restoreSong(int id) {

        String query = "UPDATE songs SET is_archived = FALSE WHERE id = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setInt(1, id);

            int rows = prep.executeUpdate();
            System.out.println("Rows updated = " + rows);

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    //SEARCH SONG
    @Override
    public List<Song> searchSong(String keyword) {
        List<Song> songs = new ArrayList<>();

        String query =
                "SELECT s.id, s.title, s.length, s.genre, a.name, a.id AS albumId " +
                        "FROM songs s " +
                        "JOIN albums a ON s.album_id = a.id " +
                        "WHERE s.is_archived = FALSE " +
                        "AND (s.title LIKE ? OR s.genre LIKE ? OR a.name LIKE ?)";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            String search = "%" + keyword + "%";

            prep.setString(1, search);
            prep.setString(2, search);
            prep.setString(3, search);

            ResultSet rs = prep.executeQuery();

            while (rs.next()) {
                Song song = new Song(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("length"),
                        rs.getString("genre"),
                        rs.getString("name"),
                        rs.getInt("albumId")
                );

                songs.add(song);
            }

        } catch (SQLException e) {
            System.out.println("Search Song Error: " + e.getMessage());
        }

        return songs;
    }

    //READ ACHIVED SONG
    @Override
    public List<Song> readArchivedSong() {

        List<Song> songs = new ArrayList<>();

        String query =
                "SELECT s.id, s.title, s.length, s.genre, a.name, a.id AS albumId " +
                        "FROM songs s " +
                        "JOIN albums a ON s.album_id = a.id " +
                        "WHERE s.is_archived = TRUE";

        try (Connection conn = dbConnection.connect();
             PreparedStatement prep = conn.prepareStatement(query);
             ResultSet rs = prep.executeQuery()) {

            while (rs.next()) {

                Song song = new Song(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("length"),
                        rs.getString("genre"),
                        rs.getString("name"),
                        rs.getInt("albumId")
                );

                songs.add(song);
            }

        } catch (SQLException e) {
            System.out.println("Read Archived Songs Error: " + e.getMessage());
        }

        return songs;
    }
}