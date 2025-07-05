package com.nicolasflandin.predicteur.domain.port.useCase;

import com.nicolasflandin.predicteur.application.annotation.AnnotationDomain;
import com.nicolasflandin.predicteur.domain.dto.TirageDto;
import com.nicolasflandin.predicteur.domain.port.out.IAlimentateurMatrice;
import com.nicolasflandin.predicteur.domain.port.out.ICalculateurDelta;
import org.jetbrains.annotations.NotNull;

@AnnotationDomain
public class TraitementTirageUseCase {

    private final IAlimentateurMatrice alimentateurMatrice;
    private final ICalculateurDelta calculateurDelta;

    public TraitementTirageUseCase(
            final IAlimentateurMatrice alimentateurMatrice, final ICalculateurDelta calculateurDelta) {
        this.alimentateurMatrice = alimentateurMatrice;
        this.calculateurDelta = calculateurDelta;
    }

    public void traitementTirage(@NotNull final TirageDto tirageDto) throws Exception {
        alimentateurMatrice.alimentationMatrice(tirageDto);
        calculateurDelta.calculerDelta(tirageDto);
    }
}
