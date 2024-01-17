package com.solvd.persistence.mybatis;

import com.solvd.model.StaffRole;
import com.solvd.persistence.connection.MyBatisConnection;
import com.solvd.persistence.dao.StaffRoleDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StaffRoleMybatis implements StaffRoleDAO {
    @Override
    public StaffRole getStaffRoleByID(int staffRoleID) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            return session.selectOne("com.solvd.persistence.dao.StaffRoleDAO.getStaffRoleById", staffRoleID);
        }
    }

    @Override
    public List<StaffRole> getAllStaffRoles() {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            return session.selectList("com.solvd.persistence.dao.StaffRoleDAO.getAllStaffRoles");
        }
    }

    @Override
    public void addStaffRole(StaffRole staffRole) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.insert("com.solvd.persistence.dao.StaffRoleDAO.addStaffRole", staffRole);
            session.commit();
        }
    }

    @Override
    public void updateStaffRole(StaffRole staffRole) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.update("com.solvd.persistence.dao.StaffRoleDAO.updateStaffRole", staffRole);
            session.commit();
        }
    }

    @Override
    public void deleteStaffRole(int staffRoleID) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.delete("com.solvd.persistence.dao.StaffRoleDAO.deleteStaffRole", staffRoleID);
            session.commit();
        }
    }
}
