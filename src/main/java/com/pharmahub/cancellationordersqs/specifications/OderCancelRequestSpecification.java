package com.pharmahub.cancellationordersqs.specifications;

import com.pharmahub.cancellationordersqs.entities.OderCancelRequest;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class OderCancelRequestSpecification {
    public static Specification<OderCancelRequest> hasStatusRequest(Integer status){
        return(root, query, criteriaBuilder)->{
            if(status == null) {
                return criteriaBuilder.conjunction();
            }
           return criteriaBuilder.equal(root.get("oderCancelRequestStatus").get("id"), status);
        };
    }

    public static Specification<OderCancelRequest> hasCreatedDate(Date date){
        return(root, query, criteriaBuilder)->{
            if(date == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("createdDate"), date);
        };
    }
}
