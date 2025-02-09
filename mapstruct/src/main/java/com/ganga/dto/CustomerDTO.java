package com.ganga.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private String name;
    private Integer age;
    private List<OrdersDTO> orders;

    public void addOrderDTO(OrdersDTO order) {
        if (this.orders == null) {
            orders = new ArrayList<>();
        }
        orders.add(order);
    }
}
