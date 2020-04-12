package ru.iteko.nlmk.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import ru.iteko.nlmk.model.HolderAvailability;

import java.io.Serializable;
import java.util.List;

/**
 * Параметры запроса на получение данных по наличию креплений
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor(staticName = "create")
@ToString
public class HolderAvailabilityDto implements Serializable {

    List<HolderAvailability> data;

    /** Общее количество */
    Integer total;

}
