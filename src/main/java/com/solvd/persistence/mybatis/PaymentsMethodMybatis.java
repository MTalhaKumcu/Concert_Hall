package com.solvd.persistence.mybatis;

import com.solvd.model.PaymentsMethod;
import com.solvd.persistence.connection.MyBatisConnection;
import com.solvd.persistence.dao.PaymentMethodDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PaymentsMethodMybatis implements PaymentMethodDAO {
    @Override
    public PaymentsMethod getPaymentsMethodsByID(int paymentsMethodID) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            return session.selectOne("com.solvd.persistence.dao.PaymentMethodDAO.getPaymentMethodById", paymentsMethodID);
        }    }

    @Override
    public List<PaymentsMethod> getAllPaymentMethods() {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            return session.selectList("com.solvd.persistence.dao.PaymentMethodDAO.getAllPaymentMethods");
        }
    }

    @Override
    public void addPaymentMethod(PaymentsMethod paymentMethod) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.insert("com.solvd.persistence.dao.PaymentMethodDAO.addPaymentMethod", paymentMethod);
            session.commit();
        }
    }

    @Override
    public void updatePaymentMethod(PaymentsMethod paymentMethod) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.update("com.solvd.persistence.dao.PaymentMethodDAO.updatePaymentMethod", paymentMethod);
            session.commit();
        }
    }

    @Override
    public void deletePaymentMethod(int paymentMethodID) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.delete("com.solvd.persistence.dao.PaymentMethodDAO.deletePaymentMethod", paymentMethodID);
            session.commit();
        }
    }
}
