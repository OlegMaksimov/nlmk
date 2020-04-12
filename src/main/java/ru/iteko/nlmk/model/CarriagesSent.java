package ru.iteko.nlmk.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 */
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class CarriagesSent implements Serializable {

    /** Дата и время */
    LocalDateTime date;

    /** Смена */
    Integer shift;

    /** Название тупика */
    String deadEnd;

    /** номер вагона */
    Integer carriageId;

    /** Тип ПС */
    String carriageType;

    /** Грузоподъемность */
    Double carriageCapacity;

    /** */
    String carriageCondition;

    /** */
    String carriagePurpose;

}
