package org.oz.adminapi.maker.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.oz.adminapi.maker.domain.MakerEntity;
import org.oz.adminapi.maker.dto.MakerModifyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Log4j2
public class MakerTests {

    @Autowired
    private MakerRepository makerRepository;

    @Test
    @Transactional
    @Commit
    public void testDummies(){

        for (int i = 1; i <= 150; i++) {
            MakerEntity maker = MakerEntity.builder()
                    .makerBizNo( i + "23-45-67890")
                    .makerName("choi" + i)
                    .makerEmail("jiho"+ i +"@gmail.com")
                    .makerPhone("010-1234-5678")
                    .makerPostnum("47240")
                    .makerAddr("addr" + i)
                    .makerAddrDetail("addr detail" + i)
                    .makerStatus(0)
                    .build();
            makerRepository.save(maker);
            log.info(maker.toString());
        }//end for

    }

    @Test
    public void readOne() {
        String makerBizNo = "123-45-67890";
        MakerEntity entity = makerRepository.findWithFilesByMakerBizNo(makerBizNo).get();

        log.info(entity);
    }

    @Test
    @Transactional
    @Commit
    public void testModify(){

        log.info("updateMaker---------------------------------------------");

        String makerBizNo = "123-45-67890";
        List<String> files = new ArrayList<>();
        files.add("1111.jpg");
        files.add("2222.jpg");
        files.add("3333.jpg");
        MakerModifyDTO modifyDTO = MakerModifyDTO.builder()
                .makerName("Kim1")
                .attachFileNames(files)
                .build();

        Optional<MakerEntity> optionalMakerEntity = makerRepository.findWithFilesByMakerBizNo(makerBizNo);


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

        updatedEntity.changeDelFlag();

        // attachFiles 업데이트
        updatedEntity.updateAttachFiles(modifyDTO.getAttachFileNames());

        log.info(updatedEntity.toString());

        makerRepository.save(updatedEntity);
    }


}
