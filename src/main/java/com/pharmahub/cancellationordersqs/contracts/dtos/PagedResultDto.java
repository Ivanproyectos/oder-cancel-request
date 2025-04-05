package com.pharmahub.cancellationordersqs.contracts.dtos;

import lombok.Data;

import java.util.List;
@Data
public class PagedResultDto<T> {
    private List<T> data;
    private long totalRecords;
    private long totalPages;
    private int pageNumber;
    private int pageSize;
}
