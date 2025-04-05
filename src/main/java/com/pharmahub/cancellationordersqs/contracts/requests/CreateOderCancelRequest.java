package com.pharmahub.cancellationordersqs.contracts.requests;

import lombok.Data;

import java.util.Date;
@Data
public class CreateOderCancelRequest {
    private String Center;
    private Long sapOrderCode;
    private int Client;
    private String companyName;
    private Long pmmOrderCode;
    private Date orderDateSAP;
    private String createdByUser;
}
