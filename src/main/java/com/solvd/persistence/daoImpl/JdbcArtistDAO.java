package com.solvd.persistence.daoImpl;

import com.solvd.model.Artists;
import com.solvd.persistence.dao.ArtistsDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcArtistDAO implements ArtistsDAO {

    private Connection connection;

    public JdbcArtistDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Artists getArtistsByID(int artistID) {
        Artists artist = null;
        String query = "SELECT * FROM Artists WHERE ArtistID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
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
    public List<Artists> getAllArtists() {
        List<Artists> artists = new ArrayList<>();
        String query = "SELECT * FROM Artists";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Artists artist = mapResultSetToArtist(resultSet);
                artists.add(artist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return artists;
    }


    @Override
    public void addArtist(Artists artists) {
        String query = "INSERT INTO Artists (ArtistName, BirthDate, Country) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, artists.getArtistName());
            statement.setDate(2, new java.sql.Date(artists.getBirthDate().getTime()));
            statement.setString(3, artists.getCountry());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Artist creation failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    artists.setArtistID(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Artist creation failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateArtist(Artists artists) {
        String query = "UPDATE Artists SET ArtistName = ?, BirthDate = ?, Country = ? WHERE ArtistID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            Artists artist;
            statement.setString(1, artists.getArtistName());
            statement.setDate(2, new Date(artists.getBirthDate().getTime()));
            statement.setString(3, artists.getCountry());
            statement.setInt(4, artists.getArtistID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteArtist(int artistID) {
        String query = "DELETE FROM Artists WHERE ArtistID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, artistID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Artists mapResultSetToArtist(ResultSet resultSet) throws SQLException {
        int artistID = resultSet.getInt("ArtistID");
        String artistName = resultSet.getString("ArtistName");
        String artistSurname = resultSet.getString("ArtistSurame");
        Date birthDate = resultSet.getDate("BirthDate");
        String country = resultSet.getString("Country");
        int genreID = resultSet.getInt("GenreID");

        return new Artists(artistID, artistName, artistSurname, birthDate, country, genreID);
    }
}
