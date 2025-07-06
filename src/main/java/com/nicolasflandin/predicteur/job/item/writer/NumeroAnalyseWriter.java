package com.nicolasflandin.predicteur.job.item.writer;

import com.nicolasflandin.predicteur.application.annotation.AnnotationJob;
import com.nicolasflandin.predicteur.domain.dto.analyse.NumeroAnalyse;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
@AnnotationJob
public class NumeroAnalyseWriter implements ItemWriter<NumeroAnalyse> {

    @Override
    public void write(final Chunk<? extends NumeroAnalyse> chunk) throws Exception {

    }
}
