package com.twigcodes.commons.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;

@Configuration
@EnableWebMvc
public class PropertyTestConfiguration {
    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() throws IOException {
        final PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocations(
            new PathMatchingResourcePatternResolver().getResources("classpath*:application.properties")
        );

        return ppc;
    }

}
