package com.pharmahub.cancellationordersqs.services;

import com.pharmahub.cancellationordersqs.contracts.dtos.OderCancelRequestDto;
import com.pharmahub.cancellationordersqs.contracts.dtos.OderCancelRequestStatusDto;
import com.pharmahub.cancellationordersqs.contracts.dtos.PagedResultDto;
import com.pharmahub.cancellationordersqs.contracts.requests.OrderCancelFilterRequest;
import com.pharmahub.cancellationordersqs.contracts.requests.PagedRequests;
import com.pharmahub.cancellationordersqs.entities.OderCancelRequest;
import com.pharmahub.cancellationordersqs.entities.OderCancelRequestStatus;
import com.pharmahub.cancellationordersqs.mappers.OderCancelRequestMapper;
import com.pharmahub.cancellationordersqs.mappers.OderCancelRequestStatusMapper;
import com.pharmahub.cancellationordersqs.repository.OderCancelRequestRepository;
import com.pharmahub.cancellationordersqs.repository.OderCancelRequestStatusRepository;
import com.pharmahub.cancellationordersqs.specifications.OderCancelRequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OderCancelRequestStatusService {

    @Autowired
    private OderCancelRequestStatusRepository oderCancelRequestStatusRepository;
    private final OderCancelRequestStatusMapper oderStatusMapper = OderCancelRequestStatusMapper.INSTANCE;

    public List<OderCancelRequestStatusDto> getAll() {
        var status = oderCancelRequestStatusRepository.findAll();
        return oderStatusMapper.mapEntitiesToDtos(status);
    }

}
