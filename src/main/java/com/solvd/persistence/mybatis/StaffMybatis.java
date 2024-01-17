package com.solvd.persistence.mybatis;

import com.solvd.model.Staff;
import com.solvd.persistence.connection.MyBatisConnection;
import com.solvd.persistence.dao.StaffDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StaffMybatis implements StaffDAO {
    @Override
    public Staff getStaffByID(int StaffID) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            return session.selectOne("com.solvd.persistence.dao.StaffDAO.getStaffById", StaffID);
        }
    }

    @Override
    public List<Staff> getAllStaffs() {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            return session.selectList("com.solvd.persistence.dao.StaffDAO.getAllStaff");
        }
    }

    @Override
    public void addStaff(Staff staff) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.insert("com.solvd.persistence.dao.StaffDAO.addStaff", staff);
            session.commit();
        }
    }

    @Override
    public void updateStaff(Staff staff) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.update("com.solvd.persistence.dao.StaffDAO.updateStaff", staff);
            session.commit();
        }
    }

    @Override
    public void deleteStaff(int StaffID) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.delete("com.solvd.persistence.dao.StaffDAO.deleteStaff", StaffID);
            session.commit();
        }
    }
}
