package com.nicolasflandin.predicteur.job.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "batch-properties")
public class BatchProperties {
    private int chunkSize;
    private String jobName;

    public int getChunkSize() {
        return chunkSize;
    }

    public void setChunkSize(int chunkSize) {
        this.chunkSize = chunkSize;
    }

    public String getJobName() {
        return jobName;
    }
}
