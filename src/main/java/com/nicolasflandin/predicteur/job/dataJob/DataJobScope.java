package com.nicolasflandin.predicteur.job.dataJob;

import com.nicolasflandin.predicteur.application.annotation.AnnotationJob;
import com.nicolasflandin.predicteur.domain.dto.analyse.EtoileAnalyse;
import com.nicolasflandin.predicteur.domain.dto.analyse.NumeroAnalyse;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Component
@JobScope
@Scope
@AnnotationJob
public class DataJobScope implements Serializable {

    public Map<Integer, NumeroAnalyse> NumerosAnalyse;
    public Map<Integer, EtoileAnalyse> EtoilesAnalyse;

    public DataJobScope() {
        NumerosAnalyse = new HashMap<>();
        EtoilesAnalyse = new HashMap<>();

        for (int i = 1; i < 13; i++) {
            this.EtoilesAnalyse.put(i, new EtoileAnalyse(i));
        }
        for (int i = 1; i < 51; i++) {
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
