package com.pharmahub.cancellationordersqs.contracts.requests;

import lombok.Data;

import java.util.Date;

@Data
public class OrderCancelFilterRequest {
    private String client;
    private Integer requestStatus;
    private Date createdDate;
}
