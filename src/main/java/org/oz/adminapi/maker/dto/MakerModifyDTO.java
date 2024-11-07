package org.oz.adminapi.maker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.oz.adminapi.common.domain.AttachFile;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MakerModifyDTO {

    //제작자 정보 부분
    private String makerName;
    private String makerEmail;
    private String makerPhone;

    //제작자 주소 부분
    private String makerPostnum;
    private String makerAddr;
    private String makerAddrDetail;

    private List<String> attachFileNames;

    public void addFileName(String filename){
        attachFileNames.add(filename);
    }

    public void clearFileNames(){
        attachFileNames.clear();
    }

}
