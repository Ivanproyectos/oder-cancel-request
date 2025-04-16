package com.pharmahub.cancellationordersqs.services.core;

import com.pharmahub.cancellationordersqs.contracts.dtos.OderCancelRequestStatusDto;
import com.pharmahub.cancellationordersqs.mappers.OderCancelRequestStatusMapper;
import com.pharmahub.cancellationordersqs.repository.OderCancelRequestStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
