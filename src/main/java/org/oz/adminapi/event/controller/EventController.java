package org.oz.adminapi.event.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.oz.adminapi.common.dto.PageRequestDTO;
import org.oz.adminapi.common.dto.PageResponseDTO;
import org.oz.adminapi.event.dto.EventDTO;
import org.oz.adminapi.event.service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/event")
@RequiredArgsConstructor
@Log4j2
public class EventController {

    private final EventService eventService;

    @GetMapping("list")
    public PageResponseDTO<EventDTO> list(PageRequestDTO pageRequestDTO) {
        return eventService.getList(pageRequestDTO);
    }
}