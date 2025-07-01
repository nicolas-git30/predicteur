package com.nicolasflandin.predicteur.bootstrap;

import com.nicolasflandin.predicteur.domain.port.out.ICreationPerimetre;
import com.nicolasflandin.predicteur.domain.port.useCase.CreationPerimetreUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreationPerimeterUseCaseBridge {

    @Bean
    public CreationPerimetreUseCase creationPerimetreUseCase(ICreationPerimetre creationPerimetreUseCase){
        return new CreationPerimetreUseCase(creationPerimetreUseCase);
    }
}
