package ru.iteko.nlmk.model.enums;

/**
 * Тип крепления
 */
public enum HolderType {
    _ГО_ПДС("ГО ПДС"),
    _ГО_ПХПП("ГО ПХПП"),
    _Полимеры("Полимеры"),
    _Р_1("Р-1"),
    _Р_2("Р-2"),
    _Р_3("Р-3"),
    _Р_4("Р-4"),
    _SZRU("SZRU"),
    _RM_COIL_2("RM COIL-2"),
    _HT_COIL("HT COIL"),
    _FLAT_ROCK_ГО("FLAT ROCK ГО"),
    _RM_COIL_3("RM COIL-3"),
    _FLAT_ROCK_BO("FLAT ROCK BO"),
    _79343("79343");

    private final String val;

    HolderType(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    /**
     * Проверка HolderType на допустимые значения
     * @param val проверяемое значение
     * @return false если проверка не пройдена
     */
    public static boolean checkHolderType (String val) {
        if (HolderType._ГО_ПДС.getVal().equals(val)) {
            return true;
        }
        else if (HolderType._ГО_ПХПП.getVal().equals(val)) {
            return true;
        }
        else if (HolderType._Полимеры.getVal().equals(val)) {
            return true;
        }
        else if (HolderType._Р_1.getVal().equals(val)) {
            return true;
        }
        else if (HolderType._Р_2.getVal().equals(val)) {
            return true;
        }
        else if (HolderType._Р_3.getVal().equals(val)) {
            return true;
        }
        else if (HolderType._Р_4.getVal().equals(val)) {
            return true;
        }
        else if (HolderType._SZRU.getVal().equals(val)) {
            return true;
        }
        else if (HolderType._RM_COIL_2.getVal().equals(val)) {
            return true;
        }
        else if (HolderType._HT_COIL.getVal().equals(val)) {
            return true;
        }
        else if (HolderType._FLAT_ROCK_ГО.getVal().equals(val)) {
            return true;
        }
        else if (HolderType._RM_COIL_3.getVal().equals(val)) {
            return true;
        }
        else if (HolderType._FLAT_ROCK_BO.getVal().equals(val)) {
            return true;
        }
        else if (HolderType._79343.getVal().equals(val)) {
            return true;
        }
        else {
            return false;
        }
    }
}
