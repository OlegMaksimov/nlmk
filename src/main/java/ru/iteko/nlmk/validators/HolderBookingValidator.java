package ru.iteko.nlmk.validators;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.iteko.nlmk.dto.HolderBookingDto;
import ru.iteko.nlmk.model.enums.DeadEnd;
import ru.iteko.nlmk.model.enums.HolderType;

@Service
@Slf4j
public class HolderBookingValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return HolderBookingDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        log.info("  start validate " + this.getClass().getName() + " bean");

        HolderBookingDto dto = (HolderBookingDto) o;
        log.info("  ** {}", dto);

        if (!DeadEnd.checkDeadEnd(dto.getDeadEnd())) {
            throw new IllegalArgumentException("    getDeadEnd isn't valid : " + dto.getDeadEnd()
                    + "  \n  ::"  + dto);
        }
        if (!HolderType.checkHolderType(dto.getHolderType())) {
            throw new IllegalArgumentException("    getHolderType isn't valid : " + dto.getHolderType()
                    + "  \n  ::"  + dto);
        }

        log.info("  end validate  " + this.getClass().getName() + "  bean");

    }
}
