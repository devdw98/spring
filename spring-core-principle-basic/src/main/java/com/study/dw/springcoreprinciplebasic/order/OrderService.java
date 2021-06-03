package com.study.dw.springcoreprinciplebasic.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
