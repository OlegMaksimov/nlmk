package ru.iteko.nlmk.service;

import com.opencsv.CSVReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.iteko.nlmk.aspect.Logable;
import ru.iteko.nlmk.dto.RoadAvailabilityDto;
import ru.iteko.nlmk.model.RoadAvailability;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


@Service
@Slf4j
public class RoadAvailabilityService {

    /**
     * Получение данных по наличию ПС
     *
     * @return
     */
    @Logable
    public RoadAvailabilityDto getRoadAvailability() {

        File file = new File("./", "RoadAvailability.csv");

        RoadAvailabilityDto dto = parse(file);

        return dto;
    }

    private RoadAvailabilityDto parse(File file) {
        List<RoadAvailability> resultList = new LinkedList<>();

        try (CSVReader reader = new CSVReader(new FileReader(file.getPath()), ',')) {
            reader.readAll()
                    .stream()
                    .skip(1)
                    .forEach(row -> {
                        RoadAvailability data = RoadAvailability.builder()
                                .roadCode(Integer.valueOf(row[0]))
                                .roadName(row[1])
                                .roadAvailable(Boolean.valueOf(row[2]))
                                .build();
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

        RoadAvailabilityDto dto = RoadAvailabilityDto.create(resultList, resultList.size());
        return dto;
    }
}
