package com.stack.accounts.mapper;

import com.stack.accounts.dto.CustomerDTO;
import com.stack.accounts.entity.Customer;

public class CustomerMapper {

    public static Customer mapToCustomerEntity(CustomerDTO dto, Customer customer) {
//        customer.setCustomerId(dto.getCustomerId());
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setMobileNumber(dto.getMobileNumber());
        return customer;
    }

    public static CustomerDTO mapToCustomerDto(Customer entity, CustomerDTO dto) {
//        dto.setCustomerId(entity.getCustomerId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setMobileNumber(entity.getMobileNumber());
        return dto;
    }
}
