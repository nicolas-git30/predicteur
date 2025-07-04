package com.nicolasflandin.predicteur.job.item.listener;

import com.nicolasflandin.predicteur.application.annotation.AnnotationJob;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@AnnotationJob
@Component
public class BatchListener implements JobExecutionListener {

    public BatchListener() {
        super();
    }

    private static final Logger LOGGER = Logger.getLogger(BatchListener.class.getName());

    @Override
    public void beforeJob(org.springframework.batch.core.JobExecution jobExecution) {
        LOGGER.log(Level.INFO, "Lancement du job");
    }

    @Override
    public void afterJob(org.springframework.batch.core.JobExecution jobExecution) {
        LOGGER.log(Level.INFO, "Fin du job");
    }
}
