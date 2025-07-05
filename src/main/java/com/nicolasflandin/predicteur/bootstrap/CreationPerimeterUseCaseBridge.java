package com.nicolasflandin.predicteur.bootstrap;

import com.nicolasflandin.predicteur.domain.port.out.ICreateurPerimetre;
import com.nicolasflandin.predicteur.domain.port.useCase.CreationPerimetreUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreationPerimeterUseCaseBridge {

    @Bean
    public CreationPerimetreUseCase creationPerimetreUseCase(final ICreateurPerimetre creationPerimetreUseCase) {
        return new CreationPerimetreUseCase(creationPerimetreUseCase);
    }
}
