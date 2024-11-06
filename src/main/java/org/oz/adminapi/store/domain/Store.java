package org.oz.adminapi.store.domain;

import jakarta.persistence.*;
import lombok.*;
import org.oz.adminapi.localmaneger.domain.LocalManager;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "local_manager_no")
    private LocalManager localManager;

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
}
