package org.oz.adminapi.area.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_districtcode")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DistrictCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "district_no")
    private Long districtNo;

    private String districtName;

    @Column(name = "area_name", insertable = false, updatable = false)
    private String areaName;

    @Builder.Default
    private Boolean delFlag = Boolean.FALSE;

    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private String creator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_name", referencedColumnName = "area_name")
    private AreaCode areaCode;
}