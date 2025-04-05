package com.pharmahub.cancellationordersqs.mappers;

import com.pharmahub.cancellationordersqs.contracts.dtos.OderCancelRequestDto;
import com.pharmahub.cancellationordersqs.contracts.dtos.PagedResultDto;
import com.pharmahub.cancellationordersqs.contracts.requests.CreateOderCancelRequest;
import com.pharmahub.cancellationordersqs.entities.OderCancelRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface OderCancelRequestMapper {
    OderCancelRequestMapper INSTANCE = Mappers.getMapper(OderCancelRequestMapper.class );

    @Mapping(source="content", target="data")
    @Mapping(source="totalElements", target="totalRecords")
    @Mapping(source = "pageable.pageNumber", target = "pageNumber")
    @Mapping(source = "pageable.pageSize", target = "pageSize")
    PagedResultDto<OderCancelRequestDto> PageToPagedResult(Page<OderCancelRequest> page);

    OderCancelRequestDto OrederCancelToOrederCancelDto(OderCancelRequest request);
    OderCancelRequest OrederCancelDtoToOrederCancel(CreateOderCancelRequest request);
}
