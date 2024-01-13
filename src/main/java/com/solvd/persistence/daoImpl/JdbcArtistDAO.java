package com.solvd.persistence.daoImpl;

import com.solvd.model.Artist;
import com.solvd.model.Genre;
import com.solvd.persistence.connection.ConnectionPool;
import com.solvd.persistence.dao.ArtistDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcArtistDAO implements ArtistDAO {

    private final ConnectionPool connectionPool;


    public JdbcArtistDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Artist getArtistsByID(int artistID) {
        Artist artist = null;
        String query = "SELECT * FROM Artists WHERE ArtistID = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, artistID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                artist = mapResultSetToArtist(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return artist;
    }


    @Override
    public List<Artist> getAllArtists() {
        List<Artist> artists = new ArrayList<>();
        String query = "SELECT * FROM Artists";

        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Artist artist = mapResultSetToArtist(resultSet);
                artists.add(artist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return artists;
    }


    @Override
    public void addArtist(Artist artist) {
        String query = "INSERT INTO Artists (ArtistName ,ArtistSurname ,BirthDate, Country) VALUES (?, ?, ?, ?)";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, artist.getArtistName());
            statement.setString(2, artist.getArtistSurame());
            statement.setDate(3, new java.sql.Date(artist.getBirthDate().getTime()));
            statement.setString(4, artist.getCountry());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Artist creation failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    artist.setArtistID(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Artist creation failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateArtist(Artist artists) {
        String query = "UPDATE Artists SET ArtistName = ?, ArtistSurname = ?, BirthDate = ?, Country = ? WHERE ArtistID = ?";

        try (
                Connection connection = connectionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            Artist artist;
            statement.setString(1, artists.getArtistName());
            statement.setString(2, artists.getArtistName());
            statement.setDate(3, new Date(artists.getBirthDate().getTime()));
            statement.setString(4, artists.getCountry());
            statement.setInt(5, artists.getArtistID());


            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteArtist(int artistID) {
        String query = "DELETE FROM Artists WHERE ArtistID = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, artistID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Artist mapResultSetToArtist(ResultSet resultSet) throws SQLException {
        int artistID = resultSet.getInt("ArtistID");
        String artistName = resultSet.getString("ArtistName");
        String artistSurname = resultSet.getString("ArtistSurame");
        Date birthDate = resultSet.getDate("BirthDate");
        String country = resultSet.getString("Country");

        return new Artist(artistID, artistName, artistSurname, birthDate, country);
    }
}
