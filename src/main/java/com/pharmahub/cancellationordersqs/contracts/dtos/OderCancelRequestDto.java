package com.pharmahub.cancellationordersqs.contracts.dtos;

import com.pharmahub.cancellationordersqs.entities.OderCancelRequestStatus;
import jakarta.persistence.Column;
import lombok.Data;
import org.apache.poi.hpsf.Decimal;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OderCancelRequestDto {
    private Long id;
    private String Center;
    private Long sapOrderCode;
    private int Client;
    private String companyName;
    private Long pmmOrderCode;
    private Date orderDateSAP;
    private String createdByUser;
    private Date createdDate;
    private String modifiedByUser;
    private Date modifiedDate;
    private Long transferNumber;
    private int units;
    private int skuQuantity;
    private BigDecimal orderAmount;
    private String orderType;
    private int generalStatusCancelId;
    private String motiveNoCancel;

    private OderCancelRequestStatusDto oderCancelRequestStatus;
}
