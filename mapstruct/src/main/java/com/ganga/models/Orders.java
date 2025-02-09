package com.ganga.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    private Integer orderId;
    private Integer customerId;
    private String totalCost;
    private String orderStatus;
}
