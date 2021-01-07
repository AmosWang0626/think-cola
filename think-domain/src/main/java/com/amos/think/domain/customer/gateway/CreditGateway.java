package com.amos.think.domain.customer.gateway;

import com.amos.think.domain.customer.Customer;
import com.amos.think.domain.customer.Credit;

//Assume that the credit info is in antoher distributed Service
public interface CreditGateway {
    public Credit getCredit(String customerId);
}
