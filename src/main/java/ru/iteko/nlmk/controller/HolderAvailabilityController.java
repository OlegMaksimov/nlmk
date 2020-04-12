package ru.iteko.nlmk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.iteko.nlmk.aspect.Logable;
import ru.iteko.nlmk.dto.HolderAvailabilityDto;
import ru.iteko.nlmk.service.HolderAvailabilityService;


@RestController
@RequestMapping("/holder-availability")
@Slf4j
public class HolderAvailabilityController {

    @Autowired
    private HolderAvailabilityService service;

    @GetMapping("/mock")
    @Logable
    public ResponseEntity<HolderAvailabilityDto> getHolderAvailability() {

        HolderAvailabilityDto dto = service.getHolderAvailability();

        if (dto == null) {
            return ResponseEntity.badRequest().body(dto);
        } else {
            return ResponseEntity.ok(dto);
        }

    }
}
