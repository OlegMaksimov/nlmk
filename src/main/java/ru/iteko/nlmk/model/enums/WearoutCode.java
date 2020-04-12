package ru.iteko.nlmk.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Код степени износа вагона
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum WearoutCode {
    _12(12d),
    _22(22d),
    _25(25d);

    private final Double val;

    WearoutCode(Double val) {
        this.val = val;
    }

    public Double getVal() {
        return val;
    }

    /**
     * Проверка WearoutCode на допустимые значения
     * @param val проверяемое значение
     * @return false если проверка не пройдена
     */
    public static boolean checkWearoutCode (double val) {
        if (WearoutCode._12.getVal() == val) {
            return true;
        }
        else if (WearoutCode._22.getVal() == val) {
            return true;
        }
        else if (WearoutCode._25.getVal() == val) {
            return true;
        }
        else {
            return false;
        }
    }
}
