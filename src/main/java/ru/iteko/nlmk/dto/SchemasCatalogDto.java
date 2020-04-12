package ru.iteko.nlmk.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.iteko.nlmk.model.SchemasCatalog;

import java.io.Serializable;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "create")
@ToString
public class SchemasCatalogDto implements Serializable {

    SchemasCatalog data;

    /** Общее количество */
    Integer total;
}
