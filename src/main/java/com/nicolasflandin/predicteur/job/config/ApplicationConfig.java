package com.nicolasflandin.predicteur.job.config;

import com.nicolasflandin.predicteur.domain.dto.TirageDto;
import com.nicolasflandin.predicteur.job.config.properties.BatchProperties;
import com.nicolasflandin.predicteur.job.utils.ItemSkipPolicy;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan(basePackages = { "com.nicolasflandin.predicteur" })
@EnableConfigurationProperties({BatchProperties.class })
@EnableAutoConfiguration
public class ApplicationConfig {

    private final ItemReader<TirageDto> reader;
    private final ItemProcessor<TirageDto, TirageDto> processor;
    private final ItemWriter<TirageDto> writer;
    private final BatchProperties batchProperties;
    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final JobExecutionListener listener;

    public ApplicationConfig(final ItemReader<TirageDto> reader, final ItemProcessor<TirageDto, TirageDto> processor,
            final ItemWriter<TirageDto> writer, final BatchProperties batchProperties, final JobRepository jobRepository,
            final PlatformTransactionManager transactionManager, final JobExecutionListener listener) {
        super();
        this.reader = reader;
        this.processor = processor;
        this.writer = writer;
        this.batchProperties = batchProperties;
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
        this.listener = listener;
    }

    @Bean
    public Step predictionNumberStep() {
        return new StepBuilder("predictionNumberStep", jobRepository).<TirageDto, TirageDto>chunk(
                        batchProperties.getChunkSize(), transactionManager).faultTolerant().skipPolicy(new ItemSkipPolicy())
                .skip(Throwable.class).noRetry(Throwable.class).noRollback(Throwable.class).reader(reader)
                .processor(processor).writer(writer).build();
    }

    @Bean
    public Job job() {
        return new JobBuilder(batchProperties.getJobName(), jobRepository).incrementer(new RunIdIncrementer())
                .preventRestart().listener(listener).start(predictionNumberStep()).build();
    }

}
