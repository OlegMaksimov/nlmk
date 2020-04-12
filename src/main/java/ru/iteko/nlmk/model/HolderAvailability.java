package ru.iteko.nlmk.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

/**
 * данные по наличию креплений
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Builder
@ToString
public class HolderAvailability {

    /** Тип крепления */
    String holderType;

    /** Количество едениц крепления */
    Integer holderAmount;

    /** Код цеха */
    Integer workshopCode;

    /** Дата и время */
    LocalDateTime date;
}
