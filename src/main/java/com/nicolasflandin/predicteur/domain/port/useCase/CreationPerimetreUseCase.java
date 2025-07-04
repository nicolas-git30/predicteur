package com.nicolasflandin.predicteur.domain.port.useCase;

import com.nicolasflandin.predicteur.domain.dto.TirageDto;
import com.nicolasflandin.predicteur.domain.port.out.ICreationPerimetre;

import java.util.List;

public class CreationPerimetreUseCase {

    private final ICreationPerimetre creationPerimetre;

    public CreationPerimetreUseCase(final ICreationPerimetre creationPerimetre) {
        this.creationPerimetre = creationPerimetre;
    }

    public List<TirageDto> CreationListTirage() throws Exception{
        return  creationPerimetre.CreationListTirage();
    }
}
