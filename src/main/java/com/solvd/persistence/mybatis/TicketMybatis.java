package com.solvd.persistence.mybatis;

import com.solvd.model.Ticket;
import com.solvd.persistence.connection.MyBatisConnection;
import com.solvd.persistence.dao.TicketDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TicketMybatis implements TicketDAO {
    @Override
    public Ticket getTicketByID(int ticketID) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            return session.selectOne("com.solvd.persistence.dao.TicketDAO.getTicketById", ticketID);
        }
    }

    @Override
    public List<Ticket> getAllTicket() {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            return session.selectList("com.solvd.persistence.dao.TicketDAO.getAllTickets");
        }
    }

    @Override
    public void addTicket(Ticket ticket) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.insert("com.solvd.persistence.dao.TicketDAO.addTicket", ticket);
            session.commit();
        }
    }

    @Override
    public void updateTicket(Ticket ticket) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.update("com.solvd.persistence.dao.TicketDAO.updateTicket", ticket);
            session.commit();
        }
    }

    @Override
    public void deleteTicket(int ticketID) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.delete("com.solvd.persistence.dao.TicketDAO.deleteTicket", ticketID);
            session.commit();
        }
    }
}
