package com.nicolasflandin.predicteur.domain.port.useCase;

import com.nicolasflandin.predicteur.application.annotation.AnnotationDomain;
import com.nicolasflandin.predicteur.domain.dto.TirageDto;
import com.nicolasflandin.predicteur.domain.port.out.ICreateurPerimetre;
import java.util.List;

@AnnotationDomain
public class CreationPerimetreUseCase {

    private final ICreateurPerimetre creationPerimetre;

    public CreationPerimetreUseCase(final ICreateurPerimetre creationPerimetre) {
        this.creationPerimetre = creationPerimetre;
    }

    public List<TirageDto> CreationListTirage() throws Exception {
        return creationPerimetre.CreationListTirage();
    }
}
