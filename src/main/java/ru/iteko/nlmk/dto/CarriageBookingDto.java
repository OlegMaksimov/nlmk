package ru.iteko.nlmk.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * Заявка на подачу (бронирование) ПС по ID
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@ToString
public class CarriageBookingDto implements Serializable {

    /** Дата и время бронирования */
    String date;

    /** Смена */
    Integer shift;

    /** Название тупика */
    String deadEnd;

    /** Номер заказа */
    Integer orderId;

    /** Объем отгрузки */
    Double totalWeight;

    /** ID вагона */
    Integer carriageId;

    /** Код цеха */
    Integer workshopCode;

}
