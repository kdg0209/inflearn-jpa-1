package com.example.inflearnjpa1.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderSearch {

    private String memberName;
    private OrderStatus orderStatus;
}
