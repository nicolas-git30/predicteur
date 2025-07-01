package com.nicolasflandin.predicteur.job.item.reader;

import com.nicolasflandin.predicteur.application.annotation.AnnotationJob;
import com.nicolasflandin.predicteur.application.dto.TirageDto;
import com.nicolasflandin.predicteur.domain.port.in.IUseCaseCreationPerimetre;
import com.nicolasflandin.predicteur.infrastructure.exception.ExceptionReadFile;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

@AnnotationJob
@Component
public class NumeroReader implements ItemReader<TirageDto> {

    private IUseCaseCreationPerimetre serviceCreationPerimetre; //Port UseCase

    @Override
    public TirageDto read() throws ExceptionReadFile {
        return serviceCreationPerimetre.CreationListTirage().get(0);
    }
}
