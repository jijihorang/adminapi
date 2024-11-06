package org.oz.adminapi.localmaneger.dto;

import lombok.*;
import org.oz.adminapi.area.domain.AreaCode;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LocalManagerDTO {
    private Long managerNo;
    private String areaName;
    private String managerName;
    private String managerContact;
}
