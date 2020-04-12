package ru.iteko.nlmk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.iteko.nlmk.aspect.Logable;
import ru.iteko.nlmk.dto.RoadAvailabilityDto;
import ru.iteko.nlmk.service.RoadAvailabilityService;


@RestController
@RequestMapping("/road-availability")
@Slf4j
public class RoadAvailabilityController {

    @Autowired
    private RoadAvailabilityService service;

    @GetMapping("/mock")
    @Logable
    public ResponseEntity<RoadAvailabilityDto> getRoadAvailability() {

        RoadAvailabilityDto dto = service.getRoadAvailability();

        if (dto == null) {
            return ResponseEntity.badRequest().body(dto);
        } else {
            return ResponseEntity.ok(dto);
        }

    }
}
