package ru.iteko.nlmk.validators;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.iteko.nlmk.model.CarriageAvailability;
import ru.iteko.nlmk.model.enums.Capacity;
import ru.iteko.nlmk.model.enums.CarriageType;
import ru.iteko.nlmk.model.enums.WearoutCode;

@Service
@Slf4j
public class CarriageAvailabilityValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return CarriageAvailability.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors e) {
        log.info("  start validate " + this.getClass().getName() + " bean");

        CarriageAvailability dto = (CarriageAvailability) o;
        log.info("  ** {}", dto);

        if (!CarriageType.checkCarriageType(dto.getCarriageType())) {
            throw new IllegalArgumentException("    carriageType isn't valid : " + dto.getCarriageType()
                    + "  \n  ::"  + dto);
        }
        if (!Capacity.checkCapasity(dto.getCarriageCapacity())) {
            throw new IllegalArgumentException("    CarriageCapacity isn't valid : " + dto.getCarriageCapacity()
                    + "  \n  ::"  + dto);
        }
        if (!WearoutCode.checkWearoutCode(dto.getWearout())) {
            throw new IllegalArgumentException("    Wearout() isn't valid : " + dto.getWearout()
                    + "  \n  ::"  + dto);
        }

        log.info("  end validate " + this.getClass().getName() + " bean");
    }


}
