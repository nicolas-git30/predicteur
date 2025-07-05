package com.nicolasflandin.predicteur.domain.service;

import com.nicolasflandin.predicteur.application.annotation.AnnotationDomain;
import com.nicolasflandin.predicteur.domain.dto.ItemAnalyse;
import com.nicolasflandin.predicteur.domain.dto.ItemCombinaison;
import com.nicolasflandin.predicteur.domain.enums.EnumTypeItem;
import com.nicolasflandin.predicteur.domain.exception.ExceptionUpdateItemAnalyse;
import com.nicolasflandin.predicteur.domain.port.out.IAlimentateurMatrice;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
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
            itemAnalyse.setNombreJoursDelta(0);
        } else {
            Long nombreJour = ChronoUnit.DAYS.between(dateSortie, itemAnalyse.getAncienneDateSortie());
            Integer nombreDelta = (nombreJour.intValue() + itemAnalyse.getNombreJoursDelta())
                    / (itemAnalyse.getNombreJoursDelta().equals(0) ? 1 : 2);
            itemAnalyse.setNombreJoursDelta(nombreDelta);
            itemAnalyse.setAncienneDateSortie(dateSortie);
            System.out.println("nombreDelta = " + nombreDelta);
        }
    }

    public void updateItemCombinaison(
            @NotNull final List<Integer> listItemTirage,
            @NotNull final Integer itemActuel,
            @NotNull ItemAnalyse itemAnalyse,
            @NotNull final String typeCombinaison,
            @NotNull final String typeAnalyse) {
        listItemTirage.forEach(item -> {
            try {
                if (!(item.equals(itemActuel) && typeAnalyse.equals(typeCombinaison))) {
                    if (EnumTypeItem.ETOILE.getValue().equals(typeCombinaison)) {
                        itemAnalyse
                                .getEtoileCombinaison()
                                .put(item, updateItemCombinaison(item, itemAnalyse.getEtoileCombinaison()));
                    } else {
                        itemAnalyse
                                .getNumeroCombinaison()
                                .put(item, updateItemCombinaison(item, itemAnalyse.getNumeroCombinaison()));
                    }
                }
            } catch (Exception e) {
                throw new ExceptionUpdateItemAnalyse(e);
            }
        });
    }

    private ItemCombinaison updateItemCombinaison(
            @NotNull final Integer numero, @NotNull final Map<Integer, ItemCombinaison> map) {
        try {
            ItemCombinaison itemCombinaison = map.get(numero);
            itemCombinaison.setNombreCombinaison(itemCombinaison.getNombreCombinaison() + 1);
            return itemCombinaison;
        } catch (Exception e) {
            throw new ExceptionUpdateItemAnalyse(e);
        }
    }
}
