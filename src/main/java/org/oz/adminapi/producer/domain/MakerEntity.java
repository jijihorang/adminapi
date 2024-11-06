package org.oz.adminapi.producer.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString(exclude = {"attachFiles"})
@Table(name = "admin_maker")
public class MakerEntity {
    @Id
    private Long makerBizNo;

    private String makerName;
    private String makerEmail;
    private String makerPhone;

    private String makerPostnum;
    private String makerAddr;
    private String makerAddrDetail;

    private String makerStatus;

    @ElementCollection
    @Builder.Default
    @CollectionTable(name = "maker_file")
    private Set<AttachFile> attachFiles = new HashSet<>();

    public void addFile(String filename){
        attachFiles.add(new AttachFile(attachFiles.size(), filename));
    }
    public void clearFiles(){
        attachFiles.clear();
    }
}
