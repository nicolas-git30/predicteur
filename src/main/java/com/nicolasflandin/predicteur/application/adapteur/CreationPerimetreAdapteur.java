package com.nicolasflandin.predicteur.application.adapteur;

import com.nicolasflandin.predicteur.application.annotation.AnnotationApplication;
import com.nicolasflandin.predicteur.domain.dto.TirageDto;
import com.nicolasflandin.predicteur.domain.exception.ExceptionReadFile;
import com.nicolasflandin.predicteur.domain.port.out.ICreationPerimetre;
import com.nicolasflandin.predicteur.domain.port.out.ILecteurFichierCsv;
import com.nicolasflandin.predicteur.domain.provider.IDateFormaterProvider;
import com.nicolasflandin.predicteur.job.config.properties.FichierSource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@AnnotationApplication
@Service
public class CreationPerimetreAdapteur implements ICreationPerimetre {


    //Lyes Faut-il faire un brige pour cette injection ?
    private final ILecteurFichierCsv<CSVParser> lecteurCsv;
    private final FichierSource fichierSource;

    @Autowired
    public CreationPerimetreAdapteur(final ILecteurFichierCsv<CSVParser> lecteurCsv, final FichierSource fichierSource) {
        this.lecteurCsv = lecteurCsv;
        this.fichierSource = fichierSource;
    }

    @Override
    public List<TirageDto> CreationListTirage() throws ExceptionReadFile {
        List<TirageDto> tirages = new ArrayList<>();
        for (CSVRecord csvRecord : lecteurCsv.lectureFichier(fichierSource.getPath())) {
            TirageDto tirageDto = new TirageDto();

            LocalDate dateTirage = LocalDate.parse(csvRecord.get(1), DateTimeFormatter.ofPattern(
                    IDateFormaterProvider.FORMAT_DATE_FR));
            tirageDto.setDateTirage(dateTirage);

            Integer numeroDuTirage = Integer.parseInt(csvRecord.get(0));
            tirageDto.setNumeroDuTirage(numeroDuTirage);

            List<Integer> numeroTirage = new ArrayList<>();
            for (int i = 2; i < 7; i++) {
                numeroTirage.add(Integer.parseInt(csvRecord.get(i)));
            }

            List<Integer> etoileTirage = new ArrayList<>();
            for (int i = 7; i < csvRecord.size(); i++) {
                etoileTirage.add(Integer.parseInt(csvRecord.get(i)));
            }
            tirageDto.setEtoileTirage(etoileTirage);

            tirages.add(tirageDto);
        }
        return tirages;
    }
}
