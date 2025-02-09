package com.ganga.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.ganga.dto.OrdersDTO;
import com.ganga.models.Orders;

@Mapper
public interface OrdersMapper {
    OrdersMapper INSTANCE = Mappers.getMapper(OrdersMapper.class);

    OrdersDTO orderToOrderDTO(Orders order);

    @Mapping(target = "orderId", ignore = true)
    @Mapping(target = "customerId", ignore = true)
    Orders orderDTOtoOrder(OrdersDTO dto);

    List<OrdersDTO> orderToOrderDTOList(List<Orders> orders);
    List<Orders> orderDTOtoOrdersList(List<OrdersDTO> dtos);
}
