package com.pharmahub.cancellationordersqs.repository;

import com.pharmahub.cancellationordersqs.entities.OderCancelRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OderCancelRequestRepository extends JpaRepository<OderCancelRequest, Long>, JpaSpecificationExecutor<OderCancelRequest> {

}
