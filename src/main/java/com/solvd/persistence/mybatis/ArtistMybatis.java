package com.solvd.persistence.mybatis;

import com.solvd.model.Artist;
import com.solvd.persistence.connection.MyBatisConnection;
import com.solvd.persistence.dao.ArtistDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ArtistMybatis implements ArtistDAO {
    @Override
    public Artist getArtistsByID(int artistID) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            return session.selectOne("com.solvd.persistence.dao.ArtistDAO.getArtistsByID", artistID);
        }

    }

    @Override
    public List<Artist> getAllArtists() {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            return session.selectList("com.solvd.persistence.dao.ArtistDAO.getAllArtists");
        }

    }

    @Override
    public void addArtist(Artist artist) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.insert("com.solvd.persistence.dao.ArtistDAO.addArtist", artist);
            session.commit();
        }
    }

    @Override
    public void updateArtist(Artist artist) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.update("com.solvd.persistence.dao.ArtistDAO.updateArtist", artist);
            session.commit();
        }
    }

    @Override
    public void deleteArtist(int artistID) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.delete("com.solvd.persistence.dao.ArtistDAO.deleteArtist", artistID);
            session.commit();
        }
    }
}
