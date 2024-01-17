package com.solvd.persistence.mybatis;

import com.solvd.model.Genre;
import com.solvd.persistence.connection.MyBatisConnection;
import com.solvd.persistence.dao.GenreDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GenreMybatis implements GenreDAO {
    @Override
    public Genre getGenreByID(int genreID) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()){
            return session.selectOne("com.solvd.persistence.dao.GenreDAO.getGenreById", genreID);
        }
    }

    @Override
    public List<Genre> getAllGenres() {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            return session.selectList("com.solvd.persistence.dao.GenreDAO.getAllGenres");
        }
    }

    @Override
    public void addGenre(Genre genre) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.insert("com.solvd.persistence.dao.GenreDAO.addGenre", genre);
            session.commit();
        }
    }

    @Override
    public void updateGenre(Genre genre) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.update("com.solvd.persistence.dao.GenreDAO.updateGenre", genre);
            session.commit();
        }
    }

    @Override
    public void deleteGenre(int genreID) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.delete("com.solvd.persistence.dao.GenreDAO.deleteGenre", genreID);
            session.commit();
        }
    }
}
