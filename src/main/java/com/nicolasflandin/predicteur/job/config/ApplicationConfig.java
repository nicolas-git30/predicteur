package com.nicolasflandin.predicteur.job.config;

import com.nicolasflandin.predicteur.application.annotation.AnnotationJob;
import com.nicolasflandin.predicteur.domain.dto.TirageDto;
import com.nicolasflandin.predicteur.domain.dto.analyse.NumeroAnalyse;
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
@ComponentScan(basePackages = {"com.nicolasflandin.predicteur"})
@EnableConfigurationProperties({BatchProperties.class})
@EnableAutoConfiguration
@AnnotationJob
public class ApplicationConfig {

    private final ItemReader<TirageDto> reader;
    private final ItemReader<NumeroAnalyse> readerNumeroAnalyse;
    private final ItemProcessor<TirageDto, TirageDto> processor;
    private final ItemProcessor<NumeroAnalyse, NumeroAnalyse> processorNumeroAnalyse;
    private final ItemWriter<TirageDto> writer;
    private final ItemWriter<NumeroAnalyse> writerNumeroAnalyse;
    private final BatchProperties batchProperties;
    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final JobExecutionListener listener;

    public ApplicationConfig(
            final ItemReader<TirageDto> reader,
            final ItemReader<NumeroAnalyse> readerNumeroAnalyse,
            final ItemProcessor<TirageDto, TirageDto> processor,
            final ItemProcessor<NumeroAnalyse, NumeroAnalyse> processorNumeroAnalyse,
            final ItemWriter<NumeroAnalyse> writerNumeroAnalyse,
            final ItemWriter<TirageDto> writer,
            final BatchProperties batchProperties,
            final JobRepository jobRepository,
            final PlatformTransactionManager transactionManager,
            final JobExecutionListener listener) {
        super();
        this.reader = reader;
        this.writer = writer;
        this.processor = processor;
        this.processorNumeroAnalyse = processorNumeroAnalyse;
        this.readerNumeroAnalyse = readerNumeroAnalyse;
        this.writerNumeroAnalyse = writerNumeroAnalyse;
        this.batchProperties = batchProperties;
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
        this.listener = listener;
    }

    @Bean
    public Step alimentationMatriceStep() {
        return new StepBuilder("alimentationMatriceStep", jobRepository)
                .<TirageDto, TirageDto>chunk(batchProperties.getChunkSize(), transactionManager)
                .faultTolerant()
                .skipPolicy(new ItemSkipPolicy())
                .noRetry(Throwable.class)
                .noRollback(Throwable.class)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public Step CalculateurNumeroMatriceStep() {
        return new StepBuilder("CalculateurNumeroMatriceStep", jobRepository)
                .<NumeroAnalyse, NumeroAnalyse>chunk(batchProperties.getChunkSize(), transactionManager)
                .faultTolerant()
                .skipPolicy(new ItemSkipPolicy())
                .noRetry(Throwable.class)
                .noRollback(Throwable.class)
                .reader(readerNumeroAnalyse)
                .processor(processorNumeroAnalyse)
                .writer(writerNumeroAnalyse)
                .build();
    }

    @Bean
    public Job job() {
        return new JobBuilder(batchProperties.getJobName(), jobRepository)
                .incrementer(new RunIdIncrementer())
                .preventRestart()
                .listener(listener)
                .start(alimentationMatriceStep())
                .next(CalculateurNumeroMatriceStep())
                .build();
    }
}
