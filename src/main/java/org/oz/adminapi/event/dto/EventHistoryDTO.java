package org.oz.adminapi.event.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EventHistoryDTO {
    private Integer eventStatus;
    private Boolean makerSpaceRent;
    private String rejectReason;
}


