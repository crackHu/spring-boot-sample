package com.senior.sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.senior.sample.repository"}, enableDefaultTransactions = false)
@Configuration
public class JpaTransactionConfig {
}