package com.nicolasflandin.predicteur.job.dataJob;

import com.nicolasflandin.predicteur.domain.dto.EtoileAnalyse;
import com.nicolasflandin.predicteur.domain.dto.NumeroAnalyse;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@JobScope
@Scope
public class DataJobScope implements Serializable {

    public Map<Integer, NumeroAnalyse> NumerosAnalyse;
    public Map<Integer, EtoileAnalyse> EtoilesAnalyse;

    public DataJobScope() {
        NumerosAnalyse = new HashMap<>();
        EtoilesAnalyse = new HashMap<>();

        for (int i = 1; i < 12; i++) {
            this.EtoilesAnalyse.put(i, new EtoileAnalyse(i));
        }
        for (int i = 1; i < 50; i++) {
            this.NumerosAnalyse.put(i, new NumeroAnalyse(i));
        }
    }

    public Map<Integer, NumeroAnalyse> getNumerosAnalyse() {
        return NumerosAnalyse;
    }

    public void setNumerosAnalyse(final Map<Integer, NumeroAnalyse> numerosAnalyse) {
        NumerosAnalyse = numerosAnalyse;
    }

    public Map<Integer, EtoileAnalyse> getEtoilesAnalyse() {
        return EtoilesAnalyse;
    }

    public void setEtoilesAnalyse(final Map<Integer, EtoileAnalyse> etoilesAnalyse) {
        EtoilesAnalyse = etoilesAnalyse;
    }
}
