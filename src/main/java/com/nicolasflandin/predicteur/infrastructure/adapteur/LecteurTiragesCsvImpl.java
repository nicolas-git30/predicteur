package com.nicolasflandin.predicteur.infrastructure.adapteur;

import com.nicolasflandin.predicteur.application.annotation.AnnotationInfrastructure;
import com.nicolasflandin.predicteur.domain.exception.ExceptionReadFile;
import com.nicolasflandin.predicteur.domain.port.out.ILecteurFichierCsv;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

@Repository
@AnnotationInfrastructure
public class LecteurTiragesCsvImpl implements ILecteurFichierCsv<CSVParser> {

    @Override
    public CSVParser lectureFichier() throws ExceptionReadFile {
        try {
            Reader reader = new FileReader(ResourceUtils.getFile("classpath:sources/tirages.csv"));
            return new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter(';'));
        } catch (IOException e) {
            throw new ExceptionReadFile(e);
        }
    }
}
