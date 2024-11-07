package org.oz.adminapi.common.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@ToString
public abstract class BaseEntity {

    // 삭제 여부
    private Boolean delFlag = false;

    // 생성 날짜
    @CreatedDate
    private LocalDateTime createDate;

    // 수정 날짜
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    // 생성자
    private String creatorName;

}
