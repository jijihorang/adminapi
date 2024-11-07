package org.oz.adminapi.maker.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.oz.adminapi.maker.domain.MakerEntity;
import org.oz.adminapi.maker.dto.MakerModifyDTO;
import org.oz.adminapi.maker.dto.MakerReadDTO;
import org.oz.adminapi.maker.service.MakerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/maker")
@RequiredArgsConstructor
@Log4j2
public class MakerController {
    private final MakerService makerService;

    @GetMapping("/read/{makerBizNo}")
    public ResponseEntity<MakerReadDTO> getOne(@PathVariable(name = "makerBizNo")String makerBizNo){
        return ResponseEntity.ok(makerService.readMaker(makerBizNo));
    }

    @PutMapping("/modify")
    public ResponseEntity<String> updateMaker(
            @RequestBody MakerModifyDTO updateDTO) {
        return ResponseEntity.ok(makerService.modifyMaker(updateDTO));
    }
}
