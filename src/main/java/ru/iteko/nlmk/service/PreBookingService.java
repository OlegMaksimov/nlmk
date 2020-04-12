package ru.iteko.nlmk.service;

import com.opencsv.CSVReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.DataBinder;
import ru.iteko.nlmk.aspect.Logable;
import ru.iteko.nlmk.model.PreBooking;
import ru.iteko.nlmk.validators.PreBookingValidator;

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
public class PreBookingService {

    @Autowired
    private PreBookingValidator validator;

    /**
     * Получение данных на отправку предварительной заявки на ПС
     *
     * @return
     */
    @Logable
    public List<PreBooking> getPreBookingInfo() {

        File file = new File("./", "PreBooking.csv");

        List<PreBooking> dtoList = parse(file);

        return dtoList;
    }

    private List<PreBooking> parse(File file) {
        List<PreBooking> resultList = new LinkedList<>();

        try (CSVReader reader = new CSVReader(new FileReader(file.getPath()), ',')) {
            reader.readAll()
                    .stream()
                    .skip(1)
                    .forEach(row -> {
                        PreBooking data = PreBooking.builder()
                                .date(row[0].isEmpty() ? null : LocalDateTime.parse(row[0], DateTimeFormatter.ISO_DATE_TIME))
                                .shift(Integer.valueOf(row[1]))
                                .carriageType(row[2])
                                .carriageAmount(Integer.valueOf(row[3]))
                                .holderType(row[4])
                                .holderAmount(Integer.valueOf(row[5]))
                                .build();
                        validate(data);
                        resultList.add(data);

                    });
        } catch (FileNotFoundException e) {
            log.error("file not found", e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (IOException e) {
            log.error("file can't open", e);
            return null;
        } catch (Exception e) {
            log.error("other exception", e);
            throw new RuntimeException(e.getMessage(), e);
        }

        return resultList;
    }

    private void validate(PreBooking data) {
        final DataBinder dataBinder = new DataBinder(data);
        dataBinder.addValidators(validator);
        dataBinder.validate();
    }
}
