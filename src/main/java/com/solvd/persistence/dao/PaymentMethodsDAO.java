package com.solvd.persistence.dao;

import com.solvd.model.PaymentsMethods;

import java.util.List;

public interface PaymentMethodsDAO {

    PaymentsMethods getPaymentsMethodsByID(int paymentsMethodID);

    List<PaymentsMethods> getAllPaymentMethods();

    void addPaymentMethod(PaymentsMethods paymentsMethods);

    void updatePaymentMethod(PaymentsMethods paymentsMethods);

    void deletePaymentMethod(int paymentMethodID);
}
