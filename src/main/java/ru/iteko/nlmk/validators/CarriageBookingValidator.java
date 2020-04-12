package ru.iteko.nlmk.validators;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.iteko.nlmk.dto.CarriageBookingDto;
import ru.iteko.nlmk.model.enums.DeadEnd;

@Service
@Slf4j
public class CarriageBookingValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return CarriageBookingDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        log.info("  start validate " + this.getClass().getName() + " bean");

        CarriageBookingDto dto = (CarriageBookingDto) o;
        log.info("  ** {}", dto);

        if (!DeadEnd.checkDeadEnd(dto.getDeadEnd())) {
            throw new IllegalArgumentException("    DeadEnd isn't valid : " + dto.getDeadEnd()
                    + "  \n  ::"  + dto);
        }

        log.info("  end validate " + this.getClass().getName() + " bean");
    }
}
