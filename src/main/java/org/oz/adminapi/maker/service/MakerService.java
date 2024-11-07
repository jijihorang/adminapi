package org.oz.adminapi.maker.service;

import com.querydsl.jpa.JPQLQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.oz.adminapi.maker.domain.MakerEntity;
import org.oz.adminapi.maker.dto.MakerModifyDTO;
import org.oz.adminapi.maker.dto.MakerReadDTO;
import org.oz.adminapi.maker.repository.MakerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class MakerService {

    private final MakerRepository makerRepository;

    public ResponseEntity<MakerReadDTO> readMaker(String makerBizNo) {

        Optional<MakerEntity> result = makerRepository.findWithFilesByMakerBizNo(makerBizNo);

        MakerEntity makerEntity = result.get();

        List<String> attachFileNames = makerEntity.getAttachFiles().stream()
                .map(file -> file.getFileName())
                .toList();

        MakerReadDTO makerReadDTO = MakerReadDTO.builder()
                .makerBizNo(makerEntity.getMakerBizNo())
                .makerName(makerEntity.getMakerName())
                .makerEmail(makerEntity.getMakerEmail())
                .makerPhone(makerEntity.getMakerPhone())
                .makerPostnum(makerEntity.getMakerPostnum())
                .makerAddr(makerEntity.getMakerAddr())
                .makerAddrDetail(makerEntity.getMakerAddrDetail())
                .attachFileNames(attachFileNames)
                .createDate(makerEntity.getCreateDate())
                .lastModifiedDate(makerEntity.getLastModifiedDate())
                .delFlag(makerEntity.getDelFlag())
                .creatorName(makerEntity.getCreatorName())
                .build();

        return ResponseEntity.ok(makerReadDTO);
    }

    public ResponseEntity<MakerEntity> modifyMaker(String makerBizId, MakerModifyDTO modifyDTO) {
        log.info("updateMaker---------------------------------------------");

        Optional<MakerEntity> optionalMakerEntity = makerRepository.findWithFilesByMakerBizNo(makerBizId);
        if (optionalMakerEntity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        MakerEntity makerEntity = optionalMakerEntity.get();

        // 일반 필드 업데이트
        MakerEntity updatedEntity = makerEntity.update(
                modifyDTO.getMakerName(),
                modifyDTO.getMakerEmail(),
                modifyDTO.getMakerPhone(),
                modifyDTO.getMakerPostnum(),
                modifyDTO.getMakerAddr(),
                modifyDTO.getMakerAddrDetail()
        );

        // attachFiles 업데이트
        updatedEntity.updateAttachFiles(modifyDTO.getAttachFileNames());

        return ResponseEntity.ok(updatedEntity); // 더티 체킹에 의해 변경 사항이 자동 반영됨
    }
}
