package org.oz.adminapi.store.dto;

import lombok.*;
import org.oz.adminapi.localmaneger.dto.LocalManagerDTO;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreDTO {

    private Long storeNo;

    private String areaName;

    private String storeName;

    private String storeContact;

    private String storeLatitude;

    private String storeLongitude;

    private Boolean isRentAvailable;

    private Boolean delFlag;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    private String creator;

    private LocalManagerDTO localManager;
}
