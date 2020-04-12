package ru.iteko.nlmk.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import ru.iteko.nlmk.model.RoadAvailability;

import java.io.Serializable;
import java.util.List;

/**
 * Параметры ответа по запросу на получение данных по доступности направления (дороги)
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor(staticName = "create")
@ToString
public class RoadAvailabilityDto implements Serializable {

    List<RoadAvailability> data;

    /** Общее количество */
    Integer total;

}
