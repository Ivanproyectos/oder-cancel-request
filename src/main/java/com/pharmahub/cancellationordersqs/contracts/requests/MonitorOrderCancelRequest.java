package com.pharmahub.cancellationordersqs.contracts.requests;

import lombok.Data;

@Data
public class MonitorOrderCancelRequest {

    private Long nsaporder;
    private Long npmmorder;

}
