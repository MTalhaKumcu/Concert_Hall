package com.solvd.persistence.mybatis;

import com.solvd.model.Role;
import com.solvd.persistence.connection.MyBatisConnection;
import com.solvd.persistence.dao.RoleDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RoleMybatis implements RoleDAO {
    @Override
    public Role getRoleByID(int roleID) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            return session.selectOne("com.solvd.persistence.dao.RoleDAO.getRoleById", roleID);
        }
    }

    @Override
    public List<Role> getAllRoles() {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            return session.selectList("com.solvd.persistence.dao.RoleDAO.getAllRoles");
        }
    }

    @Override
    public void addRole(Role role) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.insert("com.solvd.persistence.dao.RoleDAO.addRole", role);
            session.commit();
        }
    }

    @Override
    public void updateRole(Role role) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.update("com.solvd.persistence.dao.RoleDAO.updateRole", role);
            session.commit();
        }
    }

    @Override
    public void deleteRole(int roleID) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.delete("com.solvd.persistence.dao.RoleDAO.deleteRole", roleID);
            session.commit();
        }
    }
}
