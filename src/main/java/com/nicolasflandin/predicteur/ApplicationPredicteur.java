package com.nicolasflandin.predicteur;

import com.nicolasflandin.predicteur.application.annotation.AnnotationJob;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@AnnotationJob
public class ApplicationPredicteur {
    public static void main(String[] args) {

        final ConfigurableApplicationContext ctx = new SpringApplicationBuilder(ApplicationPredicteur.class)
                .web(WebApplicationType.NONE)
                .run(args);
        final ExitCodeGenerator exitCodeGen = ctx.getBean(ExitCodeGenerator.class);
        final int exitCode = exitCodeGen.getExitCode();
        ctx.close();
        System.exit(exitCode);
    }
}
