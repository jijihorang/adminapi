package org.oz.adminapi.maker.dto;

import com.fasterxml.classmate.AnnotationOverrides;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.oz.adminapi.common.domain.AttachFile;
import org.oz.adminapi.maker.domain.MakerEntity;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MakerModifyDTO {
    private String makerBizNo;

    //제작자 정보 부분
    private String makerName;
    private String makerEmail;
    private String makerPhone;

}
