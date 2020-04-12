package ru.iteko.nlmk.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.iteko.nlmk.model.CarriageAvailability;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "create")
@ToString
public class CarriageAvailabilityDto implements Serializable {

    /**
     * Информация о вагоне
     */
    List<CarriageAvailability> data;

    /**
     * Общее количество
     */
    Integer total;
}
