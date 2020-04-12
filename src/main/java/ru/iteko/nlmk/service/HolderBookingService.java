package ru.iteko.nlmk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.DataBinder;
import ru.iteko.nlmk.aspect.Logable;
import ru.iteko.nlmk.dto.HolderBookingDto;
import ru.iteko.nlmk.validators.HolderBookingValidator;

import java.util.List;

@Service
public class HolderBookingService {
    @Autowired
    private HolderBookingValidator validator;

    @Logable
    public void checkHolderBooking(List<HolderBookingDto> dtoList) {
        for (HolderBookingDto dto : dtoList) {
            validate(dto);
        }
    }

    private void validate(HolderBookingDto dto) {
        final DataBinder dataBinder = new DataBinder(dto);
        dataBinder.addValidators(validator);
        dataBinder.validate();
    }
}
