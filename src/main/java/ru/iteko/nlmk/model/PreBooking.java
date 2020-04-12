package ru.iteko.nlmk.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


/**
 * Информация о предварительной заявки на ПС
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Builder
@ToString
public class PreBooking {

    /** Дата заявки */
    LocalDateTime date;

    /** Смена */
    Integer shift;

    /** Тип ПС */
    String carriageType;

    /** Количество ПС */
    Integer carriageAmount;

    /** Тип крепления */
    String holderType;

    /** Количество креплений */
    Integer holderAmount;
}
