package ru.iteko.nlmk.service;

import com.opencsv.CSVReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.DataBinder;
import ru.iteko.nlmk.aspect.Logable;
import ru.iteko.nlmk.dto.SchemasCatalogDto;
import ru.iteko.nlmk.model.SchemasCatalog;
import ru.iteko.nlmk.validators.SchemasCatalogValidator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
public class SchemasCatalogService {

    @Autowired
    private SchemasCatalogValidator validator;

    /**
     * Получение данных по наличию ПС
     *
     * @return
     */
    @Logable
    public List<SchemasCatalogDto> getSchemasCatalog() {

        File file = new File("./", "CarriageSent.csv");
        log.info("getSchemasCatalog file exist: " + file.exists());

        List<SchemasCatalogDto> dtoList = parse(file);

        return dtoList;
    }

    private List<SchemasCatalogDto> parse(File file) {
        List<SchemasCatalogDto> resultList = new LinkedList<>();

        try (CSVReader reader = new CSVReader(new FileReader(file.getPath()), ',')) {
            reader.readAll()
                    .stream()
                    .skip(1)
                    .forEach(row -> {
                        SchemasCatalog data = SchemasCatalog.builder()
                                .schemaId(Integer.valueOf(row[0]))
                                .schemaName(row[1])
                                .applicability(row[2])
                                .carriageType(row[3])
                                .minRollsAmount(Integer.valueOf(row[4]))
                                .maxRollsAmount(Integer.valueOf(row[5]))
                                .parityRolls(Boolean.valueOf(row[6]))
                                .rollOuterDiameterFrom(Integer.valueOf(row[7]))
                                .rollOuterDiameterTo(Integer.valueOf(row[8]))
                                .rollWidthFrom(Integer.valueOf(row[9]))
                                .rollWidthTo(Integer.valueOf(row[10]))
                                .rollWeightFrom(Integer.valueOf(row[11]))
                                .rollWeightTo(Integer.valueOf(row[12]))
                                .maxLoadLimit(Integer.valueOf(row[13]))
                                .holderType(row[14])
                                .holderId(Integer.valueOf(row[15]))
                                .holderAmount(Integer.valueOf(row[16]))
                                .workShop(row[17])
                                .totalWeightLimit(Integer.valueOf(row[18]))
                                .build();
                        validate(data);
                        SchemasCatalogDto dto = SchemasCatalogDto.create(data, Integer.valueOf(row[8]));
                        resultList.add(dto);

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

        return resultList;
    }

    private void validate (SchemasCatalog data) {
        final DataBinder dataBinder = new DataBinder(data);
        dataBinder.addValidators(validator);
        dataBinder.validate();
    }
}
