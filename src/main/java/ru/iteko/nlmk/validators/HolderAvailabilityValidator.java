package ru.iteko.nlmk.validators;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.iteko.nlmk.model.HolderAvailability;
import ru.iteko.nlmk.model.enums.HolderType;

@Service
@Slf4j
public class HolderAvailabilityValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return HolderAvailability.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors e) {
        log.info("  start validate " + this.getClass().getName() + " bean");

        HolderAvailability dto = (HolderAvailability) o;
        log.info("  ** {}", dto);

        if (!HolderType.checkHolderType(dto.getHolderType())) {
            throw new IllegalArgumentException("    getHolderType isn't valid : " + dto.getHolderType()
                    + "  \n  ::"  + dto);
        }

        log.info("  end validate " + this.getClass().getName() + " bean");
    }

}
