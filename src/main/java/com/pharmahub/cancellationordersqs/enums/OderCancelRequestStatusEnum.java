package com.pharmahub.cancellationordersqs.enums;

public enum OderCancelRequestStatusEnum {
    PENDING(1),
    IN_PROGRESS(2),
    DENIED(3),
    UNDER_REVIEW(4),
    ERROR(5),
    CANCELED(6);

    private final int code;

    OderCancelRequestStatusEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
