package com.amos.think.domain.customer.gateway;

import com.amos.think.domain.customer.Customer;

public interface CustomerGateway {
    public Customer getByById(String customerId);
}
