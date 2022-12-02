package com.ashikur.spring.shoppingcartweb.dtos.response.orders;

import com.ashikur.spring.shoppingcartweb.dtos.response.shared.PageMeta;
import com.ashikur.spring.shoppingcartweb.models.Order;
import com.ashikur.spring.shoppingcartweb.dtos.response.base.SuccessResponse;
import com.ashikur.spring.shoppingcartweb.dtos.response.orders.partials.OrderSummaryDto;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.Collection;

public class OrderListResponse extends SuccessResponse {

    private final PageMeta pageMeta;
    private final Collection<OrderSummaryDto> orders;


    public OrderListResponse(PageMeta pageMeta, Collection<OrderSummaryDto> orderSummaryDtos) {
        this.pageMeta = pageMeta;
        this.orders = orderSummaryDtos;
    }

    public static OrderListResponse build(Page<Order> ordersPage, String basePath) {
        Collection<OrderSummaryDto> orderSummaryDtos = new ArrayList<>();

        for (Order order : ordersPage.getContent())
            orderSummaryDtos.add(OrderSummaryDto.build(order));

        return new OrderListResponse(
                PageMeta.build(ordersPage, basePath),
                orderSummaryDtos
        );
    }

    public PageMeta getPageMeta() {
        return pageMeta;
    }

    public Collection<OrderSummaryDto> getOrders() {
        return orders;
    }
}
