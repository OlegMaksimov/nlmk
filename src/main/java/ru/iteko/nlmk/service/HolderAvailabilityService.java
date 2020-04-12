package ru.iteko.nlmk.service;

import com.opencsv.CSVReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.DataBinder;
import ru.iteko.nlmk.aspect.Logable;
import ru.iteko.nlmk.dto.HolderAvailabilityDto;
import ru.iteko.nlmk.model.HolderAvailability;
import ru.iteko.nlmk.validators.HolderAvailabilityValidator;

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
public class HolderAvailabilityService {

    @Autowired
    private HolderAvailabilityValidator validator;

    /**
     * Получение данных по наличию ПС
     *
     * @return
     */
    @Logable
    public HolderAvailabilityDto getHolderAvailability() {

        File file = new File("./", "HolderAvailability.csv");

        HolderAvailabilityDto dto = parse(file);

        return dto;
    }

    private HolderAvailabilityDto parse(File file) {
        List<HolderAvailability> resultList = new LinkedList<>();

        try (CSVReader reader = new CSVReader(new FileReader(file.getPath()), ',')) {
            reader.readAll()
                    .stream()
                    .skip(1)
                    .forEach(row -> {
                        HolderAvailability data = HolderAvailability.builder()
                                .holderType(row[0])
                                .holderAmount(Integer.valueOf(row[1]))
                                .workshopCode(Integer.valueOf(row[2]))
                                .date(row[3].isEmpty() ? null : LocalDateTime.parse(row[3], DateTimeFormatter.ISO_DATE_TIME))
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

        HolderAvailabilityDto dto = HolderAvailabilityDto.create(resultList, resultList.size());
        return dto;
    }

    private void validate(HolderAvailability data) {
        final DataBinder dataBinder = new DataBinder(data);
        dataBinder.addValidators(validator);
        dataBinder.validate();
    }
}
