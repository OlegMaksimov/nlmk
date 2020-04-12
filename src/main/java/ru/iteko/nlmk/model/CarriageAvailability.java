package ru.iteko.nlmk.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Информация о вагоне
 */
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class CarriageAvailability implements Serializable {

    /**
     * номер вагона
     */
    Integer carriageId;

    /**
     * Тип ПС
     */
    String carriageType;

    /**
     * Грузоподъемность
     */
    Double carriageCapacity;

    /**
     * Код степени износа вагона
     */
    Double wearout;

    /**
     * Дата и время
     */
    LocalDateTime date;
}
