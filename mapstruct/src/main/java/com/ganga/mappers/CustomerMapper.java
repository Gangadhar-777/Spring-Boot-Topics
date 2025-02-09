package com.ganga.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.ganga.dto.CustomerDTO;
import com.ganga.models.Customer;

@Mapper(uses = OrdersMapper.class)
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "orders", ignore = true)
    CustomerDTO customerToCustomerDTO(Customer customer);

    @Mapping(target = "customerId", ignore = true)
    Customer customerDTOtoCustomer(CustomerDTO dto);
}
