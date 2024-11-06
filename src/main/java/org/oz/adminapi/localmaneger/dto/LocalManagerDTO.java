package org.oz.adminapi.localmaneger.dto;
import lombok.*;

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