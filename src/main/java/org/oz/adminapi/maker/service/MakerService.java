package org.oz.adminapi.maker.service;

import lombok.RequiredArgsConstructor;
import org.oz.adminapi.common.dto.PageRequestDTO;
import org.oz.adminapi.common.dto.PageResponseDTO;
import org.oz.adminapi.maker.dto.MakerListDTO;
import org.oz.adminapi.maker.repository.MakerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MakerService {

    private final MakerRepository makerRepository;

    public PageResponseDTO<MakerListDTO> getList(PageRequestDTO pageRequestDTO) {

        return makerRepository.makerlist(pageRequestDTO);
    }

}
