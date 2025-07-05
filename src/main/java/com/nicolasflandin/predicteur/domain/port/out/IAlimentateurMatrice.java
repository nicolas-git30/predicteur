package com.nicolasflandin.predicteur.domain.port.out;

import com.nicolasflandin.predicteur.application.annotation.AnnotationDomain;
import com.nicolasflandin.predicteur.domain.dto.TirageDto;
import org.jetbrains.annotations.NotNull;

@AnnotationDomain
public interface IAlimentateurMatrice {

    public void alimentationMatrice(@NotNull final TirageDto tirageDto);
}
