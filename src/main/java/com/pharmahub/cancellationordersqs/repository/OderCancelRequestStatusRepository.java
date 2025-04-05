package com.pharmahub.cancellationordersqs.repository;

import com.pharmahub.cancellationordersqs.entities.OderCancelRequest;
import com.pharmahub.cancellationordersqs.entities.OderCancelRequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OderCancelRequestStatusRepository extends JpaRepository<OderCancelRequestStatus, Long>, JpaSpecificationExecutor<OderCancelRequest> {

}
