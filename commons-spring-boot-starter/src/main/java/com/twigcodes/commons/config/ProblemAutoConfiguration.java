package com.twigcodes.commons.config;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.module.afterburner.AfterburnerModule;
import com.twigcodes.commons.problem.ExceptionTranslator;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.zalando.problem.Problem;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.validation.ConstraintViolationProblemModule;

@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass({ Problem.class, AfterburnerModule.class })
@ConditionalOnMissingBean({ AfterburnerModule.class, ProblemModule.class, ConstraintViolationProblemModule.class })
public class ProblemAutoConfiguration {
    /*
     * 使用 Jackson Afterburner 模块加速 序列化和反序列化过程
     */
    @Bean
    public AfterburnerModule afterburnerModule() {
        return new AfterburnerModule();
    }

    /*
     * 用于序列化和反序列化 RFC7807 Problem 对象的模块。
     */
    @Bean
    ProblemModule problemModule() {
        return new ProblemModule();
    }

    /*
     * 用于序列化和反序列化 ConstraintViolationProblem 的模块
     */
    @Bean
    ConstraintViolationProblemModule constraintViolationProblemModule() {
        return new ConstraintViolationProblemModule();
    }

    @Bean
    @ConditionalOnMissingBean(annotation = ControllerAdvice.class)
    public ExceptionTranslator exceptionTranslator(HttpServletRequest request) {
        return new ExceptionTranslator(request);
    }
}
