package com.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by binlix26 on 4/06/17.
 */
@Configuration
@PropertySource(value = {"classpath:messages.properties"})
public class AppConfig {
}
