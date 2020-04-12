package ru.iteko.nlmk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.iteko.nlmk.aspect.Logable;
import ru.iteko.nlmk.dto.CarriageAvailabilityDto;
import ru.iteko.nlmk.service.CarriageAvailabilityService;

@RestController
@RequestMapping("/carriage-availability")
@Slf4j
public class CarriageAvailabilityController {

    @Autowired
    private CarriageAvailabilityService carriageAvailabilityService;

    @GetMapping("/mock")
    @Logable
    public ResponseEntity<CarriageAvailabilityDto> getCarriageAvailability() {

        CarriageAvailabilityDto carriageAvailability = carriageAvailabilityService.getCarriageAvailability();

        if (carriageAvailability == null) {
            return ResponseEntity.badRequest().body(carriageAvailability);
        } else {
            return ResponseEntity.ok(carriageAvailability);
        }
    }
}
