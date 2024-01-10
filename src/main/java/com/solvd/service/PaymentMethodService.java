package com.solvd.service;

import com.solvd.model.PaymentsMethods;
import com.solvd.persistence.dao.PaymentMethodDAO;

import java.util.List;

public class PaymentMethodService {

    private final PaymentMethodDAO paymentMethodDAO;

    public PaymentMethodService(PaymentMethodDAO paymentMethodDAO) {
        this.paymentMethodDAO = paymentMethodDAO;
    }

    public PaymentsMethods getPaymentsMethodsByID(int paymentsMethodID) {
        return paymentMethodDAO.getPaymentsMethodsByID(paymentsMethodID);
    }

    public List<PaymentsMethods> getAllPaymentMethods() {
        return paymentMethodDAO.getAllPaymentMethods();
    }

    public void addPaymentMethod(PaymentsMethods paymentsMethods) {
        paymentMethodDAO.addPaymentMethod(paymentsMethods);
    }

    public void updatePaymentMethod(PaymentsMethods paymentsMethods) {
        paymentMethodDAO.updatePaymentMethod(paymentsMethods);
    }

    public void deletePaymentMethod(int paymentMethodID) {
        paymentMethodDAO.deletePaymentMethod(paymentMethodID);
    }
}
