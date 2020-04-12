package ru.iteko.nlmk.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * Cхема погрузки
 */
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class SchemasCatalog {

    /** id схемы погрузки */
    Integer schemaId;

    /** Наименование схемы погрузки */
    String schemaName;

    /** Применимость для отправки */
    String applicability;

    /** Тип ПС */
    String carriageType;

    /** Количество рулонов минимально, шт. */
    Integer minRollsAmount;

    /** Количество рулонов максимально, шт. */
    Integer maxRollsAmount;

    /** только четное число рулонов */
    Boolean parityRolls;

    /** наружный диаметр от, мм. */
    Integer rollOuterDiameterFrom;

    /** наружный диаметр до, мм. */
    Integer rollOuterDiameterTo;

    /** ширина от, мм. */
    Integer rollWidthFrom;

    /** ширина до, мм. */
    Integer rollWidthTo;

    /** масса рулона от, т. */
    Integer rollWeightFrom;

    /** масса рулона до, т. */
    Integer rollWeightTo;

    /** максимальная загрузка, т. */
    Integer maxLoadLimit;

    /** Тип крепления */
    String holderType;

    /** ID крепления */
    Integer holderId;

    /** Количество креплений */
    Integer holderAmount;

    /** цех */
    String workShop;

    /** максимальная грузоподъемность (прокат) */
    Integer totalWeightLimit;

}
