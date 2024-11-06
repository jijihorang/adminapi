package org.oz.adminapi.event.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EventDTO {
    private String makerBizNo;
    private Long storeNo;
    private LocalDateTime eventStart;
    private LocalDateTime eventEnd;
    private Integer eventStatus;
    private Boolean spaceRentStatus;
}
