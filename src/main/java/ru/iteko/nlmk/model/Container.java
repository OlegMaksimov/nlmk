package ru.iteko.nlmk.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Контейнер
 */
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Container {

    /** Контейнеры в долгосрочной аренде */
    List<ContainerInfo> containerRent;

    /** Контейнеры, предоставленные на рейс */
    List<ContainerInfo> containerView;
}
