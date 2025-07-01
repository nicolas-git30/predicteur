package com.nicolasflandin.predicteur.application.adapteur;

import com.nicolasflandin.predicteur.application.annotation.AnnotationDomain;
import com.nicolasflandin.predicteur.application.dto.TirageDto;
import com.nicolasflandin.predicteur.domain.dto.EtoileDto;
import com.nicolasflandin.predicteur.domain.dto.NumeroDto;
import com.nicolasflandin.predicteur.domain.port.in.IUseCaseCreationPerimetre;
import com.nicolasflandin.predicteur.domain.port.out.ILecteurFichierCsv;
import com.nicolasflandin.predicteur.infrastructure.exception.ExceptionReadFile;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@AnnotationDomain
public class UseCaseCreationPerimetre implements IUseCaseCreationPerimetre {

    private final ILecteurFichierCsv<CSVParser> lecteurCsv;

    public UseCaseCreationPerimetre(final ILecteurFichierCsv<CSVParser> lecteurCsv) {
        this.lecteurCsv = lecteurCsv;
    }

    @Override
    public List<TirageDto> CreationListTirage() throws ExceptionReadFile {
        List<TirageDto> tirages = new ArrayList<>();
        for (CSVRecord csvRecord : lecteurCsv.lectureFichier("path")) {
            TirageDto tirageDto = new TirageDto();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dateTirage = LocalDate.parse(csvRecord.get(1), formatter);
            tirageDto.setDateTirage(dateTirage);

            Integer numeroDuTirage = Integer.parseInt(csvRecord.get(0));
            tirageDto.setNumeroDuTirage(numeroDuTirage);

            List<NumeroDto> numeroTirage = new ArrayList<>();
            for (int i = 2; i < 7; i++) {
                NumeroDto numeroDto = new NumeroDto();
                numeroDto.setNumero(Integer.parseInt(csvRecord.get(i)));
                numeroDto.setNombreSorties(0);
                numeroTirage.add(numeroDto);
            }
            tirageDto.setNumeroTirage(numeroTirage);

            List<EtoileDto> etoileTirage = new ArrayList<>();
            for (int i = 7; i < csvRecord.size(); i++) {
                EtoileDto etoileDto = new EtoileDto();
                etoileDto.setNumeroEtoile(Integer.parseInt(csvRecord.get(i)));
                etoileDto.setNombreSorties(0);
                etoileDto.setDateSortie(LocalDate.now());
                etoileTirage.add(etoileDto);
            }
            tirageDto.setEtoileTirage(etoileTirage);

            tirages.add(tirageDto);
        }
        return tirages;
    }
}
