package com.pharmahub.cancellationordersqs.contracts.requests;

import lombok.Data;

@Data
public class PagedRequests<T> {
    private int page;
    private int size;
    private T filter;
}
