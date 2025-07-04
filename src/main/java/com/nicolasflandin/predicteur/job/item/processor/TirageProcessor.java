package com.nicolasflandin.predicteur.job.item.processor;

import com.nicolasflandin.predicteur.application.annotation.AnnotationJob;
import com.nicolasflandin.predicteur.domain.dto.TirageDto;
import com.nicolasflandin.predicteur.job.dataJob.DataJobScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@AnnotationJob
@Component
public class TirageProcessor implements ItemProcessor<TirageDto, TirageDto> {

    private DataJobScope dataJobScope;

    public TirageProcessor(final DataJobScope dataJobScope) {
        this.dataJobScope = dataJobScope;
    }

    @Override
    public TirageDto process(final TirageDto item) throws Exception {
        return null;
    }
}
