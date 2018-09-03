package com.twigcodes.commons;

import com.fasterxml.jackson.module.afterburner.AfterburnerModule;
import com.twigcodes.commons.config.ProblemAutoConfiguration;
import com.twigcodes.commons.problem.ExceptionTranslator;

import org.junit.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.WebApplicationContextRunner;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.validation.ConstraintViolationProblemModule;

import static org.assertj.core.api.Assertions.*;

public class ProblemConfigTest {
    private final WebApplicationContextRunner contextRunner = new WebApplicationContextRunner()
        .withConfiguration(AutoConfigurations.of(ProblemAutoConfiguration.class));

    @Test
    public void testProblemModulesCorrectlyConfigured() {
        this.contextRunner
            .withUserConfiguration(ExceptionTranslator.class)
            .run((context) -> {
                assertThat(context).hasSingleBean(AfterburnerModule.class);
                assertThat(context).hasSingleBean(ProblemModule.class);
                assertThat(context).hasSingleBean(ConstraintViolationProblemModule.class);
                assertThat(context).hasSingleBean(ExceptionTranslator.class);
            });
    }
}
