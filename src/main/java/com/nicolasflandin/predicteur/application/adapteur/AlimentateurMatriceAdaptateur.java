package com.nicolasflandin.predicteur.application.adapteur;

import com.nicolasflandin.predicteur.application.annotation.AnnotationDomain;
import com.nicolasflandin.predicteur.domain.dto.EtoileAnalyse;
import com.nicolasflandin.predicteur.domain.dto.NumeroAnalyse;
import com.nicolasflandin.predicteur.domain.dto.TirageDto;
import com.nicolasflandin.predicteur.domain.port.out.IAlimentateurMatrice;
import com.nicolasflandin.predicteur.domain.service.AlimentateurMatriceAbstract;
import com.nicolasflandin.predicteur.job.dataJob.DataJobScope;
import java.util.logging.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@AnnotationDomain
@Service
public class AlimentateurMatriceAdaptateur extends AlimentateurMatriceAbstract implements IAlimentateurMatrice {

    private final DataJobScope dataJobScope;

    public AlimentateurMatriceAdaptateur(final DataJobScope dataJobScope) {
        this.dataJobScope = dataJobScope;
    }

    @Override
    public void alimentationMatrice(final @NotNull TirageDto tirageDto) {
        try {
            if (this.dataJobScope != null
                    && this.dataJobScope.NumerosAnalyse != null
                    && this.dataJobScope.EtoilesAnalyse != null
                    && tirageDto != null) {

                // parcour sur les numéros du tirage
                tirageDto.getNumeroTirage().forEach(item -> {
                    NumeroAnalyse numeroAnalyse = this.dataJobScope.NumerosAnalyse.get(item);
                    this.updateItemAnalyse(numeroAnalyse, tirageDto.getDateTirage());

                    tirageDto.getNumeroTirage().forEach(itemCombi -> {
                        if (!itemCombi.equals(item)) {
                            numeroAnalyse
                                    .getNumeroCombinaison()
                                    .put(
                                            itemCombi,
                                            this.updateItemCombinaison(
                                                    itemCombi, numeroAnalyse.getNumeroCombinaison()));
                        }
                    });
                    tirageDto.getEtoileTirage().forEach(itemCombi -> {
                        numeroAnalyse
                                .getEtoileCombinaison()
                                .put(
                                        itemCombi,
                                        this.updateItemCombinaison(itemCombi, numeroAnalyse.getEtoileCombinaison()));
                    });
                    this.dataJobScope.NumerosAnalyse.put(item, numeroAnalyse);
                });

                // parcour sur les étoiles du tirage
                tirageDto.getEtoileTirage().forEach(item -> {
                    EtoileAnalyse etoileAnalyse = this.dataJobScope.EtoilesAnalyse.get(item);
                    this.updateItemAnalyse(etoileAnalyse, tirageDto.getDateTirage());

                    tirageDto.getEtoileTirage().forEach(itemCombi -> {
                        if (!itemCombi.equals(item)) {
                            etoileAnalyse
                                    .getEtoileCombinaison()
                                    .put(
                                            itemCombi,
                                            this.updateItemCombinaison(
                                                    itemCombi, etoileAnalyse.getEtoileCombinaison()));
                        }
                    });
                    this.dataJobScope.EtoilesAnalyse.put(item, etoileAnalyse);
                });
                Logger.getLogger("toto").info("toto");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
