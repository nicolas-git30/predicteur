package com.nicolasflandin.predicteur.job.item.processor;

import com.nicolasflandin.predicteur.application.annotation.AnnotationJob;
import com.nicolasflandin.predicteur.domain.dto.TirageDto;
import com.nicolasflandin.predicteur.domain.port.useCase.TraitementTirageUseCase;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;


@Component
@AnnotationJob
public class TirageProcessor implements ItemProcessor<TirageDto, TirageDto> {

    private final TraitementTirageUseCase traitementTirageUseCase;

    public TirageProcessor(final TraitementTirageUseCase traitementTirageUseCase) {
        this.traitementTirageUseCase = traitementTirageUseCase;
    }

    @Override
    public TirageDto process(final TirageDto item) throws Exception {
        traitementTirageUseCase.traitementTirage(item);
        return item;
    }
}
