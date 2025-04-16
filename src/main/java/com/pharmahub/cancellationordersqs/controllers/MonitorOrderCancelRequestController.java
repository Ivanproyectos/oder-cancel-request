package com.pharmahub.cancellationordersqs.controllers;

import com.pharmahub.cancellationordersqs.contracts.responses.MonitorOperationResult;
import com.pharmahub.cancellationordersqs.contracts.responses.MonitorOrderCancelResponse;
import com.pharmahub.cancellationordersqs.entities.MonitorOrderCancelRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/monitor/")
public class MonitorOrderCancelRequestController {

    @PostMapping("/order/cancel")
    public ResponseEntity<MonitorOrderCancelResponse> orderCancel(
            @Valid @RequestBody MonitorOrderCancelRequest request
    ) {
        String nsaporder = String.valueOf(request.getNsaporder());

        if ("123456".equals(nsaporder)) {
            MonitorOrderCancelResponse response = new MonitorOrderCancelResponse(
                    nsaporder,
                    "success",
                    Arrays.asList(
                            new MonitorOperationResult(1, "SAP", true, "Pedido anulado correctamente en SAP."),
                            new MonitorOperationResult(2, "IRTrack", true, "Anulación exitosa en IRTrack."),
                            new MonitorOperationResult(3, "PMM", true, "Stored procedure ejecutado correctamente."),
                            new MonitorOperationResult(4, "OTM", true, "Orden anulada en OTM.")
                    )
            );
            return ResponseEntity.ok(response);
        }

        if ("1234567".equals(nsaporder)) {
            MonitorOrderCancelResponse response = new MonitorOrderCancelResponse(
                    nsaporder,
                    "partial_success",
                    Arrays.asList(
                            new MonitorOperationResult(1, "SAP", true, "Pedido anulado correctamente en SAP."),
                            new MonitorOperationResult(2, "IRTrack", false, "Error de conexión con IRTrack."),
                            new MonitorOperationResult(3, "PMM", true, "Stored procedure ejecutado correctamente."),
                            new MonitorOperationResult(4, "OTM", false, "OTM rechazó la anulación por inconsistencias.")
                    )
            );
            return ResponseEntity.ok(response);
        }

        if ("1234568".equals(nsaporder)) {
            MonitorOrderCancelResponse response = new MonitorOrderCancelResponse(
                    nsaporder,
                    "failure",
                    Arrays.asList(
                            new MonitorOperationResult(1, "SAP", false, "Pedido no fue anulado en SAP."),
                            new MonitorOperationResult(2, "IRTrack", false, "Error de conexión con IRTrack."),
                            new MonitorOperationResult(3, "PMM", false, "Stored procedure con errores."),
                            new MonitorOperationResult(4, "OTM", false, "OTM rechazó la anulación por inconsistencias.")
                    )
            );
            return ResponseEntity.ok(response);
        }

        // Por defecto, responder con 400 si el pedido no es reconocido
        MonitorOrderCancelResponse errorResponse = new MonitorOrderCancelResponse(
                nsaporder,
                "failure",
                Arrays.asList(
                        new MonitorOperationResult(1, "SAP", false, "Pedido no fue anulado en SAP."),
                        new MonitorOperationResult(2, "IRTrack", false, "Error de conexión con IRTrack."),
                        new MonitorOperationResult(3, "PMM", false, "Stored procedure con errores."),
                        new MonitorOperationResult(4, "OTM", false, "OTM rechazó la anulación por inconsistencias.")
                )
        );
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @PostMapping("/order/reprocess")
    public ResponseEntity<MonitorOrderCancelResponse> orderCancelreprocess(
            @Valid @RequestBody MonitorOrderCancelRequest request
    ) {
        String nsaporder = String.valueOf(request.getNsaporder());

        if ("1234567".equals(nsaporder)) {
            MonitorOrderCancelResponse response = new MonitorOrderCancelResponse(
                    nsaporder,
                    "success",
                    Arrays.asList(
                            new MonitorOperationResult(1, "SAP", true, "Ya había sido anulado correctamente en SAP."),
                            new MonitorOperationResult(2, "IRTrack", true, "Reproceso exitoso en IRTrack."),
                            new MonitorOperationResult(3, "PMM", true, "Ya ejecutado correctamente en PMM."),
                            new MonitorOperationResult(4, "OTM", true, "Reproceso exitoso en OTM.")
                    )
            );
            return ResponseEntity.ok(response);
        }

        // Si no coincide con pedido esperado para reproceso, retorno 400
        MonitorOrderCancelResponse errorResponse = new MonitorOrderCancelResponse(
                nsaporder,
                "reprocess_failed",
                Arrays.asList(
                        new MonitorOperationResult(1, "SAP", true, "Ya había sido anulado correctamente en SAP."),
                        new MonitorOperationResult(2, "IRTrack", true, "Reproceso exitoso en IRTrack."),
                        new MonitorOperationResult(3, "PMM", true, "Ya ejecutado correctamente en PMM."),
                        new MonitorOperationResult(4, "OTM", false, "Segundo intento fallido en OTM.")
                )
        );
        return ResponseEntity.ok(errorResponse);
    }
}
