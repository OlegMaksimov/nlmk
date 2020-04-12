package ru.iteko.nlmk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.iteko.nlmk.aspect.Logable;
import ru.iteko.nlmk.dto.HolderBookingDto;
import ru.iteko.nlmk.service.HolderBookingService;

import java.util.List;

@RestController
    @RequestMapping("/holder-booking")
@Slf4j
public class HolderBookingController {

    @Autowired
    private HolderBookingService service;

    @PostMapping("/mock")
    @Logable
    public ResponseEntity<List<HolderBookingDto>> getHolderBooking(@RequestBody List<HolderBookingDto> dtoList) {

        if (dtoList == null) {
           throw new RuntimeException("parameter is null");
        } else {
            service.checkHolderBooking(dtoList);
        }

        return ResponseEntity.ok(dtoList);
    }
}
