package com.nicolasflandin.predicteur.job.item.writer;

import com.nicolasflandin.predicteur.application.annotation.AnnotationJob;
import com.nicolasflandin.predicteur.domain.dto.TirageDto;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@AnnotationJob
@Component
public class FichierWriter implements ItemWriter<TirageDto> {
    @Override
    public void write(final Chunk<? extends TirageDto> chunk) throws Exception {}
}
