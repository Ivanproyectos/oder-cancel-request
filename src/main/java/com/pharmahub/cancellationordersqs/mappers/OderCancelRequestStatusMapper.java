package com.pharmahub.cancellationordersqs.mappers;

import com.pharmahub.cancellationordersqs.contracts.dtos.OderCancelRequestDto;
import com.pharmahub.cancellationordersqs.contracts.dtos.OderCancelRequestStatusDto;
import com.pharmahub.cancellationordersqs.contracts.dtos.PagedResultDto;
import com.pharmahub.cancellationordersqs.entities.OderCancelRequest;
import com.pharmahub.cancellationordersqs.entities.OderCancelRequestStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper
public interface OderCancelRequestStatusMapper {
    OderCancelRequestStatusMapper INSTANCE = Mappers.getMapper(OderCancelRequestStatusMapper.class );

    List<OderCancelRequestStatusDto> mapEntitiesToDtos(List<OderCancelRequestStatus> statusList);

}
