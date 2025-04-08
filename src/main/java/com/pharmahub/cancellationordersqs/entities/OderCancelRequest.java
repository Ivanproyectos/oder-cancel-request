package com.pharmahub.cancellationordersqs.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.poi.hpsf.Decimal;

import java.math.BigDecimal;
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

    @Column(name = "ntranfer_number", nullable = true)
    private Long transferNumber;

    @Column(name = "nunits", nullable = false)
    private Integer units;

    @Column(name = "nsku_quantity", nullable = false)
    private Integer skuQuantity;

    @Column(name = "norder_amount", nullable = false,precision = 14, scale = 2)
    private BigDecimal  orderAmount;

    @Column(name = "norder_type", nullable = false)
    private String orderType;

    @Column(name = "ngeneral_status_cancel_qs_id", nullable = false, length = 100)
    private Integer generalStatusCancelId;

    @Column(name = "smotive_no_cancel", nullable = false, length = 250)
    private String motiveNoCancel;

    @ManyToOne
    @JoinColumn(name = "nrequeststatus")
    private OderCancelRequestStatus oderCancelRequestStatus;

}
