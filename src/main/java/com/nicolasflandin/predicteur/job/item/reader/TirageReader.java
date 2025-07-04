package com.nicolasflandin.predicteur.job.item.reader;

import com.nicolasflandin.predicteur.application.annotation.AnnotationJob;
import com.nicolasflandin.predicteur.domain.dto.TirageDto;
import com.nicolasflandin.predicteur.domain.port.useCase.CreationPerimetreUseCase;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.List;

@AnnotationJob
@Component
public class TirageReader implements ItemReader<TirageDto> {

    private final CreationPerimetreUseCase creationPerimetreUseCase;
    private List<TirageDto> tirages;
    private int indexTirage = 0;

    public TirageReader(final CreationPerimetreUseCase creationPerimetreUseCase) {
        this.creationPerimetreUseCase = creationPerimetreUseCase;
    }

    @Override
    public TirageDto read(){
        if(!tirages.isEmpty() && indexTirage < tirages.size()) {
            return tirages.get(indexTirage++);
        } else {
            return null;
        }
    }

    @BeforeStep
    public void beforeStep() throws Exception {
        this.tirages = creationPerimetreUseCase.CreationListTirage();
    }
}
