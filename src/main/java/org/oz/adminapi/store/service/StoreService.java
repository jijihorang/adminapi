package org.oz.adminapi.store.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.oz.adminapi.common.dto.PageRequestDTO;
import org.oz.adminapi.common.dto.PageResponseDTO;
import org.oz.adminapi.store.domain.Store;
import org.oz.adminapi.store.dto.StoreDTO;
import org.oz.adminapi.store.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class StoreService {

    @Autowired
    private final StoreRepository storeRepository;

    public PageResponseDTO<StoreDTO> getList(PageRequestDTO pageRequestDTO) {
        return storeRepository.list(pageRequestDTO);
    }

    public Store getStoreDetail(Long storeNo) {
        return storeRepository.findByStoreNo(storeNo);
    }

}
