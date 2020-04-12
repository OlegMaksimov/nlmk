package ru.iteko.nlmk.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * Данные по доступности направления (дороги)
 */
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class RoadAvailability {

    /** ID дороги */
    Integer roadCode;

    /** Наименование дороги */
    String roadName;

    /** Доступность для отправки */
    Boolean roadAvailable;
}
