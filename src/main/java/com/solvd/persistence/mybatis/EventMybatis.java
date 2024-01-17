package com.solvd.persistence.mybatis;

import com.solvd.model.Event;
import com.solvd.persistence.connection.MyBatisConnection;
import com.solvd.persistence.dao.EventDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EventMybatis implements EventDAO {
    @Override
    public Event getEventByID(int eventID) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            return session.selectOne("com.solvd.persistence.dao.EventDAO.getEventById", eventID);
        }
    }

    @Override
    public List<Event> getAllEvents() {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            return session.selectList("com.solvd.persistence.dao.EventDAO.getAllEvents");
        }
    }

    @Override
    public void addEvent(Event event) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.insert("com.solvd.persistence.dao.EventDAO.addEvent", event);
            session.commit();
        }
    }

    @Override
    public void updateEvent(Event event) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.insert("com.solvd.persistence.dao.EventDAO.addEvent", event);
            session.commit();
        }
    }

    @Override
    public void deleteEvent(int eventID) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.delete("com.solvd.persistence.dao.EventDAO.deleteEvent", eventID);
            session.commit();
        }
    }
}
