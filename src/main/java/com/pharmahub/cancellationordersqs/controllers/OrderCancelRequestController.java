package com.pharmahub.cancellationordersqs.controllers;

import com.pharmahub.cancellationordersqs.contracts.dtos.OderCancelRequestDto;
import com.pharmahub.cancellationordersqs.contracts.dtos.PagedResultDto;
import com.pharmahub.cancellationordersqs.contracts.requests.CreateOderCancelRequest;
import com.pharmahub.cancellationordersqs.contracts.requests.OrderCancelFilterRequest;
import com.pharmahub.cancellationordersqs.contracts.requests.PagedRequests;
import com.pharmahub.cancellationordersqs.entities.OderCancelRequest;
import com.pharmahub.cancellationordersqs.services.ExportOderCancelRequestService;
import com.pharmahub.cancellationordersqs.services.OderCancelRequestService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Source;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/order-cancel-request")
public class OrderCancelRequestController {
    @Autowired
    private OderCancelRequestService oderCancelRequestService;
    @Autowired
    private ExportOderCancelRequestService exportOderCancelRequestService;

    @GetMapping("ping")
    public String Ping(){
        return "Pong";
    }
    @GetMapping
    public List<OderCancelRequest> getOderCancelRequests() {
        return oderCancelRequestService.getOderCancelRequests();
    }
    @PostMapping("paged")
    public PagedResultDto<OderCancelRequestDto> getOderCancelRequestsPaged(
            @RequestBody PagedRequests<OrderCancelFilterRequest> request
    ) {
        return oderCancelRequestService.getOderCancelRequestsPaged(request);
    }
    @PostMapping()
    public OderCancelRequest createOderCancelRequest(
           @Valid @RequestBody CreateOderCancelRequest request
    ) {
        /*return oderCancelRequestService.createOderCancelRequest(request);*/
        return null;
    }
    @GetMapping("export")
    public ResponseEntity<ByteArrayResource> exportOderCancelRequest(@ModelAttribute OrderCancelFilterRequest request) throws IOException {
        var byteArrayResource = exportOderCancelRequestService.exportOderCancelRequest(request);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=producto_relleno.xlsx")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(byteArrayResource);
    }
}
