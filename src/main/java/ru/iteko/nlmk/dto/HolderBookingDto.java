package ru.iteko.nlmk.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * заявки на крепления на смену (бронирование)
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@ToString
public class HolderBookingDto {

    /** Код цеха */
    Integer workshopCode;

    /** Дата и время */
    String date;

    /** Смена */
    Integer shift;

    /** Название тупика */
    String deadEnd;

    /** Тип крепления */
    String holderType;

    /** Количество креплений */
    Integer holderAmount;
}
