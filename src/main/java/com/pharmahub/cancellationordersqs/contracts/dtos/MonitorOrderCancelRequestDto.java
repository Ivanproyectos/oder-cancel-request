package com.pharmahub.cancellationordersqs.contracts.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonitorOrderCancelRequestDto {

    private String nsaporder;
    private String npmmorder;

}
