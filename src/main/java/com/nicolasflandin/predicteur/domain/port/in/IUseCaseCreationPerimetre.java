package com.nicolasflandin.predicteur.domain.port.in;

import com.nicolasflandin.predicteur.application.annotation.AnnotationDomain;
import com.nicolasflandin.predicteur.application.dto.TirageDto;
import com.nicolasflandin.predicteur.infrastructure.exception.ExceptionReadFile;

import java.util.List;

@AnnotationDomain
public interface IUseCaseCreationPerimetre {
    public List<TirageDto> CreationListTirage() throws ExceptionReadFile;
}
