package com.pharmahub.cancellationordersqs.services.core;

import com.pharmahub.cancellationordersqs.contracts.dtos.OderCancelRequestDto;
import com.pharmahub.cancellationordersqs.contracts.dtos.PagedResultDto;
import com.pharmahub.cancellationordersqs.contracts.requests.CreateOderCancelRequest;
import com.pharmahub.cancellationordersqs.contracts.requests.OrderCancelFilterRequest;
import com.pharmahub.cancellationordersqs.contracts.requests.PagedRequests;
import com.pharmahub.cancellationordersqs.entities.OderCancelRequest;
import com.pharmahub.cancellationordersqs.enums.OderCancelRequestStatusEnum;
import com.pharmahub.cancellationordersqs.mappers.OderCancelRequestMapper;
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
public class OderCancelRequestService {

    @Autowired
    private OderCancelRequestRepository oderCancelRequestRepository;
    @Autowired
    private OderCancelRequestStatusRepository oderCancelRequestStatustRepository;

    private final OderCancelRequestMapper oderCancelRequestMapper = OderCancelRequestMapper.INSTANCE;

    public List<OderCancelRequest> getOderCancelRequests() {
        return oderCancelRequestRepository.findAll();
    }

    public PagedResultDto<OderCancelRequestDto> getOderCancelRequestsPaged(PagedRequests<OrderCancelFilterRequest> request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
        Specification<OderCancelRequest> specification = Specification
                .where(OderCancelRequestSpecification.hasStatusRequest(request.getFilter().getRequestStatus()))
                .and(OderCancelRequestSpecification.hasCreatedDate(request.getFilter().getCreatedDate()));

        var userPage = oderCancelRequestRepository.findAll(specification,pageable);
        return oderCancelRequestMapper.PageToPagedResult(userPage);
    }

    public OderCancelRequest createOderCancelRequest(CreateOderCancelRequest request) {
        var orderStatusDefault = OderCancelRequestStatusEnum.PENDING;
        var oderCancelRequestStatus = oderCancelRequestStatustRepository
                .findById(Long.valueOf(orderStatusDefault.getCode())).orElseThrow();

        var orderCancel = oderCancelRequestMapper.OrederCancelDtoToOrederCancel(request);

        orderCancel.setOderCancelRequestStatus(oderCancelRequestStatus);
        return oderCancelRequestRepository.save(orderCancel);
    }
}
