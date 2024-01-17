package com.solvd.service.MybatisService;

import com.solvd.model.PaymentsMethod;
import com.solvd.persistence.dao.PaymentMethodDAO;

import java.util.List;

public class PaymentMethodService {

    private final PaymentMethodDAO paymentMethodDAO;

    public PaymentMethodService(PaymentMethodDAO paymentMethodDAO) {
        this.paymentMethodDAO = paymentMethodDAO;
    }

    public PaymentsMethod getPaymentsMethodsByID(int paymentsMethodID) {
        return paymentMethodDAO.getPaymentsMethodsByID(paymentsMethodID);
    }

    public List<PaymentsMethod> getAllPaymentMethods() {
        return paymentMethodDAO.getAllPaymentMethods();
    }

    public void addPaymentMethod(PaymentsMethod paymentsMethod) {
        paymentMethodDAO.addPaymentMethod(paymentsMethod);
    }

    public void updatePaymentMethod(PaymentsMethod paymentsMethod) {
        paymentMethodDAO.updatePaymentMethod(paymentsMethod);
    }

    public void deletePaymentMethod(int paymentMethodID) {
        paymentMethodDAO.deletePaymentMethod(paymentMethodID);
    }
}
