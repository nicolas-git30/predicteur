package com.nicolasflandin.predicteur.application.adapteur;

import com.nicolasflandin.predicteur.application.annotation.AnnotationDomain;
import com.nicolasflandin.predicteur.domain.dto.*;
import com.nicolasflandin.predicteur.domain.port.out.IAlimentateurMatrice;
import com.nicolasflandin.predicteur.job.dataJob.DataJobScope;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@AnnotationDomain
@Service
public class AlimentateurMatriceAdaptateur implements IAlimentateurMatrice {

    private final DataJobScope dataJobScope;

    public AlimentateurMatriceAdaptateur(final DataJobScope dataJobScope) {
        this.dataJobScope = dataJobScope;
    }

    @Override
    public void alimentationMatrice(final @NotNull TirageDto tirageDto) {
        try {
            if (this.dataJobScope != null && this.dataJobScope.NumerosAnalyse != null && tirageDto != null) {

                tirageDto.getNumeroTirage().forEach(item -> {
                    int numeroActuel = item;
                    NumeroAnalyse numeroAnalyse = this.dataJobScope.NumerosAnalyse.get(numeroActuel);
                    numeroAnalyse.setNombreSorties(numeroAnalyse.getNombreSorties() + 1);
                    numeroAnalyse.setNouvelleDateSortie(tirageDto.getDateTirage());
                    if (numeroAnalyse.getAncienneDateSortie() == null) {
                        numeroAnalyse.setAncienneDateSortie(tirageDto.getDateTirage());
                    }

                    tirageDto.getNumeroTirage().forEach(itemCombi -> {
                        if (!itemCombi.equals(numeroActuel)) {
                            NumeroCombinaison numeroCombi =
                                    numeroAnalyse.getNumeroCombinaison().get(itemCombi);
                            numeroCombi.setNombreCombinaison(numeroCombi.getNombreCombinaison() + 1);
                            numeroAnalyse.getNumeroCombinaison().put(itemCombi, numeroCombi);
                        }
                    });

                    tirageDto.getEtoileTirage().forEach(itemEtoile -> {
                        int etoileActuelle = itemEtoile;
                        EtoileAnalyse etoileAnalyse = this.dataJobScope.EtoilesAnalyse.get(etoileActuelle);
                        etoileAnalyse.setNombreSorties(etoileAnalyse.getNombreSorties() + 1);
                        etoileAnalyse.setNouvelleDateSortie(tirageDto.getDateTirage());
                        if (etoileAnalyse.getAncienneDateSortie() == null) {
                            etoileAnalyse.setAncienneDateSortie(tirageDto.getDateTirage());
                        }

                        tirageDto.getEtoileTirage().forEach(itemCombi -> {
                            if (!itemCombi.equals(etoileActuelle)) {
                                EtoileCombinaison etoileCombinaison =
                                        etoileAnalyse.getEtoileCombinaison().get(itemCombi);
                                etoileCombinaison.setNombreCombinaison(etoileCombinaison.getNombreCombinaison() + 1);
                                etoileAnalyse.getEtoileCombinaison().put(itemCombi, etoileCombinaison);
                            }
                        });
                    });
                    this.dataJobScope.NumerosAnalyse.put(item, numeroAnalyse);
                    Logger.getLogger("test").info(String.format("toto"));
                });
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
