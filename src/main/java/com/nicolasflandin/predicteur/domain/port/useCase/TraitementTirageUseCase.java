package com.nicolasflandin.predicteur.domain.port.useCase;

import com.nicolasflandin.predicteur.application.annotation.AnnotationDomain;
import com.nicolasflandin.predicteur.domain.dto.TirageDto;
import com.nicolasflandin.predicteur.domain.port.out.IAlimentateurMatrice;
import org.jetbrains.annotations.NotNull;

@AnnotationDomain
public class TraitementTirageUseCase {

    private final IAlimentateurMatrice alimentateurMatrice;

    public TraitementTirageUseCase(final IAlimentateurMatrice alimentateurMatrice) {
        this.alimentateurMatrice = alimentateurMatrice;
    }

    public void traitementTirage(@NotNull final TirageDto tirageDto) throws Exception {
        alimentateurMatrice.alimentationMatrice(tirageDto);
    }
}
