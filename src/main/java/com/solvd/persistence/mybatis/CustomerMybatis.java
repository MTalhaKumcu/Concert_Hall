package com.solvd.persistence.mybatis;

import com.solvd.model.Customer;
import com.solvd.persistence.connection.MyBatisConnection;
import com.solvd.persistence.dao.CustomerDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CustomerMybatis implements CustomerDAO {
    @Override
    public  Customer getCustomerByID(int customerID) {
       try (SqlSession  session = MyBatisConnection.getSqlSessionFactory().openSession()){
           return session.selectOne("com.solvd.persistence.dao.CustomerDAO.getCustomerByID",customerID);
       }
    }

    @Override
    public List<Customer> getAllCustomers() {
        try (SqlSession  session = MyBatisConnection.getSqlSessionFactory().openSession()){
            return session.selectList("com.solvd.persistence.dao.CustomerDAO.getAllCustomers");
        }
    }

    @Override
    public void addCustomers(Customer customer) {
        try (SqlSession  session = MyBatisConnection.getSqlSessionFactory().openSession()){
            session.insert("com.solvd.persistence.dao.CustomerDAO.addCustomers",customer);
            session.commit();
        }
    }

    @Override
    public void updateCustomers(Customer customer) {
        try (SqlSession  session = MyBatisConnection.getSqlSessionFactory().openSession()){
            session.update("com.solvd.persistence.dao.CustomerDAO.updateCustomers",customer);
            session.commit();
        }
    }

    @Override
    public void deleteCustomers(int customerID) {
        try (SqlSession  session = MyBatisConnection.getSqlSessionFactory().openSession()){
            session.delete("com.solvd.persistence.dao.CustomerDAO.deleteCustomers",customerID);
            session.commit();
        }
    }
}
