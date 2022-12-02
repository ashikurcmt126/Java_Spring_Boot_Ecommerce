package com.ashikur.spring.shoppingcartweb.dtos.response.orders;

import com.ashikur.spring.shoppingcartweb.dtos.response.orders.partials.OrderAddressInfoDto;
import com.ashikur.spring.shoppingcartweb.dtos.response.orders.partials.OrderItemDto;
import com.ashikur.spring.shoppingcartweb.enums.OrderStatus;
import com.ashikur.spring.shoppingcartweb.models.Order;
import com.ashikur.spring.shoppingcartweb.models.OrderItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ashikur.spring.shoppingcartweb.dtos.response.base.SuccessResponse;

import java.util.ArrayList;
import java.util.Collection;

public class OrderSingleResponse extends SuccessResponse {

    private final String orderStatus;
    private final String trackingNumber;
    private Collection<OrderItemDto> orderItems;
    @JsonProperty("address")
    private OrderAddressInfoDto orderAddressInfoDto;

    public OrderSingleResponse(String trackingNumber, OrderStatus orderStatus, Collection<OrderItemDto> orderItems, OrderAddressInfoDto orderAddressInfoDto) {
        this.trackingNumber = trackingNumber;
        this.orderStatus = orderStatus != null ? orderStatus.toString() : OrderStatus.PROCESSED.name();
        this.orderItems = orderItems;
        this.orderAddressInfoDto = orderAddressInfoDto;
    }

    public static OrderSingleResponse build(Order order) {
        Collection<OrderItemDto> orderItemDtos = new ArrayList<>();
        for (OrderItem orderItem : order.getOrderItems())
            orderItemDtos.add(OrderItemDto.build(orderItem));

        return new OrderSingleResponse(
                order.getTrackingNumber(),
                order.getOrderStatus(),
                orderItemDtos,
                OrderAddressInfoDto.build(order.getAddress())
        );
    }

    public Collection<OrderItemDto> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Collection<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }

    public OrderAddressInfoDto getOrderAddressInfoDto() {
        return orderAddressInfoDto;
    }

    public void setOrderAddressInfoDto(OrderAddressInfoDto orderAddressInfoDto) {
        this.orderAddressInfoDto = orderAddressInfoDto;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }
}
