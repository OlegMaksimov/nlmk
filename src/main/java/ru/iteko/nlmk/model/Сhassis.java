package ru.iteko.nlmk.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;


/**
 * Рама
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Builder
@ToString
public class Сhassis {

    /** Тип крепления */
    String holderType;

    /** Количество едениц крепления */
    Integer holderAmount;

    /** Код цеха */
    Integer workshopCode;
}
