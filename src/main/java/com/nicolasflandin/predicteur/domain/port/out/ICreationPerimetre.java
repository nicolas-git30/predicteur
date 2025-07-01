package com.nicolasflandin.predicteur.domain.port.out;

import com.nicolasflandin.predicteur.application.annotation.AnnotationDomain;
import com.nicolasflandin.predicteur.domain.dto.TirageDto;
import com.nicolasflandin.predicteur.domain.exception.ExceptionReadFile;

import java.util.List;

@AnnotationDomain
public interface ICreationPerimetre {
    public List<TirageDto> CreationListTirage() throws ExceptionReadFile;
}
