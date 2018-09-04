package com.twigcodes.commons;

import com.twigcodes.commons.config.PropertyTestConfiguration;
import com.twigcodes.commons.config.SwaggerAutoConfiguration;
import org.junit.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.WebApplicationContextRunner;
import org.springframework.test.context.ContextConfiguration;
import springfox.documentation.spring.web.plugins.Docket;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = PropertyTestConfiguration.class)
public class SwaggerConfigTest {
    private final WebApplicationContextRunner contextRunner = new WebApplicationContextRunner()
        .withPropertyValues("commons.swaggerApiInfo.scanPackages=com.twigcodes")
        .withConfiguration(AutoConfigurations.of(SwaggerAutoConfiguration.class));

    @Test
    public void testProblemModulesCorrectlyConfigured() {
        this.contextRunner
            .run((context) -> assertThat(context).hasSingleBean(Docket.class));
    }
}