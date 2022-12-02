package com.ashikur.spring.shoppingcartweb.admin.dtos;

import com.ashikur.spring.shoppingcartweb.dtos.response.products.partials.ProductSummaryDto;

import java.time.ZonedDateTime;

public class AdminProductSummaryDto extends ProductSummaryDto {

    public AdminProductSummaryDto() {
        super();
    }

    private ZonedDateTime createdAt;

    private ZonedDateTime updatedAt;

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
