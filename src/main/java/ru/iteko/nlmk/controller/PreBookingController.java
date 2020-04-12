package ru.iteko.nlmk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.iteko.nlmk.aspect.Logable;
import ru.iteko.nlmk.model.PreBooking;
import ru.iteko.nlmk.service.PreBookingService;

import java.util.List;

@RestController
@RequestMapping("/prebooking")
@Slf4j
public class PreBookingController {

    @Autowired
    private PreBookingService service;

    @GetMapping("/mock")
    @Logable
    public ResponseEntity<List<PreBooking>> getPrebooking() {

        List<PreBooking> preBookings = service.getPreBookingInfo();

        if (preBookings == null) {
            return ResponseEntity.badRequest().body(preBookings);
        } else {
            return ResponseEntity.ok(preBookings);
        }
    }
}
