package com.pharmahub.cancellationordersqs.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "ordercancelrequest_qs")
@Data
public class OderCancelRequest {
    public  OderCancelRequest() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nid", nullable = false)
    private Long id;

    @Column(name = "scenter", length = 100)
    private String Center;

    @Column(name = "nsaporder")
    private Long sapOrderCode;

    @Column(name = "nclient")
    private int Client;

    @Column(name = "scompanyname" , length = 250)
    private String companyName;

    @Column(name = "npmmorder")
    private Long pmmOrderCode;

    @Column(name = "dsaporderdate")
    private Date orderDateSAP;

 /*   @Column(name = "nrequeststatus")
    private int requestStatus;*/

    @Column(name = "screated_by_user", length = 50)
    private String createdByUser;

    @Column(name = "dcreated_date", insertable = false)
    private Date createdDate;

    @Column(name = "smodified_by_user", length = 50)
    private String modifiedByUser;

    @Column(name = "dmodified_by_date")
    private Date modifiedDate;

    @ManyToOne
    @JoinColumn(name = "nrequeststatus")
    private OderCancelRequestStatus oderCancelRequestStatus;

}
