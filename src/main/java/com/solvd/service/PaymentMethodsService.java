package com.solvd.service;

import com.solvd.model.PaymentsMethods;
import com.solvd.persistence.dao.PaymentMethodsDAO;

import java.util.List;

public class PaymentMethodsService {

    private final PaymentMethodsDAO paymentMethodsDAO;

    public PaymentMethodsService(PaymentMethodsDAO paymentMethodsDAO) {
        this.paymentMethodsDAO = paymentMethodsDAO;
    }

    public PaymentsMethods getPaymentsMethodsByID(int paymentsMethodID) {
        return paymentMethodsDAO.getPaymentsMethodsByID(paymentsMethodID);
    }

    public List<PaymentsMethods> getAllPaymentMethods() {
        return paymentMethodsDAO.getAllPaymentMethods();
    }

    public void addPaymentMethod(PaymentsMethods paymentsMethods) {
        paymentMethodsDAO.addPaymentMethod(paymentsMethods);
    }

    public void updatePaymentMethod(PaymentsMethods paymentsMethods) {
        paymentMethodsDAO.updatePaymentMethod(paymentsMethods);
    }

    public void deletePaymentMethod(int paymentMethodID) {
        paymentMethodsDAO.deletePaymentMethod(paymentMethodID);
    }
}
