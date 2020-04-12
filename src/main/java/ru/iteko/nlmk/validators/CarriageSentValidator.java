package ru.iteko.nlmk.validators;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.iteko.nlmk.model.CarriagesSent;
import ru.iteko.nlmk.model.enums.Capacity;
import ru.iteko.nlmk.model.enums.CarriageType;
import ru.iteko.nlmk.model.enums.DeadEnd;

@Service
@Slf4j
public class CarriageSentValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return CarriagesSent.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors e) {
        log.info("  start validate " + this.getClass().getName() + " bean");

        CarriagesSent dto = (CarriagesSent) o;
        log.info("  ** {}", dto);

        if (!CarriageType.checkCarriageType(dto.getCarriageType())) {
            throw new IllegalArgumentException("    carriageType isn't valid : " + dto.getCarriageType()
                    + "  \n  ::"  + dto);
        }
        if (!Capacity.checkCapasity(dto.getCarriageCapacity())) {
            throw new IllegalArgumentException("    CarriageCapacity isn't valid : " + dto.getCarriageCapacity()
                    + "  \n  ::"  + dto);
        }
        if (!DeadEnd.checkDeadEnd(dto.getDeadEnd())) {
            throw new IllegalArgumentException("    DeadEnd isn't valid : " + dto.getDeadEnd()
                    + "  \n  ::"  + dto);
        }

        log.info("  end validate " + this.getClass().getName() + " bean");
    }

}
