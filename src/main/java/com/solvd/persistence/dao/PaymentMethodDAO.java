package com.solvd.persistence.dao;

import com.solvd.model.PaymentsMethod;

import java.util.List;

public interface PaymentMethodDAO {

    PaymentsMethod getPaymentsMethodsByID(int paymentsMethodID);

    List<PaymentsMethod> getAllPaymentMethods();

    void addPaymentMethod(PaymentsMethod paymentsMethod);

    void updatePaymentMethod(PaymentsMethod paymentsMethod);

    void deletePaymentMethod(int paymentMethodID);
}
