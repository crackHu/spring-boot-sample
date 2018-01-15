package com.senior.sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(enableDefaultTransactions = false)
@Configuration
public class JpaTransactionConfig {
}