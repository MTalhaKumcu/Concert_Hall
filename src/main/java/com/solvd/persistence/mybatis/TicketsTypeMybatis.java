package com.solvd.persistence.mybatis;

import com.solvd.model.TicketsType;
import com.solvd.persistence.connection.MyBatisConnection;
import com.solvd.persistence.dao.TicketTypeDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TicketsTypeMybatis implements TicketTypeDAO {
    @Override
    public TicketsType getTicketTypeByID(int ticketTypeID) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            return session.selectOne("com.solvd.persistence.dao.TicketTypeDAO.getTicketTypeById", ticketTypeID);
        }
    }

    @Override
    public List<TicketsType> getAllTicketType() {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            return session.selectList("com.solvd.persistence.dao.TicketTypeDAO.getAllTicketTypes");
        }
    }

    @Override
    public void addTicketType(TicketsType ticketType) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.insert("com.solvd.persistence.dao.TicketTypeDAO.addTicketType", ticketType);
            session.commit();
        }
    }

    @Override
    public void updateTicketType(TicketsType ticketType) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.update("com.solvd.persistence.dao.TicketTypeDAO.updateTicketType", ticketType);
            session.commit();
        }
    }

    @Override
    public void deleteTicketType(int ticketTypeID) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.delete("com.solvd.persistence.dao.TicketTypeDAO.deleteTicketType", ticketTypeID);
            session.commit();
        }
    }
}
