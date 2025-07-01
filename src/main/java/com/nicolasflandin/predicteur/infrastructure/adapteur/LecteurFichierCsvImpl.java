package com.nicolasflandin.predicteur.infrastructure.adapteur;

import com.nicolasflandin.predicteur.application.annotation.AnnotationInfrastructure;
import com.nicolasflandin.predicteur.domain.port.out.ILecteurFichierCsv;
import com.nicolasflandin.predicteur.domain.exception.ExceptionReadFile;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@Repository
@AnnotationInfrastructure
public class LecteurFichierCsvImpl implements ILecteurFichierCsv<CSVParser> {

    @Override
    public CSVParser lectureFichier(final String path) throws ExceptionReadFile {
        try {
            Reader reader = new FileReader(path);
            return new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter(';'));
        } catch (IOException e) {
            throw new ExceptionReadFile(e);
        }
    }

}
