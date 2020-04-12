package ru.iteko.nlmk.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Грузоподъемность
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Capacity {
    _69(69d),
    _69_5(69.5),
    _70(70d),
    _71(71d),
    _72(72d),
    _73(73d),
    _75(75d),
    _80(80d);

    private final double val;

    Capacity(double val) {
        this.val = val;
    }

    /**
     * Проверка Capasity на допустимые значения
     * @param val проверяемое значение
     * @return false если проверка не пройдена
     */
    public static boolean checkCapasity (double val) {
        if (Capacity._69.getVal() == val) {
            return true;
        }
        else if (Capacity._69_5.getVal() == val) {
            return true;
        }
        else if (Capacity._70.getVal() == val) {
            return true;
        }
        else if (Capacity._71.getVal() == val) {
            return true;
        }
        else if (Capacity._72.getVal() == val) {
            return true;
        }
        else if (Capacity._73.getVal() == val) {
            return true;
        }
        else if (Capacity._75.getVal() == val) {
            return true;
        }
        else if (Capacity._80.getVal() == val) {
            return true;
        }
        else {
            return false;
        }
    }

    public double getVal() {
        return val;
    }
}
