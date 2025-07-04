package com.nicolasflandin.predicteur.application.adapteur;

import com.nicolasflandin.predicteur.application.annotation.AnnotationApplication;
import com.nicolasflandin.predicteur.application.exception.ExceptionMappingTirage;
import com.nicolasflandin.predicteur.domain.dto.TirageDto;
import com.nicolasflandin.predicteur.domain.exception.ExceptionReadFile;
import com.nicolasflandin.predicteur.domain.port.out.ICreationPerimetre;
import com.nicolasflandin.predicteur.domain.port.out.ILecteurFichierCsv;
import com.nicolasflandin.predicteur.domain.provider.IDateFormaterProvider;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

@AnnotationApplication
@Service
public class CreationPerimetreAdapteur implements ICreationPerimetre {

    private final ILecteurFichierCsv<CSVParser> lecteurCsv;

    public CreationPerimetreAdapteur(final ILecteurFichierCsv<CSVParser> lecteurCsv) {
        this.lecteurCsv = lecteurCsv;
    }

    @Override
    public List<TirageDto> CreationListTirage() throws ExceptionReadFile, ExceptionMappingTirage {
        List<TirageDto> tirages = new ArrayList<>();
        for (CSVRecord csvRecord : lecteurCsv.lectureFichier()) {
            try {
                TirageDto tirageDto = new TirageDto();

                LocalDate dateTirage = LocalDate.parse(
                        csvRecord.get(1), DateTimeFormatter.ofPattern(IDateFormaterProvider.FORMAT_DATE_FR));
                tirageDto.setDateTirage(dateTirage);

                Integer numeroDuTirage = Integer.parseInt(csvRecord.get(0));
                tirageDto.setNumeroDuTirage(numeroDuTirage);

                List<Integer> numeroTirage = new ArrayList<>();
                for (int i = 2; i < 7; i++) {
                    numeroTirage.add(Integer.parseInt(csvRecord.get(i)));
                }
                tirageDto.setNumeroTirage(numeroTirage);

                List<Integer> etoileTirage = new ArrayList<>();
                for (int i = 7; i < csvRecord.size(); i++) {
                    etoileTirage.add(Integer.parseInt(csvRecord.get(i)));
                }
                tirageDto.setEtoileTirage(etoileTirage);

                tirages.add(tirageDto);
            } catch (Exception e) {
                throw new ExceptionMappingTirage(e);
            }
        }
        return tirages;
    }
}
