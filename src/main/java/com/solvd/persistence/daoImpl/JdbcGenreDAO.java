package com.solvd.persistence.daoImpl;

import com.solvd.model.Genres;
import com.solvd.persistence.dao.GenreDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcGenreDAO implements GenreDAO {

    private Connection connection;

    public JdbcGenreDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Genres getGenreByID(int genreID) {
        Genres genre = null;
        String query = "SELECT * FROM Genres WHERE GenreID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, genreID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                genre = mapResultSetToGenre(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return genre;
    }


    @Override
    public List<Genres> getAllGenres() {
        List<Genres> genres = new ArrayList<>();
        String query = "SELECT * FROM Genres";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Genres genre = mapResultSetToGenre(resultSet);
                genres.add(genre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return genres;
    }

    @Override
    public void addGenre(Genres genres) {
        String query = "INSERT INTO Genres (GenreName) VALUES (?)";

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, genres.getGenreName());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Genre creation failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    genres.setGenreID(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Genre creation failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateGenre(Genres genres) {
        String query = "UPDATE Genres SET GenreName = ? WHERE GenreID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, genres.getGenreName());
            statement.setInt(2, genres.getGenreID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteGenre(int genreID) {
        String query = "DELETE FROM Genres WHERE GenreID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, genreID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Genres mapResultSetToGenre(ResultSet resultSet) throws SQLException {
        int genreID = resultSet.getInt("GenreID");
        String genreName = resultSet.getString("GenreName");

        return new Genres(genreID, genreName);
    }
}
