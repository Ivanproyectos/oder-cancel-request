package com.pharmahub.cancellationordersqs.contracts.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonitorOperationResult {
    private Integer systemcode;
    private String system; // Ej: "SAP", "IR-TRACK", "PMM"
    private boolean success;
    private String message;

}
