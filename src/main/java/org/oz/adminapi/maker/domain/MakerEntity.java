package org.oz.adminapi.maker.domain;

import jakarta.persistence.*;
import lombok.*;
import org.oz.adminapi.common.domain.AttachFile;
import org.oz.adminapi.common.domain.BasicEntity;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@ToString(exclude = {"attachFiles"},callSuper = true)
@Table(name = "admin_maker")
// 제작자 Table
public class MakerEntity extends BasicEntity {

    @Id
    //제작자 사업자 번호 (PK)
    private String makerBizNo;

    //제작자 정보 부분
    private String makerName;
    private String makerEmail;
    private String makerPhone;

    //제작자 주소 부분
    private String makerPostnum;
    private String makerAddr;
    private String makerAddrDetail;

    //제작자 승인 상태
    private int makerStatus;

    @ElementCollection
    @Builder.Default
    @CollectionTable(
            name = "admin_maker_file", // 컬렉션 테이블 이름
            joinColumns = @JoinColumn(name = "maker_biz_no") // FK 컬럼 이름 설정
    )
    //제작자 포트폴리오 파일
    private Set<AttachFile> attachFiles = new HashSet<>();

    public void addFile(String filename){
        attachFiles.add(new AttachFile(attachFiles.size(), filename));
    }

    public void clearFiles(){
        attachFiles.clear();
    }


    public MakerEntity update(String name, String email, String phone, String postnum, String addr, String addrDetail) {
        return MakerEntity.builder()
                .makerBizNo(this.makerBizNo) // 기존 ID 유지
                .makerName(name != null ? name : this.makerName)
                .makerEmail(email != null ? email : this.makerEmail)
                .makerPhone(phone != null ? phone : this.makerPhone)
                .makerPostnum(postnum != null ? postnum : this.makerPostnum)
                .makerAddr(addr != null ? addr : this.makerAddr)
                .makerAddrDetail(addrDetail != null ? addrDetail : this.makerAddrDetail)
                .makerStatus(this.makerStatus)
                .attachFiles(this.attachFiles) // 파일 목록 유지
                .build();
    }

    // 파일 목록을 교체하는 메서드
    public void updateAttachFiles(java.util.List<String> newFileNames) {
        this.attachFiles.clear();
        newFileNames.forEach(name -> attachFiles.add(new AttachFile(attachFiles.size(), name)));
    }

}
