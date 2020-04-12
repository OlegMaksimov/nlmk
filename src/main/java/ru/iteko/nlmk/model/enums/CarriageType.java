package ru.iteko.nlmk.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Тип ПС
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CarriageType {
    PV("ПВ"),
    PL("ПЛ"),
    FPL("ФПЛ");

    private final String val;

    CarriageType(String val) {
        this.val = val;
    }

    /**
     * Проверка CarriageType на допустимые значения
     * @param val проверяемое значение
     * @return false если проверка не пройдена
     */
    public static boolean checkCarriageType (String val) {
        if (CarriageType.FPL.getVal().equals(val)) {
            return true;
        }
        else if (CarriageType.PL.getVal().equals(val)) {
            return true;
        }
        else if (CarriageType.PV.getVal().equals(val)) {
            return true;
        }
        else {
            return false;
        }
    }

    public String getVal() {
        return val;
    }


}
