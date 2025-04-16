package com.pharmahub.cancellationordersqs.entities;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class MonitorOrderCancelRequest {

    public MonitorOrderCancelRequest(){}

    private String nsaporder;

    private String npmmorder;

}
