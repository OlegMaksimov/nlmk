package ru.iteko.nlmk.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import ru.iteko.nlmk.model.CarriagesSent;

import java.util.List;

/**
 * запросу на получение данных по фактически отправленным в цех ПС
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor(staticName = "create")
@ToString
public class CarriagesSentDto {

    List<CarriagesSent> data;

    /** Общее количество */
    Integer total;
}
