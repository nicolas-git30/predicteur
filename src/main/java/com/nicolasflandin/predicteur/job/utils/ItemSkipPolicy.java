package com.nicolasflandin.predicteur.job.utils;

import com.nicolasflandin.predicteur.application.annotation.AnnotationJob;
import jakarta.annotation.Nonnull;
import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;

@AnnotationJob
public class ItemSkipPolicy implements SkipPolicy {

    @Override
    public boolean shouldSkip(final @Nonnull Throwable t, final long skipCount) throws SkipLimitExceededException {
        return true;
    }
}
