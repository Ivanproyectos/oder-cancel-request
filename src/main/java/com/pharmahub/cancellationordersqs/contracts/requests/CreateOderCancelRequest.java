package com.pharmahub.cancellationordersqs.contracts.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
@Data
public class CreateOderCancelRequest {
    @NotNull(message = "Center is required")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String Center;
    private Long sapOrderCode;
    private int Client;
    private String companyName;
    private Long pmmOrderCode;
    private Date orderDateSAP;
    private String createdByUser;
}
