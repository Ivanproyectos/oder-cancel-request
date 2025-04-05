package com.pharmahub.cancellationordersqs.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "order_cancel_status_qs")
@Data
public class OderCancelRequestStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nid")
    private int id;

    @Column(name = "sdescript_short", length = 30)
    private String shortDescription;

    @Column(name = "sdescript", length = 150)
    private String description;

    @Column(name = "screated_by_user", length = 50)
    private String createdByUser;

    @Column(name = "dcreated_date")
    private Date createdDate;

    @Column(name = "smodified_by_user" , length = 50)
    private String modifiedByUser;

    @Column(name = "dmodified_by_date")
    private Date modifiedDate;
}
