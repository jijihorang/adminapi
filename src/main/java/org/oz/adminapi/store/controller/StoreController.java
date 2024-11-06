package org.oz.adminapi.store.controller;

import lombok.RequiredArgsConstructor;
import org.oz.adminapi.common.dto.PageRequestDTO;
import org.oz.adminapi.common.dto.PageResponseDTO;
import org.oz.adminapi.store.domain.Store;
import org.oz.adminapi.store.dto.StoreDTO;
import org.oz.adminapi.store.service.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping
    public PageResponseDTO<StoreDTO> list(PageRequestDTO pageRequestDTO) {
        return storeService.getList(pageRequestDTO);
    }

    @GetMapping("/{storeNo}")
    public ResponseEntity<Store> getStoreDetail(@PathVariable Long storeNo) {
        Store storeDTO = storeService.getStoreDetail(storeNo);
        return ResponseEntity.ok(storeDTO);
    }
}
