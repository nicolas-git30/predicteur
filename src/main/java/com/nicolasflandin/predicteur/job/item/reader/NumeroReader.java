package com.nicolasflandin.predicteur.job.item.reader;

import com.nicolasflandin.predicteur.application.annotation.AnnotationJob;
import com.nicolasflandin.predicteur.domain.dto.TirageDto;
import com.nicolasflandin.predicteur.domain.exception.ExceptionReadFile;
import com.nicolasflandin.predicteur.domain.port.useCase.CreationPerimetreUseCase;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

@AnnotationJob
@Component
public class NumeroReader implements ItemReader<TirageDto> {

    private final CreationPerimetreUseCase creationPerimetreUseCase;

    public NumeroReader(final CreationPerimetreUseCase creationPerimetreUseCase) {
        this.creationPerimetreUseCase = creationPerimetreUseCase;
    }

    @Override
    public TirageDto read() throws ExceptionReadFile {
        return creationPerimetreUseCase.CreationListTirage().get(0);
    }
}
