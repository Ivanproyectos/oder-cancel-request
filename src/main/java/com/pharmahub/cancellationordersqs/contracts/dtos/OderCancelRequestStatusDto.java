package com.pharmahub.cancellationordersqs.contracts.dtos;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;

@Data
public class OderCancelRequestStatusDto {
    private Long id;
    private String shortDescription;
    private String description;
    private String createdByUser;
    private Date createdDate;
    private String modifiedByUser;
    private Date modifiedDate;
}
