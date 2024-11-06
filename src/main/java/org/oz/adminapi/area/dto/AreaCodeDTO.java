package org.oz.adminapi.area.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AreaCodeDTO {
    private String areaName;
    private Boolean delFlag;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private String creator;
}
