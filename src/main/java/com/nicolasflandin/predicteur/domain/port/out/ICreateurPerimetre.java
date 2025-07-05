package com.nicolasflandin.predicteur.domain.port.out;

import com.nicolasflandin.predicteur.application.annotation.AnnotationDomain;
import com.nicolasflandin.predicteur.domain.dto.TirageDto;
import java.util.List;

@AnnotationDomain
public interface ICreateurPerimetre {
    public List<TirageDto> CreationListTirage() throws Exception;
}
