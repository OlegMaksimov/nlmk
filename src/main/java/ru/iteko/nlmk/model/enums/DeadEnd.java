package ru.iteko.nlmk.model.enums;

/**
 * Название тупика
 */
public enum DeadEnd {

    _28Г("28Г"),
    _29Г("29Г"),
    _30Г("30Г"),
    _31Г("31Г"),
    _34Г("34Г"),
    _35Г("35Г");

    private final String val;

    DeadEnd(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    /**
     * Проверка DeadEnd на допустимые значения
     * @param val проверяемое значение
     * @return false если проверка не пройдена
     */
    public static boolean checkDeadEnd (String val) {
        if (DeadEnd._28Г.getVal().equals(val)) {
            return true;
        }
        else if (DeadEnd._29Г.getVal().equals(val)) {
            return true;
        }
        else if (DeadEnd._30Г.getVal().equals(val)) {
            return true;
        }
        else if (DeadEnd._30Г.getVal().equals(val)) {
            return true;
        }
        else if (DeadEnd._31Г.getVal().equals(val)) {
            return true;
        }
        else if (DeadEnd._34Г.getVal().equals(val)) {
            return true;
        }
        else if (DeadEnd._35Г.getVal().equals(val)) {
            return true;
        }
        else {
            return false;
        }
    }
}
