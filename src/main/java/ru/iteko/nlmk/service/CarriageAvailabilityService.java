package ru.iteko.nlmk.service;

import com.opencsv.CSVReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.DataBinder;
import ru.iteko.nlmk.aspect.Logable;
import ru.iteko.nlmk.dto.CarriageAvailabilityDto;
import ru.iteko.nlmk.model.CarriageAvailability;
import ru.iteko.nlmk.validators.CarriageAvailabilityValidator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;


@Service
@Slf4j
public class CarriageAvailabilityService {

    @Autowired
    private CarriageAvailabilityValidator validator;

    /**
     * Получение данных по наличию ПС
     *
     * @return
     */
    @Logable
    public CarriageAvailabilityDto getCarriageAvailability() {

        File file = new File("./", "CarriageAvailability.csv");
        CarriageAvailabilityDto carriageAvailabilityDtoList = parse(file);

        return carriageAvailabilityDtoList;
    }

    private CarriageAvailabilityDto parse(File file) {
        List<CarriageAvailability> resultList = new LinkedList<>();

        try (CSVReader reader = new CSVReader(new FileReader(file.getPath()), ',')) {
            reader.readAll()
                    .stream()
                    .skip(1)
                    .forEach(row -> {
                        CarriageAvailability data = CarriageAvailability.builder()
                                .carriageId(Integer.valueOf(row[0]))
                                .carriageType(row[1])
                                .carriageCapacity(Double.valueOf(row[2]))
                                .wearout(Double.valueOf(row[3]))
                                .date(row[4].isEmpty() ? null : LocalDateTime.parse(row[4], DateTimeFormatter.ISO_DATE_TIME))
                                .build();
                        validate(data);
                        resultList.add(data);

                    });
        } catch (FileNotFoundException e) {
            log.error("file not found", e);
           throw new RuntimeException (e.getMessage(),e);
        } catch (IOException e) {
            log.error("file can't open", e);
            return null;
        } catch (Exception e) {
            log.error("other exception", e);
            throw new RuntimeException (e.getMessage(),e);
        }

        CarriageAvailabilityDto dto = CarriageAvailabilityDto.create(resultList, resultList.size());

        return dto;
    }

    private void validate (CarriageAvailability data) {
        final DataBinder dataBinder = new DataBinder(data);
        dataBinder.addValidators(validator);
        dataBinder.validate();
    }
}
