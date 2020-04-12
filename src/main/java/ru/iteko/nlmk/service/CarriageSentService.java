package ru.iteko.nlmk.service;

import com.opencsv.CSVReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.DataBinder;
import ru.iteko.nlmk.aspect.Logable;
import ru.iteko.nlmk.dto.CarriagesSentDto;
import ru.iteko.nlmk.model.CarriagesSent;
import ru.iteko.nlmk.validators.CarriageSentValidator;

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
public class CarriageSentService {

    @Autowired
    private CarriageSentValidator validator;

    /**
     * Получение данных по наличию ПС
     *
     * @return
     */
    @Logable
    public CarriagesSentDto getCarriagesSent() {

        File file = new File("./", "CarriageSent.csv");

        CarriagesSentDto dto = parse(file);
        return dto;
    }

    private CarriagesSentDto parse(File file) {
        List<CarriagesSent> resultList = new LinkedList<>();

        try (CSVReader reader = new CSVReader(new FileReader(file.getPath()), ',')) {
            reader.readAll()
                    .stream()
                    .skip(1)
                    .forEach(row -> {
                        CarriagesSent data = CarriagesSent.builder()
                                .date(row[0].isEmpty() ? null : LocalDateTime.parse(row[0], DateTimeFormatter.ISO_DATE_TIME))
                                .shift(Integer.valueOf(row[1]))
                                .deadEnd(row[2])
                                .carriageId(Integer.valueOf(row[3]))
                                .carriageType(row[4])
                                .carriageCapacity(Double.valueOf(row[5]))
                                .carriageCondition(row[6])
                                .carriagePurpose(row[7])
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

        CarriagesSentDto dto = CarriagesSentDto.create(resultList, resultList.size());
        return dto;
    }

    private void validate (CarriagesSent data) {
        final DataBinder dataBinder = new DataBinder(data);
        dataBinder.addValidators(validator);
        dataBinder.validate();
    }
}
