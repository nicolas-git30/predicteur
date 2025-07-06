package com.nicolasflandin.predicteur.job.item.processor;

import com.nicolasflandin.predicteur.application.annotation.AnnotationJob;
import com.nicolasflandin.predicteur.domain.dto.analyse.NumeroAnalyse;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@AnnotationJob
public class NumeroAnalyseProcessor implements ItemProcessor<NumeroAnalyse, NumeroAnalyse> {

    @Override
    public NumeroAnalyse process(final NumeroAnalyse item) throws Exception {
        return null;
    }

}
