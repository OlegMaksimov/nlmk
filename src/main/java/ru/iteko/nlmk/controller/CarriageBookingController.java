package ru.iteko.nlmk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.iteko.nlmk.aspect.Logable;
import ru.iteko.nlmk.dto.CarriageBookingDto;
import ru.iteko.nlmk.service.CarriageBookingService;

import java.util.List;

@RestController
@RequestMapping("/carriage-booking")
@Slf4j
public class CarriageBookingController {

    @Autowired
    private CarriageBookingService service;

    @PostMapping("/mock")
    @Logable
    public ResponseEntity<List<CarriageBookingDto>> getCarriageBooking(@RequestBody List<CarriageBookingDto> dtoList) {

        if (dtoList == null) {
           throw new RuntimeException("parameter is null");
        } else {
            service.checkCarriageBooking(dtoList);
        }

        return ResponseEntity.ok(dtoList);
    }
}
