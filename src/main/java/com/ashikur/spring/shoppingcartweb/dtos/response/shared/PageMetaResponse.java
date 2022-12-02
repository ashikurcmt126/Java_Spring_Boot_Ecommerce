package com.ashikur.spring.shoppingcartweb.dtos.response.shared;

import com.ashikur.spring.shoppingcartweb.dtos.response.base.SuccessResponse;

public class PageMetaResponse extends SuccessResponse {
    private final PageMeta pageMeta;

    public PageMetaResponse(PageMeta pageMeta) {
        this.pageMeta = pageMeta;
    }

    public PageMeta getPageMeta() {
        return pageMeta;
    }
}
