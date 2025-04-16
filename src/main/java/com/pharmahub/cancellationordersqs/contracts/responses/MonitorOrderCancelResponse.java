package com.pharmahub.cancellationordersqs.contracts.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonitorOrderCancelResponse {
    private String nsaporder;
    private String statusfinal; // "success", "partial_success", "failure"
    private List<MonitorOperationResult> results;
}
