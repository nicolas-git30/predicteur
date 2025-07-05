package com.nicolasflandin.predicteur.domain.service;

import com.nicolasflandin.predicteur.application.annotation.AnnotationDomain;
import com.nicolasflandin.predicteur.domain.dto.ItemAnalyse;
import com.nicolasflandin.predicteur.domain.dto.ItemCombinaison;
import com.nicolasflandin.predicteur.domain.port.out.IAlimentateurMatrice;
import java.time.LocalDate;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

@AnnotationDomain
public abstract class AlimentateurMatriceAbstract implements IAlimentateurMatrice {

    public AlimentateurMatriceAbstract() {}

    public void updateItemAnalyse(@NotNull ItemAnalyse itemAnalyse, @NotNull final LocalDate dateSortie) {
        itemAnalyse.setNombreSorties(itemAnalyse.getNombreSorties() + 1);
        itemAnalyse.setNouvelleDateSortie(dateSortie);
        if (itemAnalyse.getAncienneDateSortie() == null) {
            itemAnalyse.setAncienneDateSortie(dateSortie);
        }
    }

    public ItemCombinaison updateItemCombinaison(
            @NotNull final Integer numero, @NotNull final Map<Integer, ItemCombinaison> map) {
        ItemCombinaison itemCombinaison = map.get(numero);
        itemCombinaison.setNombreCombinaison(itemCombinaison.getNombreCombinaison() + 1);
        return itemCombinaison;
    }
}
