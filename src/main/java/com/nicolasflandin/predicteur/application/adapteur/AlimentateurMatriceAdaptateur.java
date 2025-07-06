package com.nicolasflandin.predicteur.application.adapteur;

import com.nicolasflandin.predicteur.application.annotation.AnnotationApplication;
import com.nicolasflandin.predicteur.domain.dto.TirageDto;
import com.nicolasflandin.predicteur.domain.dto.analyse.EtoileAnalyse;
import com.nicolasflandin.predicteur.domain.dto.analyse.NumeroAnalyse;
import com.nicolasflandin.predicteur.domain.enums.EnumTypeItem;
import com.nicolasflandin.predicteur.domain.port.out.IAlimentateurMatrice;
import com.nicolasflandin.predicteur.domain.service.AlimentateurMatriceAbstract;
import com.nicolasflandin.predicteur.job.dataJob.DataJobScope;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
@AnnotationApplication
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

                tirageDto.getNumeroTirage().forEach(item -> {
                    NumeroAnalyse numeroAnalyse = this.dataJobScope.NumerosAnalyse.get(item);
                    this.updateItemAnalyse(numeroAnalyse, tirageDto.getDateTirage());
                    this.updateItemCombinaison(
                            tirageDto.getNumeroTirage(),
                            item,
                            numeroAnalyse,
                            EnumTypeItem.NUMERO.getValue(),
                            EnumTypeItem.NUMERO.getValue());
                    this.updateItemCombinaison(
                            tirageDto.getEtoileTirage(),
                            item,
                            numeroAnalyse,
                            EnumTypeItem.ETOILE.getValue(),
                            EnumTypeItem.NUMERO.getValue());
                    this.dataJobScope.NumerosAnalyse.put(item, numeroAnalyse);
                });

                tirageDto.getEtoileTirage().forEach(item -> {
                    EtoileAnalyse etoileAnalyse = this.dataJobScope.EtoilesAnalyse.get(item);
                    this.updateItemAnalyse(etoileAnalyse, tirageDto.getDateTirage());
                    this.updateItemCombinaison(
                            tirageDto.getEtoileTirage(),
                            item,
                            etoileAnalyse,
                            EnumTypeItem.ETOILE.getValue(),
                            EnumTypeItem.ETOILE.getValue());
                    this.dataJobScope.EtoilesAnalyse.put(item, etoileAnalyse);
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
