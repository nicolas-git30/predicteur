package com.nicolasflandin.predicteur.application.adapteur;

import com.nicolasflandin.predicteur.application.annotation.AnnotationDomain;
import com.nicolasflandin.predicteur.domain.dto.TirageDto;
import com.nicolasflandin.predicteur.domain.port.out.ICalculateurDelta;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@AnnotationDomain
@Service
public class CalculateurDeltaAdaptateur implements ICalculateurDelta {

    @Override
    public void calculerDelta(final @NotNull TirageDto tirageDto) {}
}
