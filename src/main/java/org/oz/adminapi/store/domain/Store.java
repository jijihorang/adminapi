package org.oz.adminapi.store.domain;

import jakarta.persistence.*;
import lombok.*;
import org.oz.adminapi.localmaneger.domain.LocalManager;
import org.oz.adminapi.area.domain.AreaCode;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "admin_store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_no")
    private Long storeNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "local_manager_no")
    private LocalManager localManager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_name", referencedColumnName = "area_name")
    private AreaCode areaCode;

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
