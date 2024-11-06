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
public class DistrictCodeDTO {
    private Long districtId;
    private String areaName; // 외래키로 사용
    private String districtName;
    private Boolean delFlag;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private String creator;
}
