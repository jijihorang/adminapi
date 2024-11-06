package org.oz.adminapi.store.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.oz.adminapi.common.dto.PageRequestDTO;
import org.oz.adminapi.common.dto.PageResponseDTO;
import org.oz.adminapi.localmaneger.dto.LocalManagerDTO;
import org.oz.adminapi.store.domain.Store;
import org.oz.adminapi.store.dto.StoreDTO;
import org.oz.adminapi.store.repository.StoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public PageResponseDTO<StoreDTO> getList(PageRequestDTO pageRequestDTO) {
        return storeRepository.list(pageRequestDTO);
    }

    public StoreDTO getStoreDetail(Long storeNo) {
        Store store = storeRepository.findById(storeNo).orElseThrow();
        return StoreDTO.builder()
                .storeNo(store.getStoreNo())
                .storeName(store.getStoreName())
                .storeContact(store.getStoreContact())
                .areaName(store.getAreaName())
                .storeLatitude(store.getStoreLatitude())
                .storeLongitude(store.getStoreLongitude())
                .isRentAvailable(store.getIsRentAvailable())
                .localManager(LocalManagerDTO.builder()
                        .managerNo(store.getLocalManager().getManagerNo())
                        .managerName(store.getLocalManager().getManagerName())
                        .build())
                .build();
    }
}
