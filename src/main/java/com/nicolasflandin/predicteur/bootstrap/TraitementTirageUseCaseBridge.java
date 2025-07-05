package com.nicolasflandin.predicteur.bootstrap;

import com.nicolasflandin.predicteur.domain.port.out.IAlimentateurMatrice;
import com.nicolasflandin.predicteur.domain.port.useCase.TraitementTirageUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TraitementTirageUseCaseBridge {

    @Bean
    public TraitementTirageUseCase TraitementTirageUseCase(final IAlimentateurMatrice alimentateurMatrice) {
        return new TraitementTirageUseCase(alimentateurMatrice);
    }
}
