package com.solvd.persistence.mybatis;

import com.solvd.model.Venue;
import com.solvd.persistence.connection.MyBatisConnection;
import com.solvd.persistence.dao.VenueDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class VenueMybatis implements VenueDAO {
    @Override
    public Venue getVenuesByID(int venueID) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            return session.selectOne("com.solvd.persistence.dao.VenueDAO.getVenueById", venueID);
        }
    }

    @Override
    public List<Venue> getAllVenues() {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            return session.selectList("com.solvd.persistence.dao.VenueDAO.getAllVenues");
        }
    }

    @Override
    public void addVenues(Venue venue) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.insert("com.solvd.persistence.dao.VenueDAO.addVenue", venue);
            session.commit();
        }
    }

    @Override
    public void updateVenues(Venue venue) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.update("com.solvd.persistence.dao.VenueDAO.updateVenue", venue);
            session.commit();
        }
    }

    @Override
    public void deleteVenues(int venueID) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.delete("com.solvd.persistence.dao.VenueDAO.deleteVenue", venueID);
            session.commit();
        }
    }
}
