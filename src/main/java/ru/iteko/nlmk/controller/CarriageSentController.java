package ru.iteko.nlmk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.iteko.nlmk.aspect.Logable;
import ru.iteko.nlmk.dto.CarriagesSentDto;
import ru.iteko.nlmk.service.CarriageSentService;

@RestController
@RequestMapping("/carriage-sent")
@Slf4j
public class CarriageSentController {

    @Autowired
    private CarriageSentService service;

    @GetMapping("/mock")
    @Logable
    public ResponseEntity<CarriagesSentDto> getCarriageSent() {
        CarriagesSentDto dto = service.getCarriagesSent();
        if (dto == null) {
            return ResponseEntity.badRequest().body(dto);
        } else {
            return ResponseEntity.ok(dto);
        }

    }
}
