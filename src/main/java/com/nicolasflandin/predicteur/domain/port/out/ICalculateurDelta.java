package com.nicolasflandin.predicteur.domain.port.out;

import com.nicolasflandin.predicteur.application.annotation.AnnotationDomain;
import com.nicolasflandin.predicteur.domain.dto.TirageDto;
import org.jetbrains.annotations.NotNull;

@AnnotationDomain
public interface ICalculateurDelta {

    public void calculerDelta(@NotNull final TirageDto tirageDto);
}
