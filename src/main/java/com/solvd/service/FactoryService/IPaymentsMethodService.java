package com.solvd.service.FactoryService;

import com.solvd.model.PaymentsMethod;

public interface IPaymentsMethodService {
    PaymentsMethod createPaymentsMethod(PaymentsMethod PpymentsMethod);

    PaymentsMethod getPaymentsMethodByID(int paymentsMethodID);
}
