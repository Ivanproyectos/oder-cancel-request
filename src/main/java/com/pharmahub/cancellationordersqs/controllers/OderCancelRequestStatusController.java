package com.pharmahub.cancellationordersqs.controllers;

import com.pharmahub.cancellationordersqs.contracts.dtos.OderCancelRequestStatusDto;
import com.pharmahub.cancellationordersqs.services.OderCancelRequestStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/order-cancel-status")
public class OderCancelRequestStatusController {

    @Autowired
    private OderCancelRequestStatusService oderCancelRequestStatusService;
    @GetMapping()
    public List<OderCancelRequestStatusDto> getAll(){
      return  oderCancelRequestStatusService.getAll();
    }
}
