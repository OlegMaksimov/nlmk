package ru.iteko.nlmk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.DataBinder;
import ru.iteko.nlmk.dto.CarriageBookingDto;
import ru.iteko.nlmk.validators.CarriageBookingValidator;

import java.util.List;

@Service

public class CarriageBookingService {

    @Autowired
    private CarriageBookingValidator validator;

    public void checkCarriageBooking(List<CarriageBookingDto> dtoList) {
        for (CarriageBookingDto dto: dtoList) {
            validate(dto);
        }
    }

    private void validate(CarriageBookingDto dto) {
        final DataBinder dataBinder = new DataBinder(dto);
        dataBinder.addValidators(validator);
        dataBinder.validate();
    }
}
