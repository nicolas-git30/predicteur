package com.nicolasflandin.predicteur.job.item.reader;

import com.nicolasflandin.predicteur.application.annotation.AnnotationJob;
import com.nicolasflandin.predicteur.domain.dto.analyse.NumeroAnalyse;
import com.nicolasflandin.predicteur.job.dataJob.DataJobScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

@Component
@AnnotationJob
public class NumeroAnalyseReader implements ItemReader<NumeroAnalyse> {
    private final DataJobScope dataJobScope;
    private int indexNumero = 0;

    public NumeroAnalyseReader(final DataJobScope dataJobScope) {
        this.dataJobScope = dataJobScope;
    }
    @Override
    public NumeroAnalyse read() throws Exception {
        if(!this.dataJobScope.NumerosAnalyse.isEmpty() && this.indexNumero < this.dataJobScope.NumerosAnalyse.size()) {
            System.out.println("NumeroAnalyseReader : ");
            return this.dataJobScope.NumerosAnalyse.get(this.indexNumero++);
        }
        return null;
    }
}
