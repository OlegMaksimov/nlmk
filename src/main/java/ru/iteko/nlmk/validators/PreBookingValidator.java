package ru.iteko.nlmk.validators;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.iteko.nlmk.model.PreBooking;
import ru.iteko.nlmk.model.enums.CarriageType;
import ru.iteko.nlmk.model.enums.HolderType;

@Service
@Slf4j
public class PreBookingValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return PreBooking.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        log.info("  start validate " + this.getClass().getName() + " bean");

        PreBooking dto = (PreBooking) o;
        log.info("  ** {}", dto);

        if (!CarriageType.checkCarriageType(dto.getCarriageType())) {
            throw new IllegalArgumentException("    carriageType isn't valid : " + dto.getCarriageType()
                    + "  \n  ::"  + dto);
        }
        if (!HolderType.checkHolderType(dto.getHolderType())) {
            throw new IllegalArgumentException("    getHolderType isn't valid : " + dto.getHolderType()
                    + "  \n  ::"  + dto);
        }

        log.info("  end validate " + this.getClass().getName() + " bean");
    }
}
